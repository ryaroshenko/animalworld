package com.javarush.ryaroshenko.javacore.animalworld;

import com.javarush.ryaroshenko.javacore.animalworld.land.*;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello animal world!");
        System.out.printf("Розмір острова: %d x %d\n", Island.SIZE_X, Island.SIZE_Y);
        Cell cell = Island.getInstance().getCell(2, 3);
        for (int i = 0; i < 100; i++) {
            System.out.println("Цикл " + i);
            try {
                cell.makeCycle();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void printCell(int x, int y) {
        Cell cell = Island.getInstance().getCell(x, y);
        System.out.printf("Клітинка (%d, %d)\n", x, y);
        for (Map.Entry<String, List<Box>> entry : cell.getMap().entrySet()) {
            String className = entry.getKey();
            List<Box> list = entry.getValue();
            System.out.println(className.substring(className.lastIndexOf(".") + 1) + " (Count: " + list.size() + ")");
            for (Box box : list)
                System.out.println("  " + box.getAnimal());
        }
    }
}