package com.javarush.ryaroshenko.javacore.animalworld.hierarchy;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Лисиця
 */
public class Fox extends Predator {
    public Fox() {
        this.species = "\uD83E\uDD8A";
        this.weight = 8.0;
        this.speed = 2;
        this.appetite = 2.0;
        this.pregnantTerm = ThreadLocalRandom.current().nextDouble(49.0, 59.0);
    }
}
