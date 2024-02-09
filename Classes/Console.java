package com.company.Classes;

import com.company.Models.Hero;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Console extends SystemManager{
    int menuSelected;
    List<Integer> menuSelectors = new ArrayList<>();
    List<Integer> createCharacterSelectors = new ArrayList<>();
    public Console() {
        menuSelectors.add(1);
        menuSelectors.add(2);
        createCharacterSelectors.add(1);
        createCharacterSelectors.add(2);
        startUI();
    }

    public void startUI(){
        startMenu();
    }

    public void startMenu(){
        while(true){
            System.out.println("Welcome to Hero of the Dungeon ! ");
            System.out.println("What do you want to do ?");
            System.out.println("Press 1 for start new game.");
            System.out.println("press 2 for browse the leaderboard.");

            menuSelected = scannerSelectedRangeControlForInt(menuSelectors,scannerTakeIntegerInput());
            if(menuSelected == 1){
                System.out.println("The game control keys are as follows");
                System.out.println("Type the 'move' command to move between rooms");
                System.out.println("For example, type 'move d1' to go to gate d1.");
                System.out.println("Select the monster you want to attack and type the 'attack' command");
                System.out.println("For example, to attack the m3 monster, type 'attack m3'");
                System.out.println("Type the 'inv' command to view your inventory");
                System.out.println("Enter the 'take' command to get weapons and clothing dropped from monsters.");
                System.out.println("Enter the 'equip' command to use the weapons in your inventory or to wear the outfits.");
                System.out.println("Use the 'delete' command to remove items from your inventory");
                System.out.println("Type 'exit' to exit the game");
                System.out.println("That's all for the information, now you're on your own");
                System.out.println("Don't forget to have fun in this magical world and kill as many monsters as you can");

                startNewGame();
            }else if(menuSelected == 2){
                startLeaderboard();
            }
        }
    }

    public void startNewGame(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your hero's name: ");
        String heroName = scanner.nextLine();
        System.out.println("Select your hero's gender: ");
        System.out.println("press 1 for Woman");
        System.out.println("press 2 for Man");
        int heroGender = scannerSelectedRangeControlForInt(createCharacterSelectors,scannerTakeIntegerInput());

        new Game(new Hero(heroName,heroGender));

    }

    public  void startLeaderboard(){
        FileInputStream fis= null;
        System.out.println("Leader Board");
        try {
            fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\com\\company\\Datas\\LeaderBoard.txt");
            Scanner sc=new Scanner(fis);
            int outterCount = 1;
            while(sc.hasNextLine())
            {
                String name = "";
                int itemsValue = 0;
                int numbersRescue = 0;
                int count = 0;
                for (String item:
                        sc.nextLine().split(",")) {
                    if (count == 0){
                        name = item;
                    }else if(count == 1){
                        itemsValue = Integer.parseInt(item);
                    }else if(count == 2){
                        numbersRescue = Integer.parseInt(item);
                    }

                    count++;
                }

                System.out.println(outterCount+". name : "+name+", Value Of Inventory :"+itemsValue+", Number of Rescue : "+numbersRescue);
                outterCount++;
            }

        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

}

