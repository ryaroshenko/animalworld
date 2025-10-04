package com.javarush.ryaroshenko.javacore.animalworld.hierarchy;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Кінь
 */
public class Horse extends Herbivorous {
    public Horse() {
        this.species = "\uD83D\uDC0E";
        this.weight = 400.0;
        this.speed = 4;
        this.appetite = 60.0;
        this.pregnantTerm = ThreadLocalRandom.current().nextDouble(335.0, 341.0);
    }
}
