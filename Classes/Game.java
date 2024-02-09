package com.company.Classes;

import com.company.Models.*;

import java.util.ArrayList;
import java.util.List;

public class Game extends GameManager{
    public Game(Hero hero) {

        this.hero = hero;


        levelCreator();



        this.hero.setWeapon(this.listOfWeapons.get(0));
        this.hero.setCloth(this.listOfCloths.get(0));

        controlHandler();
    }
}

