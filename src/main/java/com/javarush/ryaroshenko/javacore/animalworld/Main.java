package com.javarush.ryaroshenko.javacore.animalworld;

import com.javarush.ryaroshenko.javacore.animalworld.hierarchy.Animal;
import com.javarush.ryaroshenko.javacore.animalworld.hierarchy.Plant;
import com.javarush.ryaroshenko.javacore.animalworld.hierarchy.Wolf;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello animal world!");
        Animal plant = new Plant();
        System.out.println(plant.getClass().getSimpleName() + " sex " + plant.getGender());
        Animal wolf1 = new Wolf();
        System.out.println(wolf1.getClass().getSimpleName() + " sex " + wolf1.getGender());
        Animal wolf2 = new Wolf();
        System.out.println(wolf2.getClass().getSimpleName() + " sex " + wolf2.getGender());
    }
}