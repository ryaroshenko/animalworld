package com.javarush.ryaroshenko.javacore.animalworld.hierarchy;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Вовк
 */
public class Wolf extends Predator {
    public Wolf() {
        this.species = "\uD83D\uDC3A";
        this.weight = 50.0;
        this.speed = 3;
        this.appetite = 8.0;
        this.pregnantTerm = ThreadLocalRandom.current().nextDouble(60.0, 66.0);
    }
}
