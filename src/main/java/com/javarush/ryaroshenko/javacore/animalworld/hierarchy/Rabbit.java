package com.javarush.ryaroshenko.javacore.animalworld.hierarchy;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Кролик
 */
public class Rabbit extends Herbivorous {
    public Rabbit() {
        this.species = "\uD83D\uDC07";
        this.weight = 2.0;
        this.speed = 2;
        this.appetite = 0.45;
        this.pregnantTerm = 32;
    }
}
