package com.javarush.ryaroshenko.javacore.animalworld.hierarchy;

import com.javarush.ryaroshenko.javacore.animalworld.land.*;
import com.javarush.ryaroshenko.javacore.animalworld.settings.*;

import java.lang.reflect.InvocationTargetException;
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
    // Швидкість (кількість клітинок на годину)
    protected int speed;
    // Апетит (кількість їжи до насичення) (кг)
    protected double appetite;
    // Термін вагітності у днях
    protected double pregnantTerm;
    // Крок збільшення вагітності у днях
    protected double pregnantStep = 4.0 / 24.0;
    // Кількість днів вагітності
    protected double pregnantDays = 0.0;
    // Кількість звіряток, що може народитися
    protected int littleAnimalCount;

    private Cell cell = null;

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

    // Чи мертва тварина?
    public boolean isDead() {
        return getActualWeight() <= weight / 2.0;
    }

    // Чи вагітна тварина?
    public boolean isPregnant() {
        return !isDead() && getGender() == Gender.FEMALE && pregnantDays >= pregnantStep;
    }

    // Чи голодна тварина?
    public boolean isHungry() {
        return !isDead() && getActualWeight() < weight;
    }

    public void startPregnant() {
        if (!isDead() && getGender() == Gender.FEMALE && pregnantDays < pregnantStep && littleAnimalCount > 0 && getCell() != null) {
            List<Box> list = getCell().getMap().get(getClass().getName());
            if (list.size() < AnimalsOnCell.getInstance().getCount(getClass().getName())) {
                pregnantDays = pregnantStep;
                System.out.println(getSpecies() + " зпарувалися");
            }
        }
    }

    public void incPregnantDays() {
        if (isPregnant()) {
            pregnantDays += pregnantStep;
            if (pregnantDays > pregnantTerm)
                birth();
            else
                System.out.println(getSpecies() + " вагітність " + pregnantDays + " днів");
        }
    }

    // Зпаруватися
    public void mate(Animal animal) {
        if (animal != null && animal != this)
            if (animal.getClass().getName().equals(getClass().getName()) && animal.getGender() != getGender()) {
                Animal female = getGender() == Gender.FEMALE ? this : animal;
                female.startPregnant();
            }
    }

    // Народити
    public void birth() {
        if (!isDead() && getGender() == Gender.FEMALE && pregnantDays > pregnantTerm && littleAnimalCount > 0 && getCell() != null) {
            for (int i = 1; i <= littleAnimalCount; i++)
                Animal.newAnimal(getClass(), getCell());
            pregnantDays = 0.0;
            System.out.println("Самка " + getSpecies() + " народила " + littleAnimalCount + " звірят");
        }
    }

    @Override
    public String toString() {
        if (fullInfo)
            return String.format("%s (Вага: %4.3f; Стать: %s%s; Стан: %s)", getSpecies(), getActualWeight(), getGender(),
                    isPregnant() ? " (Вагітна)" : "",
                    isDead() ? "Мертва" : isHungry() ? "Голодна" : "Здорова");
        else
            return getSpecies();
    }

    public Cell getCell() {
        return cell;
    }

    public void setCell(Cell cell) {
        if (!isDead() && this.cell != cell) {
            if (this.cell != null) {
                List<Box> list = this.cell.getMap().get(getClass().getName());
                int i = 0;
                while (i < list.size()) {
                    if (list.get(i).getAnimal() == this) {
                        list.get(i).setAnimal(null);
                        list.remove(i);
                    } else
                        i++;
                }
            }
            this.cell = cell;
            if (cell != null) {
                List<Box> list = cell.getMap().get(getClass().getName());
                list.add(new Box(this));
            }
        }
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

    public static Animal newAnimal(Class<?> animalClass, Cell cell) {
        Animal animal;
        try {
            animal = (Animal) animalClass.getDeclaredConstructor().newInstance();
            animal.setCell(cell);
        } catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException |
                 IllegalArgumentException |
                 InvocationTargetException e) {
            animal = null;
        }
        return animal;
    }
}
