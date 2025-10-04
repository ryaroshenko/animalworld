package com.javarush.ryaroshenko.javacore.animalworld.hierarchy;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Качка
 */
public class Duck extends Herbivorous {
    public Duck() {
        this.species = "\uD83E\uDD86";
        this.weight = 1.0;
        this.speed = 4;
        this.appetite = 0.15;
        this.pregnantTerm = ThreadLocalRandom.current().nextDouble(26.0, 29.0);
    }
}
