package com.javarush.ryaroshenko.javacore.animalworld.hierarchy;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Миша
 */
public class Mouse extends Herbivorous {
    public Mouse() {
        this.species = "\uD83D\uDC01";
        this.weight = 0.05;
        this.speed = 1;
        this.appetite = 0.01;
        this.pregnantTerm = ThreadLocalRandom.current().nextDouble(16.0, 26.0);
    }
}
