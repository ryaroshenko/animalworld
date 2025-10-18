package com.javarush.ryaroshenko.javacore.animalworld.land;

import com.javarush.ryaroshenko.javacore.animalworld.hierarchy.Animal;
import com.javarush.ryaroshenko.javacore.animalworld.settings.AnimalsOnCell;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class Cell {
    private int x;
    private int y;
    private Map<String, List<Animal>> map = new HashMap<>();
    private List<Animal> transporter = new ArrayList<>();

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Map<String, List<Animal>> getMap() {
        return map;
    }

    public List<Animal> getTransporter() {
        return transporter;
    }

    public void init() {
        Class<?> animalClass;
        for (Map.Entry<String, Integer> entry : AnimalsOnCell.getInstance().getMap().entrySet()) {
            animalClass = Animal.findClass(entry.getKey());
            if (animalClass != null) {
                List<Animal> list = new ArrayList<>();
                map.put(animalClass.getName(), list);
                int animalCount = ThreadLocalRandom.current().nextInt(2, entry.getValue() + 1);
                for (int i = 0; i < animalCount; i++) {
                    Animal animal = Animal.newAnimal(animalClass);
                    if (animal != null) {
                        list.add(animal);
                        animal.setCell(this);
                    }
                }
            }
        }
    }

    private void birth() {
        for (Map.Entry<String, List<Animal>> entry : getMap().entrySet()) {
            List<Animal> list = entry.getValue();
            if (!list.isEmpty()) {
                Animal partner = list.getFirst();
                int i = 0;
                while (i < list.size()) {
                    Animal animal = list.get(i);
                    if (animal.isPregnant()) {
                        animal.incPregnantDays();
                        if (animal.isTimeToGiveBirth()) {
                            List<Animal> littleAnimals = animal.birth();
                            list.addAll(littleAnimals);
                        }
                    } else
                        animal.mate(partner);
                    partner = animal;
                    i++;
                }
            }
        }
    }

    private void eat() {
        List<Animal> animals = new ArrayList<>();
        for (Map.Entry<String, List<Animal>> entry : getMap().entrySet()) {
            List<Animal> list = entry.getValue();
            if (!list.isEmpty())
                animals.addAll(list);
        }
        for (Animal animal : animals) {
            for (int i = 0; i < 10; i++)
                animal.eat(animals.get(ThreadLocalRandom.current().nextInt(0, animals.size())));
        }
    }

    private void sweep() {
        for (Map.Entry<String, List<Animal>> entry : getMap().entrySet()) {
            List<Animal> list = entry.getValue();
            if (!list.isEmpty()) {
                int i = 0;
                while (i < list.size()) {
                    if (list.get(i).isDead()) {
                        //System.out.println(list.get(i) + " пішла на вічний спокій");
                        list.remove(i);
                    } else
                        i++;
                }
            }
        }
    }

    private void move() {
        for (Map.Entry<String, List<Animal>> entry : getMap().entrySet()) {
            List<Animal> list = entry.getValue().stream().filter(animal -> animal.getSpeed() > 0).toList();
            if (!list.isEmpty()) {
                for (int i = 0; i < (list.size() / 2); i++) {
                    Animal animal = list.get(i);
                    animal.determinePointForMoving();
                    if (animal.getNewPoint() != null) {
                        getTransporter().add(animal);
                        entry.getValue().remove(animal);
                    }
                }
            }
        }
    }

    public void makeCycle() {
        birth();
        eat();
        sweep();
    }
}
