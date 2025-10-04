package com.javarush.ryaroshenko.javacore.animalworld.hierarchy;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Коза
 */
public class Goat extends Herbivorous {
    public Goat() {
        this.species = "\uD83D\uDC10";
        this.weight = 60.0;
        this.speed = 3;
        this.appetite = 10.0;
        this.pregnantTerm = ThreadLocalRandom.current().nextDouble(145.0, 156.0);
    }
}
