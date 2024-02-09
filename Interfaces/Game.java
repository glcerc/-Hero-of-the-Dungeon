package com.company.Interfaces;

import com.company.Models.*;

import java.util.List;

public interface Game {
    void levelCreator();
    List<Corridor> dungeonCreator(int levelId, int corridorRange, int roomRange);
    List<Stair> stairCreator(int levelId, int corridorRange, int roomRange);
    List<Monster> monsterCreator(int roomId, int level, int monsterRange);
    List<TownsPerson> townsPersonCreator(int roomId, int level, int monsterRange);
    void controlHandler();
    void locationVisions();


    boolean attack( Monster nMonster);

}
