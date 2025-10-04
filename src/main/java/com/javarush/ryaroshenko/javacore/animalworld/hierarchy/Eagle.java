package com.javarush.ryaroshenko.javacore.animalworld.hierarchy;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Орел
 */
public class Eagle extends Predator {
    public Eagle() {
        this.species = "\uD83E\uDD85";
        this.weight = 6.0;
        this.speed = 3;
        this.appetite = 1.0;
        this.pregnantTerm = 38;
    }
}
