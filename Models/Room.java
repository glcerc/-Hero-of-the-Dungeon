package com.company.Models;

import java.util.List;

public class Room {
    int id;
    List<Monster> monsters;
    List<TownsPerson> townsPeople;


    public Room(int id, List<Monster> monsters, List<TownsPerson> townsPeople) {
        this.id = id;
        this.monsters = monsters;
        this.townsPeople = townsPeople;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Monster> getMonsters() {
        return monsters;
    }

    public void setMonsters(List<Monster> monsters) {
        this.monsters = monsters;
    }

    public List<TownsPerson> getTownsPeople() {
        return townsPeople;
    }

    public void setTownsPeople(List<TownsPerson> townsPeople) {
        this.townsPeople = townsPeople;
    }
}
