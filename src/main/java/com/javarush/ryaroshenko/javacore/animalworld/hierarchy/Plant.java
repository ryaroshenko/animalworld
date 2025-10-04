package com.javarush.ryaroshenko.javacore.animalworld.hierarchy;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Рослина
 */
public class Plant extends Animal {
    public Plant() {
        this.species = "☘\uFE0F";
        this.weight = 1.0;
        this.speed = 0;
        this.appetite = 0.0;
        this.pregnantTerm = 5;
    }
}
