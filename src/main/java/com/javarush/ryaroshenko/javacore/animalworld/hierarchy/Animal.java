package com.javarush.ryaroshenko.javacore.animalworld.hierarchy;

import com.javarush.ryaroshenko.javacore.animalworld.land.*;
import com.javarush.ryaroshenko.javacore.animalworld.settings.*;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Тварина
 */
public abstract class Animal {
    private boolean fullInfo = true;
    // Назва або піктограма тварини
    protected String species = "\uD83E\uDDA0";
    // Вага нормальна (кг)
    protected double weight;
    // Збільшення (+) або зменшення (-) ваги (кг)
    protected double delta = 0.0;
    // Стать
    protected Gender gender = null;
    // Швидкість (максимальна кількість клітинок за одне пересування)
    protected int speed;
    // Апетит (кількість їжи до насичення) (кг)
    protected double appetite;
    // Термін вагітності у днях
    protected double pregnantTerm;
    // Крок збільшення вагітності у днях
    protected double pregnantStep = 1.0;
    // Кількість днів вагітності
    protected double pregnantDays = 0.0;
    // Кількість звіряток, що може народитися
    protected int littleAnimalCount;

    private Cell cell = null;
    private Point newPoint = null;

    // Повернути назву або піктограму тварини
    public String getSpecies() {
        return species;
    }

    // Вага актуальна
    public double getActualWeight() {
        return weight + delta;
    }

    // Повернути стать
    public Gender getGender() {
        if (this.gender == null) {
            int num = ThreadLocalRandom.current().nextInt(0, 2);
            Gender[] genders = {Gender.MALE, Gender.FEMALE};
            this.gender = genders[num];
        }
        return this.gender;
    }

    // Повернути швидкість
    public int getSpeed() {
        return speed;
    }

    // Повернути апетит
    public double getAppetite() {
        return appetite;
    }

    // Повернути ймовірність з'їсти тварину
    public int getEatProbability(Animal animal) {
        int probability = 0;
        if (animal != null && animal != this)
            if (!animal.getClass().getName().equals(getClass().getName())) {
                int maxProbability = EatMenu.getInstance().getMaxProbability(getClass().getName(), animal.getClass().getName());
                if (maxProbability > 0) {
                    probability = ThreadLocalRandom.current().nextInt(1, 101);
                    if (probability > maxProbability)
                        probability = 0;
                }
            }
        return probability;
    }

    // Поїсти
    public boolean eat(Animal animal) {
        boolean result = false;
        if (!isDead() && !isFull() && animal != null) {
            int probability = getEatProbability(animal);
            if (probability > 0) {
                double delta = Math.min(animal.getActualWeight(), getAppetite());
                changeWeight(delta);
                animal.changeWeight(-delta);
                //System.out.println(this + " з'їла " + animal);
                result = true;
            }
        }
        return result;
    }

    // Чи мертва тварина?
    public boolean isDead() {
        return getActualWeight() <= weight / 2.0;
    }

    // Чи вагітна тварина?
    public boolean isPregnant() {
        return !isDead() && getGender() == Gender.FEMALE && pregnantDays >= pregnantStep;
    }

    public boolean isTimeToGiveBirth() {
        return !isDead() && getGender() == Gender.FEMALE && pregnantDays > pregnantTerm;
    }

    //
    public boolean isFull() {
        return getActualWeight() >= weight + getAppetite();
    }

    public void changeWeight(double delta) {
        this.delta += delta;
    }

    public boolean startPregnant() {
        boolean result = false;
        if (!isDead() && getGender() == Gender.FEMALE && pregnantDays < pregnantStep && littleAnimalCount > 0 && getCell() != null) {
            List<Animal> list = getCell().getMap().get(getClass().getName());
            if (list.size() < AnimalsOnCell.getInstance().getCount(getClass().getName())) {
                pregnantDays = pregnantStep;
                System.out.println(this + " зпарувалися");
                result = true;
            }
        }
        return result;
    }

    public void incPregnantDays() {
        if (isPregnant())
            pregnantDays += pregnantStep;
    }

    // Зпаруватися
    public boolean mate(Animal animal) {
        boolean result = false;
        if (!isDead() && animal != null && animal != this)
            if (animal.getClass().getName().equals(getClass().getName()) && animal.getGender() != getGender()) {
                Animal female = getGender() == Gender.FEMALE ? this : animal;
                result = female.startPregnant();
            }
        return result;
    }

    // Народити
    public List<Animal> birth() {
        List<Animal> list = null;
        if (!isDead() && getGender() == Gender.FEMALE && pregnantDays > pregnantTerm && littleAnimalCount > 0 && getCell() != null) {
            list = new ArrayList<>();
            for (int i = 1; i <= littleAnimalCount; i++) {
                Animal animal = Animal.newAnimal(getClass());
                if (animal != null) {
                    list.add(animal);
                    animal.setCell(getCell());
                }
            }
            pregnantDays = 0.0;
            System.out.println("Самка " + this + " народила " + list.size() + " звірят");
        }
        return list;
    }

    // обрати напрямок пересування
    public void determinePointForMoving() {
        if (!isDead() && getCell() != null && getSpeed() > 0 && getNewPoint() == null) {
            int currentSpeed = ThreadLocalRandom.current().nextInt(1, getSpeed() + 1);
            int vector = ThreadLocalRandom.current().nextInt(1, 9);
            int x = getCell().getX(), y = getCell().getY();
            switch (vector) {
                case 1:
                    y -= currentSpeed;
                    break;
                case 2:
                    x += currentSpeed;
                    y -= currentSpeed;
                    break;
                case 3:
                    x += currentSpeed;
                    break;
                case 4:
                    x += currentSpeed;
                    y += currentSpeed;
                    break;
                case 5:
                    y += currentSpeed;
                    break;
                case 6:
                    x -= currentSpeed;
                    y += currentSpeed;
                    break;
                case 7:
                    x -= currentSpeed;
                    break;
                case 8:
                    x -= currentSpeed;
                    y -= currentSpeed;
                    break;
                default:
                    break;
            }
            if (y < 0)
                y += Island.SIZE_Y;
            if (x >= Island.SIZE_X)
                x -= Island.SIZE_X;
            if (y >= Island.SIZE_Y)
                y -= Island.SIZE_Y;
            if (x < 0)
                x += Island.SIZE_X;
            if (x != getCell().getX() || y != getCell().getY())
                setNewPoint(new Point(x, y));
        }
    }

    @Override
    public String toString() {
        if (fullInfo)
            return String.format("%s (Вага: %4.3f; Стать: %s%s; Стан: %s)", getSpecies(), getActualWeight(), getGender(),
                    isPregnant() ? " (Вагітна)" : "",
                    isDead() ? "Мертва" : "Здорова");
        else
            return getSpecies();
    }

    public Cell getCell() {
        return cell;
    }

    public void setCell(Cell cell) {
        if (!isDead() && this.cell != cell)
            this.cell = cell;
    }

    public Point getNewPoint() {
        return newPoint;
    }

    public void setNewPoint(Point newPoint) {
        this.newPoint = newPoint;
    }

    public static Class<?> findClass(String className) {
        Class<?> aClass;
        try {
            aClass = Class.forName(className);
        } catch (ClassNotFoundException e) {
            aClass = null;
        }
        return aClass;
    }

    public static Animal newAnimal(Class<?> animalClass) {
        Animal animal;
        try {
            animal = (Animal) animalClass.getDeclaredConstructor().newInstance();
        } catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException |
                 IllegalArgumentException |
                 InvocationTargetException e) {
            animal = null;
        }
        return animal;
    }
}
