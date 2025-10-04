package com.javarush.ryaroshenko.javacore.animalworld.settings;

import com.javarush.ryaroshenko.javacore.animalworld.hierarchy.*;

import java.util.HashMap;
import java.util.Map;

public class AnimalsOnCell {
    private static final AnimalsOnCell ANIMALS_ON_CELL = new AnimalsOnCell();

    private Map<String, Integer> map = new HashMap<>(){{
        put(Wolf.class.getSimpleName(), 30);
        put(Boa.class.getSimpleName(), 30);
        put(Fox.class.getSimpleName(), 30);
        put(Bear.class.getSimpleName(), 5);
        put(Eagle.class.getSimpleName(), 20);
        put(Horse.class.getSimpleName(), 20);
        put(Deer.class.getSimpleName(), 20);
        put(Rabbit.class.getSimpleName(), 150);
        put(Mouse.class.getSimpleName(), 500);
        put(Goat.class.getSimpleName(), 140);
        put(Sheep.class.getSimpleName(), 140);
        put(Boar.class.getSimpleName(), 50);
        put(Buffalo.class.getSimpleName(), 10);
        put(Duck.class.getSimpleName(), 200);
        put(Caterpillar.class.getSimpleName(), 1000);
        put(Plant.class.getSimpleName(), 200);
    }};

    private AnimalsOnCell() {
    }

    public static AnimalsOnCell getInstance() {
        return ANIMALS_ON_CELL;
    }

    public int getCount(String simpleClassName) {
        return map.getOrDefault(simpleClassName, 0);
    }
}
