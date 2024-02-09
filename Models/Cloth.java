package com.company.Models;

public class Cloth {

    int id;
    String name;
    int weight;
    int value;

    int mainCategory;
    int protection;

    public Cloth(int id, String name, int weight, int value, int mainCategory, int protection) {
        this.id = id;
        this.name = name;
        this.weight = weight;
        this.value = value;
        this.mainCategory = mainCategory;
        this.protection = protection;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getMainCategory() {
        return mainCategory;
    }

    public void setMainCategory(int mainCategory) {
        this.mainCategory = mainCategory;
    }

    public int getProtection() {
        return protection;
    }

    public void setProtection(int protection) {
        this.protection = protection;
    }
}

