package com.company.Models;

import java.util.List;

public class Level {
    int level;
    int corridorRangeNumber;
    int roomRangeNumber;
    List<Corridor> dungeons;
    List<Stair> stairs;

    public Level(int level, int corridorRangeNumber, int roomRangeNumber, List<Corridor> dungeons, List<Stair> stairs) {
        this.level = level;
        this.corridorRangeNumber = corridorRangeNumber;
        this.roomRangeNumber = roomRangeNumber;
        this.dungeons = dungeons;
        this.stairs = stairs;
    }

    public int getCurrentCorridorRow(int currentRoomId){
        int currentCorridor = ((int) Math.ceil((double) currentRoomId/roomRangeNumber));
        return currentCorridor;
    }

    public int getCurrentRoomIndex(int currentRoomId){
        int count = 0;
        int cond = 0;
        for (Corridor item:
                dungeons) {
            count = 0;
            for (Room itemx:
                    item.getRooms()) {
                if(itemx.getId() == currentRoomId){
                    cond = 1;
                    break;
                }
                count++;
            }
            if(cond == 1)
                break;
        }
        return count;
    }


    public int getMaxRoomCount(){ return corridorRangeNumber*roomRangeNumber; }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getCorridorRangeNumber() {
        return corridorRangeNumber;
    }

    public void setCorridorRangeNumber(int corridorRangeNumber) {
        this.corridorRangeNumber = corridorRangeNumber;
    }

    public int getRoomRangeNumber() {
        return roomRangeNumber;
    }

    public void setRoomRangeNumber(int roomRangeNumber) {
        this.roomRangeNumber = roomRangeNumber;
    }

    public List<Corridor> getDungeons() {
        return dungeons;
    }

    public void setDungeons(List<Corridor> dungeons) {
        this.dungeons = dungeons;
    }

    public List<Stair> getStairs() {
        return stairs;
    }

    public void setStairs(List<Stair> stairs) {
        this.stairs = stairs;
    }
}

