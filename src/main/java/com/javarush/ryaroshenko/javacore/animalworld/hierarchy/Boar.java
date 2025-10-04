package com.javarush.ryaroshenko.javacore.animalworld.hierarchy;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Кабан
 */
public class Boar extends Herbivorous {
    public Boar() {
        this.species = "\uD83D\uDC17";
        this.weight = 400.0;
        this.speed = 2;
        this.appetite = 50.0;
        this.pregnantTerm = ThreadLocalRandom.current().nextDouble(100.0, 128.0);
    }
}
