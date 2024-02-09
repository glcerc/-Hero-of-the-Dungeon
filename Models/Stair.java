package com.company.Models;

public class Stair {
    int firstRoomId;
    int secondRoomId;

    public Stair(int firstRoomId, int secondRoomId) {
        this.firstRoomId = firstRoomId;
        this.secondRoomId = secondRoomId;
    }

    public int getFirstRoomId() {
        return firstRoomId;
    }

    public void setFirstRoomId(int firstRoomId) {
        this.firstRoomId = firstRoomId;
    }

    public int getSecondRoomId() {
        return secondRoomId;
    }

    public void setSecondRoomId(int secondRoomId) {
        this.secondRoomId = secondRoomId;
    }
}
