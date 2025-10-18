package com.javarush.ryaroshenko.javacore.animalworld.hierarchy;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Гусінь
 */
public class Caterpillar extends Herbivorous {
    public Caterpillar() {
        this.species = "\uD83D\uDC1B";
        this.weight = 0.01;
        this.speed = 0;
        this.appetite = 0.001;
        this.pregnantTerm = ThreadLocalRandom.current().nextDouble(10.0, 15.0);
        this.littleAnimalCount = ThreadLocalRandom.current().nextInt(5, 21);
    }
}
