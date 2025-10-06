package com.javarush.ryaroshenko.javacore.animalworld.settings;

import com.javarush.ryaroshenko.javacore.animalworld.hierarchy.*;

import java.util.HashMap;
import java.util.Map;

public class EatMenu {
    private static final EatMenu EAT_MENU = new EatMenu();

    private Map<String, Map<String, Integer>> map = new HashMap<>();

    private EatMenu() {
        Map<String, Integer> menu;

        map.put(Wolf.class.getName(), new HashMap<>());
        menu = map.get(Wolf.class.getName());
        menu.put(Horse.class.getName(), 10);
        menu.put(Deer.class.getName(), 15);
        menu.put(Rabbit.class.getName(), 60);
        menu.put(Mouse.class.getName(), 80);
        menu.put(Goat.class.getName(), 60);
        menu.put(Sheep.class.getName(), 70);
        menu.put(Boar.class.getName(), 15);
        menu.put(Buffalo.class.getName(), 10);
        menu.put(Duck.class.getName(), 40);

        map.put(Boa.class.getName(), new HashMap<>());
        menu = map.get(Boa.class.getName());
        menu.put(Fox.class.getName(), 15);
        menu.put(Rabbit.class.getName(), 20);
        menu.put(Mouse.class.getName(), 40);
        menu.put(Duck.class.getName(), 10);

        map.put(Fox.class.getName(), new HashMap<>());
        menu = map.get(Fox.class.getName());
        menu.put(Rabbit.class.getName(), 70);
        menu.put(Mouse.class.getName(), 90);
        menu.put(Duck.class.getName(), 60);
        menu.put(Caterpillar.class.getName(), 40);

        map.put(Bear.class.getName(), new HashMap<>());
        menu = map.get(Bear.class.getName());
        menu.put(Boa.class.getName(), 80);
        menu.put(Horse.class.getName(), 40);
        menu.put(Deer.class.getName(), 80);
        menu.put(Rabbit.class.getName(), 80);
        menu.put(Mouse.class.getName(), 90);
        menu.put(Goat.class.getName(), 70);
        menu.put(Sheep.class.getName(), 70);
        menu.put(Boar.class.getName(), 50);
        menu.put(Buffalo.class.getName(), 20);
        menu.put(Duck.class.getName(), 10);

        map.put(Eagle.class.getName(), new HashMap<>());
        menu = map.get(Eagle.class.getName());
        menu.put(Fox.class.getName(), 10);
        menu.put(Rabbit.class.getName(), 90);
        menu.put(Mouse.class.getName(), 90);
        menu.put(Duck.class.getName(), 80);

        map.put(Horse.class.getName(), new HashMap<>());
        menu = map.get(Horse.class.getName());
        menu.put(Plant.class.getName(), 100);

        map.put(Deer.class.getName(), new HashMap<>());
        menu = map.get(Deer.class.getName());
        menu.put(Plant.class.getName(), 100);

        map.put(Rabbit.class.getName(), new HashMap<>());
        menu = map.get(Rabbit.class.getName());
        menu.put(Plant.class.getName(), 100);

        map.put(Mouse.class.getName(), new HashMap<>());
        menu = map.get(Mouse.class.getName());
        menu.put(Caterpillar.class.getName(), 90);
        menu.put(Plant.class.getName(), 100);

        map.put(Goat.class.getName(), new HashMap<>());
        menu = map.get(Goat.class.getName());
        menu.put(Plant.class.getName(), 100);

        map.put(Sheep.class.getName(), new HashMap<>());
        menu = map.get(Sheep.class.getName());
        menu.put(Plant.class.getName(), 100);

        map.put(Boar.class.getName(), new HashMap<>());
        menu = map.get(Boar.class.getName());
        menu.put(Mouse.class.getName(), 50);
        menu.put(Caterpillar.class.getName(), 90);
        menu.put(Plant.class.getName(), 100);

        map.put(Buffalo.class.getName(), new HashMap<>());
        menu = map.get(Buffalo.class.getName());
        menu.put(Plant.class.getName(), 100);

        map.put(Duck.class.getName(), new HashMap<>());
        menu = map.get(Duck.class.getName());
        menu.put(Caterpillar.class.getName(), 90);
        menu.put(Plant.class.getName(), 100);

        map.put(Caterpillar.class.getName(), new HashMap<>());
        menu = map.get(Caterpillar.class.getName());
        menu.put(Plant.class.getName(), 100);
    }

    public static EatMenu getInstance() {
        return EAT_MENU;
    }

    public int getMaxProbability(String eaterClassName, String preyClassName) {
        Map<String, Integer> menu = map.getOrDefault(eaterClassName, null);
        return menu == null ? 0 : menu.getOrDefault(preyClassName, 0);
    }
}
