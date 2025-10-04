package com.javarush.ryaroshenko.javacore.animalworld.hierarchy;

public enum Gender {
    MALE("Самець"),
    FEMALE("Самка");

    private String title;

    Gender(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }
}
