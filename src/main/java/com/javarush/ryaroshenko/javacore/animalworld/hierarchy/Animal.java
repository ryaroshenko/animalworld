package com.javarush.ryaroshenko.javacore.animalworld.hierarchy;

import com.javarush.ryaroshenko.javacore.animalworld.settings.EatMenu;

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
    protected double pregnantStep = 1.0 / 24.0;
    // Кількість днів вагітності
    protected double pregnantDays = 0.0;

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
        if (animal.getClass().getSimpleName() != getClass().getSimpleName()) {
            int maxProbability = EatMenu.getInstance().getMaxProbability(getClass().getSimpleName(), animal.getClass().getSimpleName());
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
        return getGender() == Gender.FEMALE && pregnantDays >= pregnantStep;
    }

    // Чи голодна тварина?
    public boolean isHungry() {
        return !isDead() && getActualWeight() < weight;
    }

    public void startPregnant() {
        if (getGender() == Gender.FEMALE && pregnantDays < pregnantStep)
            pregnantDays = pregnantStep;
    }

    public void incPregnantDays() {
        if (isPregnant())
            pregnantDays += pregnantStep;
    }

    // Зпаруватися
    public void mate(Animal animal) {
        if (animal.getClass().getSimpleName() == getClass().getSimpleName() && animal.getGender() != getGender()) {
            Animal female = getGender() == Gender.FEMALE ? this : animal;
            female.startPregnant();
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
}
