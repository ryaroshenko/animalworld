package com.javarush.ryaroshenko.javacore.animalworld.hierarchy;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Олень
 */
public class Deer extends Herbivorous {
    public Deer() {
        this.species = "\uD83E\uDD8C";
        this.weight = 300.0;
        this.speed = 4;
        this.appetite = 50.0;
        this.pregnantTerm = ThreadLocalRandom.current().nextDouble(220.0, 251.0);
    }
}
