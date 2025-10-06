package com.javarush.ryaroshenko.javacore.animalworld.land;

import com.javarush.ryaroshenko.javacore.animalworld.hierarchy.Animal;

public class Box {
    private Animal animal;

    public Box(Animal animal) {
        this.animal = animal;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }
}
