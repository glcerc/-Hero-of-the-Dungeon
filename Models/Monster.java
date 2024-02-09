package com.company.Models;

import java.util.List;

public class Monster extends Character{



    int currentLevel;
    List<Item> inventory;

    public Monster(int id, int healthPoint, int currentRoom, int currentLevel, List<Item> inventory) {
        this.id = id;
        this.healthPoint = healthPoint;
        this.currentRoom = currentRoom;
        this.currentLevel = currentLevel;
        this.inventory = inventory;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHealthPoint() {
        return healthPoint;
    }

    public void setHealthPoint(int healthPoint) {
        this.healthPoint = healthPoint;
    }

    public int getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(int currentRoom) {
        this.currentRoom = currentRoom;
    }

    public int getCurrentLevel() {
        return currentLevel;
    }

    public void setCurrentLevel(int currentLevel) {
        this.currentLevel = currentLevel;
    }

    public List<Item> getInventory() {
        return inventory;
    }

    public void setInventory(List<Item> inventory) {
        this.inventory = inventory;
    }
}

