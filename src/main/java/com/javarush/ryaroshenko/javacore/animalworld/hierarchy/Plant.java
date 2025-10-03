package com.javarush.ryaroshenko.javacore.animalworld.hierarchy;

public class Plant extends Animal {
    public Plant() {
        this.weight = 1.0;
        this.speed = 0;
        this.appetite = 0.0;
    }

    @Override
    public Gender getGender() {
        if (this.gender == null)
            this.gender = Gender.ASEXUAL;
        return this.gender;
    }
}
