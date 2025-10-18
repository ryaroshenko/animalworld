package com.javarush.ryaroshenko.javacore.animalworld;

import com.javarush.ryaroshenko.javacore.animalworld.hierarchy.Animal;
import com.javarush.ryaroshenko.javacore.animalworld.land.*;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        System.out.printf("Розмір острова: %d x %d\n", Island.SIZE_X, Island.SIZE_Y);
        Island island = Island.getInstance();
        for (int i = 1; i < 3; i++) {
            System.out.println("День " + i);
            Thread[][] threads = new Thread[Island.SIZE_X][Island.SIZE_Y];
            for (int x = 0; x < Island.SIZE_X; x++)
                for (int y = 0; y < Island.SIZE_Y; y++) {
                    threads[x][y] = new CellMaker(island.getCell(x, y)).getThread();
                }
            try {
                for (int x = 0; x < threads.length; x++)
                    for (int y = 0; y < threads[x].length; y++)
                        threads[x][y].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        printCell(2, 3);
    }

    public static void printCell(int x, int y) {
        Cell cell = Island.getInstance().getCell(x, y);
        System.out.printf("Клітинка (%d, %d)\n", x, y);
        for (Map.Entry<String, List<Animal>> entry : cell.getMap().entrySet()) {
            String className = entry.getKey();
            List<Animal> list = entry.getValue();
            System.out.println(className.substring(className.lastIndexOf(".") + 1) + " (Count: " + list.size() + ")");
/*
            for (Animal animal : list)
                System.out.println("  " + animal);
*/
        }
    }
}