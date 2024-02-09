package com.company.Models;

import java.util.ArrayList;
import java.util.List;

public class Corridor {
    int id;
    int level;
    List<Room> rooms;

    public Corridor(int id, int level, List<Room> rooms) {
        this.id = id;
        this.level = level;
        this.rooms = rooms;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }
}
