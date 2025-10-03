package com.javarush.ryaroshenko.javacore.animalworld.hierarchy;

public abstract class Animal {
    protected double weight;
    protected double delta;
    protected Gender gender;
    protected int speed;
    protected double appetite;

    public double getActualWeight() {
        return weight + delta;
    }

    public boolean isDead() {
        return (getActualWeight() <= weight / 2.0);
    }

    public Gender getGender() {
        return gender;
    }
}
