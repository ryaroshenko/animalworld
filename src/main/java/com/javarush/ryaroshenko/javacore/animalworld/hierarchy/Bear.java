package com.javarush.ryaroshenko.javacore.animalworld.hierarchy;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Ведмідь
 */
public class Bear extends Predator {
    public Bear() {
        this.species = "\uD83D\uDC3B";
        this.weight = 500.0;
        this.speed = 2;
        this.appetite = 80.0;
        this.pregnantTerm = ThreadLocalRandom.current().nextDouble(180.0, 241.0);
    }
}
