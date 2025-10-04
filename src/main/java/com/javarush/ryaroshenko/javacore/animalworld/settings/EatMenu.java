package com.javarush.ryaroshenko.javacore.animalworld.settings;

import com.javarush.ryaroshenko.javacore.animalworld.hierarchy.*;

import java.util.HashMap;
import java.util.Map;

public class EatMenu {
    private static final EatMenu EAT_MENU = new EatMenu();

    private Map<String, Map<String, Integer>> map = new HashMap<>();

    private EatMenu() {
        Map<String, Integer> menu;

        map.put(Wolf.class.getSimpleName(), new HashMap<>());
        menu = map.get(Wolf.class.getSimpleName());
        menu.put(Horse.class.getSimpleName(), 10);
        menu.put(Deer.class.getSimpleName(), 15);
        menu.put(Rabbit.class.getSimpleName(), 60);
        menu.put(Mouse.class.getSimpleName(), 80);
        menu.put(Goat.class.getSimpleName(), 60);
        menu.put(Sheep.class.getSimpleName(), 70);
        menu.put(Boar.class.getSimpleName(), 15);
        menu.put(Buffalo.class.getSimpleName(), 10);
        menu.put(Duck.class.getSimpleName(), 40);

        map.put(Boa.class.getSimpleName(), new HashMap<>());
        menu = map.get(Boa.class.getSimpleName());
        menu.put(Fox.class.getSimpleName(), 15);
        menu.put(Rabbit.class.getSimpleName(), 20);
        menu.put(Mouse.class.getSimpleName(), 40);
        menu.put(Duck.class.getSimpleName(), 10);

        map.put(Fox.class.getSimpleName(), new HashMap<>());
        menu = map.get(Fox.class.getSimpleName());
        menu.put(Rabbit.class.getSimpleName(), 70);
        menu.put(Mouse.class.getSimpleName(), 90);
        menu.put(Duck.class.getSimpleName(), 60);
        menu.put(Caterpillar.class.getSimpleName(), 40);

        map.put(Bear.class.getSimpleName(), new HashMap<>());
        menu = map.get(Bear.class.getSimpleName());
        menu.put(Boa.class.getSimpleName(), 80);
        menu.put(Horse.class.getSimpleName(), 40);
        menu.put(Deer.class.getSimpleName(), 80);
        menu.put(Rabbit.class.getSimpleName(), 80);
        menu.put(Mouse.class.getSimpleName(), 90);
        menu.put(Goat.class.getSimpleName(), 70);
        menu.put(Sheep.class.getSimpleName(), 70);
        menu.put(Boar.class.getSimpleName(), 50);
        menu.put(Buffalo.class.getSimpleName(), 20);
        menu.put(Duck.class.getSimpleName(), 10);

        map.put(Eagle.class.getSimpleName(), new HashMap<>());
        menu = map.get(Eagle.class.getSimpleName());
        menu.put(Fox.class.getSimpleName(), 10);
        menu.put(Rabbit.class.getSimpleName(), 90);
        menu.put(Mouse.class.getSimpleName(), 90);
        menu.put(Duck.class.getSimpleName(), 80);

        map.put(Horse.class.getSimpleName(), new HashMap<>());
        menu = map.get(Horse.class.getSimpleName());
        menu.put(Plant.class.getSimpleName(), 100);

        map.put(Deer.class.getSimpleName(), new HashMap<>());
        menu = map.get(Deer.class.getSimpleName());
        menu.put(Plant.class.getSimpleName(), 100);

        map.put(Rabbit.class.getSimpleName(), new HashMap<>());
        menu = map.get(Rabbit.class.getSimpleName());
        menu.put(Plant.class.getSimpleName(), 100);

        map.put(Mouse.class.getSimpleName(), new HashMap<>());
        menu = map.get(Mouse.class.getSimpleName());
        menu.put(Caterpillar.class.getSimpleName(), 90);
        menu.put(Plant.class.getSimpleName(), 100);

        map.put(Goat.class.getSimpleName(), new HashMap<>());
        menu = map.get(Goat.class.getSimpleName());
        menu.put(Plant.class.getSimpleName(), 100);

        map.put(Sheep.class.getSimpleName(), new HashMap<>());
        menu = map.get(Sheep.class.getSimpleName());
        menu.put(Plant.class.getSimpleName(), 100);

        map.put(Boar.class.getSimpleName(), new HashMap<>());
        menu = map.get(Boar.class.getSimpleName());
        menu.put(Mouse.class.getSimpleName(), 50);
        menu.put(Caterpillar.class.getSimpleName(), 90);
        menu.put(Plant.class.getSimpleName(), 100);

        map.put(Buffalo.class.getSimpleName(), new HashMap<>());
        menu = map.get(Buffalo.class.getSimpleName());
        menu.put(Plant.class.getSimpleName(), 100);

        map.put(Duck.class.getSimpleName(), new HashMap<>());
        menu = map.get(Duck.class.getSimpleName());
        menu.put(Caterpillar.class.getSimpleName(), 90);
        menu.put(Plant.class.getSimpleName(), 100);

        map.put(Caterpillar.class.getSimpleName(), new HashMap<>());
        menu = map.get(Caterpillar.class.getSimpleName());
        menu.put(Plant.class.getSimpleName(), 100);
    }

    public static EatMenu getInstance() {
        return EAT_MENU;
    }

    public int getMaxProbability(String eaterClassName, String preyClassName) {
        Map<String, Integer> menu = map.getOrDefault(eaterClassName, null);
        return menu == null ? 0 : menu.getOrDefault(preyClassName, 0);
    }
}
