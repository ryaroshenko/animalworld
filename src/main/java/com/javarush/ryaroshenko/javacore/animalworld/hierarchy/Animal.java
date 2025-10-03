package com.javarush.ryaroshenko.javacore.animalworld.hierarchy;

import java.util.concurrent.ThreadLocalRandom;

public abstract class Animal {
    protected double weight;
    protected double delta = 0.0;
    protected Gender gender = null;
    protected int speed;
    protected double appetite;

    public double getActualWeight() {
        return weight + delta;
    }

    public boolean isDead() {
        return (getActualWeight() <= weight / 2.0);
    }

    public Gender getGender() {
        if (this.gender == null) {
            int num = ThreadLocalRandom.current().nextInt(2, 4) - 2;
            Gender[] genders = {Gender.MALE, Gender.FEMALE};
            this.gender = genders[num];
        }
        return this.gender;
    }
}
