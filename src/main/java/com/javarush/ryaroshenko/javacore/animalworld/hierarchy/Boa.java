package com.javarush.ryaroshenko.javacore.animalworld.hierarchy;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Удав
 */
public class Boa extends Predator {
    public Boa() {
        this.species = "\uD83D\uDC0D";
        this.weight = 15.0;
        this.speed = 1;
        this.appetite = 3.0;
        this.pregnantTerm = ThreadLocalRandom.current().nextDouble(90.0, 101.0);
    }
}
