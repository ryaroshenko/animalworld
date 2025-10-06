package com.javarush.ryaroshenko.javacore.animalworld.land;

import com.javarush.ryaroshenko.javacore.animalworld.hierarchy.Animal;
import com.javarush.ryaroshenko.javacore.animalworld.hierarchy.Gender;
import com.javarush.ryaroshenko.javacore.animalworld.settings.AnimalsOnCell;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class Cell {
    private int x;
    private int y;
    private Map<String, List<Box>> map;

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
        this.map = new HashMap<>();

        Class<?> animalClass;
        for (Map.Entry<String, Integer> entry : AnimalsOnCell.getInstance().getMap().entrySet()) {
            animalClass = Animal.findClass(entry.getKey());
            if (animalClass != null) {
                List<Box> list = new ArrayList<>();
                map.put(animalClass.getName(), list);
                int animalCount = ThreadLocalRandom.current().nextInt(2, entry.getValue() + 1);
                for (int i = 0; i < animalCount; i++)
                    Animal.newAnimal(animalClass, this);
            }
        }
    }

    public Map<String, List<Box>> getMap() {
        return map;
    }

    public void makeCycle() throws InterruptedException {
        for (Map.Entry<String, List<Box>> entry : getMap().entrySet()) {
            List<Box> list = entry.getValue();
            if (!list.isEmpty()) {
                Animal animal = list.getFirst().getAnimal();
                for (Box box : list) {
                    Thread.sleep(1);
                    if (box.getAnimal().isPregnant())
                        box.getAnimal().incPregnantDays();
                    else
                        box.getAnimal().mate(animal);
                    animal = box.getAnimal();
                }
            }
        }
    }
}
