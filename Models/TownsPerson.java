package com.company.Models;

public class TownsPerson extends Character{

    int currentLevel;
    int healthRestorationPoint;

    public TownsPerson(int id, int currentRoom, int currentLevel, int healthRestorationPoint) {
        this.id = id;
        this.currentRoom = currentRoom;
        this.currentLevel = currentLevel;
        this.healthRestorationPoint = healthRestorationPoint;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getHealthRestorationPoint() {
        return healthRestorationPoint;
    }

    public void setHealthRestorationPoint(int healthRestorationPoint) {
        this.healthRestorationPoint = healthRestorationPoint;
    }
}

