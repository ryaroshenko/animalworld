package com.javarush.ryaroshenko.javacore.animalworld;

import com.javarush.ryaroshenko.javacore.animalworld.hierarchy.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello animal world!");
        Animal plant = new Plant();
        Animal wolf1 = new Wolf();
        Animal wolf2 = new Wolf();
        wolf1.mate(wolf2);
        System.out.println(plant);
        System.out.println(wolf1);
        System.out.println(wolf2);
    }
}