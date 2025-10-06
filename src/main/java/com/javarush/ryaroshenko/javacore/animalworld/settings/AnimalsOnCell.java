package com.javarush.ryaroshenko.javacore.animalworld.settings;

import com.javarush.ryaroshenko.javacore.animalworld.hierarchy.*;

import java.util.HashMap;
import java.util.Map;

public class AnimalsOnCell {
    private static final AnimalsOnCell ANIMALS_ON_CELL = new AnimalsOnCell();

    private Map<String, Integer> map = new HashMap<>(){{
        put(Wolf.class.getName(), 30);
        put(Boa.class.getName(), 30);
        put(Fox.class.getName(), 30);
        put(Bear.class.getName(), 5);
        put(Eagle.class.getName(), 20);
        put(Horse.class.getName(), 20);
        put(Deer.class.getName(), 20);
        put(Rabbit.class.getName(), 150);
        put(Mouse.class.getName(), 500);
        put(Goat.class.getName(), 140);
        put(Sheep.class.getName(), 140);
        put(Boar.class.getName(), 50);
        put(Buffalo.class.getName(), 10);
        put(Duck.class.getName(), 200);
        put(Caterpillar.class.getName(), 1000);
        put(Plant.class.getName(), 200);
    }};

    private AnimalsOnCell() {
    }

    public static AnimalsOnCell getInstance() {
        return ANIMALS_ON_CELL;
    }

    public int getCount(String className) {
        return map.getOrDefault(className, 0);
    }

    public Map<String, Integer> getMap() {
        return map;
    }
}
