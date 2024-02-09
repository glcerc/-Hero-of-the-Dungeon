package com.company.Models;

public class Weapon {
    int id;
    String name;
    int weight;
    int value;

    int mainCategory;
    int subCategory;
    int damage;
    int range;

    public Weapon(int id, String name, int weight, int value, int mainCategory, int subCategory, int damage, int range) {
        this.id = id;
        this.name = name;
        this.weight = weight;
        this.value = value;
        this.mainCategory = mainCategory;
        this.subCategory = subCategory;
        this.damage = damage;
        this.range = range;
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

    public int getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(int subCategory) {
        this.subCategory = subCategory;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }
}
