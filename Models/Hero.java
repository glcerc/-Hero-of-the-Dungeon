package com.company.Models;

import  java.util.ArrayList;
import java.util.List;

public class Hero extends Character {


    int healthPoint = 100;
    int maxHealthPoint = 100;

    String name;
    int gender;
    int maxWeight = 250;
    int currentWeight = 2;
    int numberOfRescuse = 0;

    int level = 1;
    int currentRoom = 1;
    int currentScore = 0;

    Cloth cloth = null;
    Weapon weapon = null;

    List<Item> inventory = new ArrayList<>();

    public Hero(String name, int gender) {
        this.name = name;
        this.gender = gender;
    }

    public String getWeaponName(){
        return weapon != null ? weapon.name : "Fist";
    }
    public String getClothName(){
        return cloth != null ? cloth.name : "Sack";
    }


    public int getHealthPoint() {
        return healthPoint;
    }

    public void setHealthPoint(int healthPoint) {
        this.healthPoint = healthPoint;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(int maxWeight) {
        this.maxWeight = maxWeight;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(int currentRoom) {
        this.currentRoom = currentRoom;
    }

    public int getCurrentScore() {
        return currentScore;
    }

    public void setCurrentScore(int currentScore) {
        this.currentScore = currentScore;
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

    public List<Item> getInventory() {
        return inventory;
    }

    public void setInventory(List<Item> inventory) {
        this.inventory = inventory;
    }

    public int getMaxHealthPoint() {
        return maxHealthPoint;
    }

    public void setMaxHealthPoint(int maxHealthPoint) {
        this.maxHealthPoint = maxHealthPoint;
    }

    public int getCurrentWeight() {
        return currentWeight;
    }

    public void setCurrentWeight(int currentWeight) {
        this.currentWeight = currentWeight;
    }

    public int getNumberOfRescuse() {
        return numberOfRescuse;
    }

    public void setNumberOfRescuse(int numberOfRescuse) {
        this.numberOfRescuse = numberOfRescuse;
    }
}

