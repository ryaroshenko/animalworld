package com.javarush.ryaroshenko.javacore.animalworld.hierarchy;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Буйвол
 */
public class Buffalo extends Herbivorous {
    public Buffalo() {
        this.species = "\uD83D\uDC03";
        this.weight = 700.0;
        this.speed = 3;
        this.appetite = 100.0;
        this.pregnantTerm = ThreadLocalRandom.current().nextDouble(262.0, 268.0);
    }
}
