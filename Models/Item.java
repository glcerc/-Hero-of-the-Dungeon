package com.company.Models;

public class Item {
    int id;
    int currentType;
    Cloth cloth;
    Weapon weapon;

    public Item(int id, int currentType, Cloth cloth, Weapon weapon) {
        this.id = id;
        this.currentType = currentType;
        this.cloth = cloth;
        this.weapon = weapon;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCurrentType() {
        return currentType;
    }

    public void setCurrentType(int currentType) {
        this.currentType = currentType;
    }

    public Cloth getCloth() {
        return cloth;
    }

    public void setCloth(Cloth cloth) {
        this.cloth = cloth;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }
}

