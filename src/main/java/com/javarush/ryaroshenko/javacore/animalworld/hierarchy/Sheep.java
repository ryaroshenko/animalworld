package com.javarush.ryaroshenko.javacore.animalworld.hierarchy;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Вівця
 */
public class Sheep extends Herbivorous {
    public Sheep() {
        this.species = "\uD83D\uDC11";
        this.weight = 70.0;
        this.speed = 3;
        this.appetite = 15.0;
        this.pregnantTerm = ThreadLocalRandom.current().nextDouble(148.0, 151.0);
    }
}
