package com.javarush.ryaroshenko.javacore.animalworld.hierarchy;

public class Plant extends Animal {
    public Plant() {
        this.weight = 1.0;
        this.delta = 0.0;
        this.gender = Gender.ASEXUAL;
        this.speed = 0;
        this.appetite = 0;
    }
}
