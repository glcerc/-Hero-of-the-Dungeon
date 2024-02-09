package com.company.Classes;

import com.company.Interfaces.Game;
import com.company.Interfaces.System_;
import com.company.Models.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public abstract class GameManager extends SystemManager implements Game {
    List<Level> levels = new ArrayList<>();


    List<Integer> attackSelectors = new ArrayList<>();

    List<Weapon> listOfWeapons = new ArrayList<>();
    List<Cloth> listOfCloths = new ArrayList<>();


    Hero hero = null;

    public GameManager() {
        listOfWeapons.add(new Weapon(0,"Fist",0,14,1,1,5,1));
        listOfWeapons.add(new Weapon(1,"Cutlass",20,15,1,1,14,1));
        listOfWeapons.add(new Weapon(2,"Kalis",30,20,1,1,18,1));
        listOfWeapons.add(new Weapon(3,"Takoba",25,15,1,2,16,2));
        listOfWeapons.add(new Weapon(4,"Falx",20,15,1,2,13,2));
        listOfWeapons.add(new Weapon(5,"Harpe",30,20,1,3,18,3));
        listOfWeapons.add(new Weapon(6,"Curtona",35,25,1,3,23,3));
        listOfWeapons.add(new Weapon(7,"Grub",15,10,2,1,8,6));
        listOfWeapons.add(new Weapon(8,"Hudson",25,20,2,1,16,8));
        listOfWeapons.add(new Weapon(9,"Hatchet",25,20,2,1,17,8));
        listOfWeapons.add(new Weapon(10,"Feeling",40,35,2,1,30,8));
        listOfWeapons.add(new Weapon(11,"Carpenter",35,25,3,1,25,22));
        listOfWeapons.add(new Weapon(12,"Miner",30,20,2,3,19,10));
        listOfWeapons.add(new Weapon(13,"Anger",25,20,3,1,18,12));
        listOfWeapons.add(new Weapon(14,"Snipe",30,20,3,1,23,12));
        listOfWeapons.add(new Weapon(15,"Orca",40,35,3,2,30,15));
        listOfWeapons.add(new Weapon(16,"Peal",45,35,3,2,32,15));
        listOfWeapons.add(new Weapon(17,"Whisperwing",40,35,3,3,33,20));
        listOfWeapons.add(new Weapon(18,"Flame",35,30,3,3,28,20));



        listOfCloths.add(new Cloth(0,"Potato Sack",1,0,1,1));
        listOfCloths.add(new Cloth(0,"Light tunic",3,3,1,2));
        listOfCloths.add(new Cloth(0,"Heavy coat",4,3,1,3));
        listOfCloths.add(new Cloth(0,"Linen Armor",5,2,1,3));
        listOfCloths.add(new Cloth(0,"Jack",5,3,1,4));
        listOfCloths.add(new Cloth(0,"Leather Pauldrons",7,5,1,5));
        listOfCloths.add(new Cloth(0,"Jerkin",8,6,2,6));
        listOfCloths.add(new Cloth(0,"Leather Chestplate",10,8,2,8));
        listOfCloths.add(new Cloth(0,"Brigandine",10,8,2,9));
        listOfCloths.add(new Cloth(0,"Aketon",15,10,3,10));
        listOfCloths.add(new Cloth(0,"Ringmail",17,10,3,11));
        listOfCloths.add(new Cloth(0,"Jazerant",18,11,3,11));
        listOfCloths.add(new Cloth(0,"Haubergeon",19,12,3,12));
    }

    @Override
    public void levelCreator() {
        if(levels.size() > 0)
            levels.clear();

        for(int count = 1; count <= 16; count++){
            int corridorRange =  (int)(Math.random()*(5-2+1)+2);
            int roomRange =  (int)(Math.random()*(6-2+1)+2);
            levels.add(new Level(count,corridorRange,roomRange,dungeonCreator(count,corridorRange,roomRange),stairCreator(count,corridorRange,roomRange)));
        }
    }

    @Override
    public List<Corridor> dungeonCreator(int levelId, int corridorRange, int roomRange) {
        List<Corridor> corridors = new ArrayList<>();
        for(int corCount = 1; corCount <= corridorRange; corCount++){
            List<Room> rooms = new ArrayList<>();
            for (int roomCount = 1; roomCount <= roomRange; roomCount++){
                int monsterRange = (int)(Math.random()*(9-3+1)+3);
                rooms.add(new Room(((roomRange*(corCount-1))+roomCount),monsterCreator(((roomRange*(corCount-1))+roomCount),levelId,monsterRange),townsPersonCreator(((roomRange*(corCount-1))+roomCount),levelId,monsterRange)));
            }
            corridors.add(new Corridor(corCount,levelId,rooms));
        }
        return corridors;
    }

    @Override
    public List<Stair> stairCreator(int levelId, int corridorRange, int roomRange) {
        List<Stair> stairs = new ArrayList<>();
        int lastRoom = 0;
        for(int betwCount = 1; betwCount <= (corridorRange - 1); betwCount++ ){
            int firstRoom;
            int secondRoom;

            int firstRoomMin = (roomRange * (betwCount-1))+1;
            int firstRoomMax = (roomRange * (betwCount));

            int secondRoomMin = (roomRange*betwCount)+1;
            int secondRoomMax = (roomRange*betwCount+1);

            do {
                firstRoom = (int)(Math.random()*(firstRoomMax-firstRoomMin+1)+firstRoomMin);
            } while (firstRoom == lastRoom);
            secondRoom = (int)(Math.random()*(secondRoomMax-secondRoomMin+1)+secondRoomMin);
            lastRoom = secondRoom;
            stairs.add(new Stair(firstRoom,secondRoom));
        }
        return stairs;
    }

    @Override
    public List<Monster> monsterCreator(int roomId, int level, int monsterRange) {
        List<Monster> monsters = new ArrayList<>();
        for (int count = 0; count < monsterRange; count++){
            int monsterInventoryCount = (int)(Math.random()*(2-1+1)+1);
            List<Item> monsterInventory = new ArrayList<>();
            for (int i = 0; i< monsterInventoryCount; i++){
                int itemKind = (int)(Math.random()*(2-1+1)+1);
                if(itemKind == 1){
                    int randomWeapon = (int)(int)(Math.random()*((listOfWeapons.size()-1)+1)+0);
                    Weapon weapon = listOfWeapons.get(randomWeapon);
                    monsterInventory.add(new Item(i,1,null,weapon));
                }else{
                    int randomCloth = (int)(int)(Math.random()*((listOfCloths.size()-1)+1)+0);
                    Cloth cloth = listOfCloths.get(randomCloth);
                    monsterInventory.add(new Item(i,2,cloth,null));
                }
            }
            monsters.add(new Monster(count,((int)(Math.random()*(60-40+1)+60)),roomId,level,monsterInventory));
        }
        return monsters;
    }

    @Override
    public List<TownsPerson> townsPersonCreator(int roomId, int level, int monsterRange) {
        List<TownsPerson> TownsPersons = new ArrayList<>();
        for (int count = 0; count < ((int)(Math.floor((double)monsterRange / 3))); count++){
            TownsPersons.add(new TownsPerson(count,roomId,level,(((int)(Math.random()*(30-15+1)+15)))));
        }
        return TownsPersons;
    }

    @Override
    public void controlHandler() {
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("Level "+hero.getLevel()+", Room "+hero.getCurrentRoom());
            System.out.println(hero.getName()+", "+hero.getHealthPoint()+"HP, "+ hero.getWeaponName()+", "+hero.getClothName());
            locationVisions();
            String input = scanner.nextLine();
            if(input.equals("exit")){
                int totalValueOfItems = 0;
                for (Item item:
                        hero.getInventory()) {
                    if(item.getCurrentType() == 1){
                        totalValueOfItems += item.getWeapon().getValue();
                    }else if(item.getCurrentType() == 2){
                        totalValueOfItems += item.getCloth().getValue();
                    }
                }
                totalValueOfItems += hero.getWeapon().getValue();
                totalValueOfItems +=  hero.getCloth().getValue();
                detectLeaderBoard(hero.getName(),totalValueOfItems,hero.getNumberOfRescuse());
                System.exit(0);

            }else if(input.contains("move")){
                input = input.replace("move","").trim();
                if(input.contains("up")){
                    for (Stair item:
                            levels.get(hero.getLevel()-1).getStairs()) {
                        if(item.getFirstRoomId() == hero.getCurrentRoom())
                            hero.setCurrentRoom(item.getSecondRoomId());
                    }
                }else if(input.contains("down")){
                    for (Stair item:
                            levels.get(hero.getLevel()-1).getStairs()) {
                        if(item.getSecondRoomId() == hero.getCurrentRoom())
                            hero.setCurrentRoom(item.getFirstRoomId());
                    }
                }else if(input.contains("back")){
                    int otherLastRoom = levels.get(hero.getLevel()-2).getRoomRangeNumber() * levels.get(hero.getLevel()-2).getCorridorRangeNumber();
                    hero.setLevel(hero.getLevel()-1);
                    hero.setCurrentRoom(otherLastRoom);
                }else if(input.contains("forward")){
                    if(hero.getLevel() == 16){
                        int totalValueOfItems = 0;
                        for (Item item:
                                hero.getInventory()) {
                            if(item.getCurrentType() == 1){
                                totalValueOfItems += item.getWeapon().getValue();
                            }else if(item.getCurrentType() == 2){
                                totalValueOfItems += item.getCloth().getValue();
                            }
                        }
                        totalValueOfItems += hero.getWeapon().getValue();
                        totalValueOfItems +=  hero.getCloth().getValue();
                        detectLeaderBoard(hero.getName(),totalValueOfItems,hero.getNumberOfRescuse());
                        break;
                    }

                    hero.setLevel(hero.getLevel()+1);
                    hero.setCurrentRoom(1);


                }else if(input.contains("d")){
                    if(hero.getCurrentRoom()+1 == (Integer.parseInt(input.replace("d",""))) || hero.getCurrentRoom()-1 == Integer.parseInt(input.replace("d",""))){
                        int selectedRoom = Integer.parseInt(input.replace("d",""));
                        hero.setCurrentRoom(selectedRoom);
                    }else
                        System.out.println("Try Again:");
                }else{
                    System.out.println("Try Again");
                }
            }else if(input.contains("attack")){
                input = input.replace("attack","").trim();
                if(input.contains("m")){
                    Level currentLevel = levels.get(hero.getLevel()-1);
                    Room herosRoom = currentLevel.getDungeons().get(currentLevel.getCurrentCorridorRow(hero.getCurrentRoom())-1).getRooms().get(currentLevel.getCurrentRoomIndex(hero.getCurrentRoom()));
                    if(Integer.parseInt(input.replace("m","")) >= herosRoom.getMonsters().size()){
                        System.out.println("Try Again");

                    }else{
                        if(attack(herosRoom.getMonsters().get(Integer.parseInt(input.replace("m",""))))){
                            System.out.println("You defeat the monster");
                            System.out.println("Dropped monster items. Browse.");
                            monsterChooseItem(herosRoom.getMonsters().get(Integer.parseInt(input.replace("m",""))).getInventory());
                            herosRoom.getMonsters().remove(Integer.parseInt(input.replace("m","")));
                        }else{
                            System.out.println("You lose");
                            int totalValueOfItems = 0;
                            for (Item item:
                                    hero.getInventory()) {
                                if(item.getCurrentType() == 1){
                                    totalValueOfItems += item.getWeapon().getValue();
                                }else if(item.getCurrentType() == 2){
                                    totalValueOfItems += item.getCloth().getValue();
                                }
                            }
                            totalValueOfItems += hero.getWeapon().getValue();
                            totalValueOfItems +=  hero.getCloth().getValue();
                            detectLeaderBoard(hero.getName(),totalValueOfItems,hero.getNumberOfRescuse());
                            break;
                        }
                    }
                }else{
                    System.out.println("Try Again");
                }
            }else if(input.contains("inv")){
                System.out.println("------------------");
                System.out.println("Your Inventory");
                System.out.println("Your current weight is "+hero.getCurrentWeight());
                outerLoop : while (true){
                    int count = 0;
                    for (Item item:
                            hero.getInventory()) {
                        if(item.getCurrentType() == 1){
                            System.out.println("------------------");
                            System.out.println("Write delete "+count+" or equip "+count+" for "+ item.getWeapon().getName());
                            System.out.println("Value  : "+item.getWeapon().getValue());
                            System.out.println("Damage : "+item.getWeapon().getDamage());
                            System.out.println("Range  : "+item.getWeapon().getRange());
                            System.out.println("Weight : "+item.getWeapon().getWeight());
                        }else if(item.getCurrentType() == 2){
                            System.out.println("------------------");
                            System.out.println("Write delete "+count+" or equip "+count+" for "+ item.getCloth().getName());
                            System.out.println("Value      : "+item.getCloth().getValue());
                            System.out.println("Protection : "+item.getCloth().getProtection());
                            System.out.println("Weight     : "+item.getCloth().getWeight());
                        }
                        count++;
                    }

                    System.out.println("------------------");
                    System.out.println("Or write non for do not thing");
                    System.out.println("------------------");
                    Scanner itemScanner = new Scanner(System.in);
                    while (true){
                        String itemInput = itemScanner.nextLine();
                        if(itemInput.equals("non")){
                            break outerLoop;
                        }else if(itemInput.contains("delete")){
                            itemInput = itemInput.replace("delete","").trim();
                            if(Integer.parseInt(itemInput) >= hero.getInventory().size())
                                break outerLoop;
                            Item selectedItem = hero.getInventory().get(Integer.parseInt(itemInput));
                            hero.setCurrentWeight((hero.getCurrentWeight())-(selectedItem.getCurrentType() == 1 ? selectedItem.getWeapon().getWeight() : selectedItem.getCloth().getWeight()));
                            hero.getInventory().remove(Integer.parseInt(itemInput));
                            break outerLoop;
                        }else if(itemInput.contains("equip")){
                            itemInput = itemInput.replace("equip","").trim();
                            if(Integer.parseInt(itemInput) >= hero.getInventory().size())
                                break outerLoop;
                            Item selectedItem = hero.getInventory().get(Integer.parseInt(itemInput));

                            if(selectedItem.getCurrentType() == 1){
                                hero.getInventory().add(new Item(hero.getInventory().size()+1,1,null,hero.getWeapon()));

                                hero.setWeapon(selectedItem.getWeapon());
                                hero.getInventory().remove(Integer.parseInt(itemInput));
                                System.out.println("You changed your weapon");
                                break outerLoop;
                            }else{
                                hero.getInventory().add(new Item(hero.getInventory().size()+1,2,hero.getCloth(),null));

                                hero.setCloth(selectedItem.getCloth());
                                hero.getInventory().remove(Integer.parseInt(itemInput));
                                System.out.println("You changed your cloth");
                                break outerLoop;
                            }

                        }else{
                            System.out.println("Try Again.");
                        }
                    }

                }
            }else if(input.contains("rescue")){
                Level currentLevel = levels.get(hero.getLevel()-1);
                Room herosRoom = currentLevel.getDungeons().get(currentLevel.getCurrentCorridorRow(hero.getCurrentRoom())-1).getRooms().get(currentLevel.getCurrentRoomIndex(hero.getCurrentRoom()));

                if(herosRoom.getMonsters().size() != 0){
                    System.out.println("You can't rescue Towns Persons while all the monsters alive.");
                }else{
                    int totalHeals = 0;
                    for (TownsPerson item: herosRoom.getTownsPeople()) {
                        if(hero.getHealthPoint() < 100) {
                            if((hero.getHealthPoint() + item.getHealthRestorationPoint()) > 100){
                                totalHeals += (100-hero.getHealthPoint());
                            }
                        }else{
                            totalHeals += item.getHealthRestorationPoint();
                        }


                    }
                    hero.setHealthPoint(hero.getHealthPoint()+totalHeals);
                    herosRoom.getTownsPeople().clear();
                    System.out.println("You rescue all towns persons");

                }
            }else{
                System.out.println("Try Again");
            }
        }

    }

    public void monsterChooseItem(List<Item> monsterInventory){
        while(monsterInventory.size() != 0){
            System.out.println("Your weight is "+hero.getCurrentWeight());
            int count = 0;
            for (Item item:
                    monsterInventory) {
                if(item.getCurrentType() == 1){
                    System.out.println("------------------");
                    System.out.println("Write take "+count+" for "+ item.getWeapon().getName());
                    System.out.println("Value  : "+item.getWeapon().getValue());
                    System.out.println("Damage : "+item.getWeapon().getDamage());
                    System.out.println("Range  : "+item.getWeapon().getRange());
                    System.out.println("Weight : "+item.getWeapon().getWeight());
                }else if(item.getCurrentType() == 2){
                    System.out.println("------------------");
                    System.out.println("Write take "+count+" for "+ item.getCloth().getName());
                    System.out.println("Value      : "+item.getCloth().getValue());
                    System.out.println("Protection : "+item.getCloth().getProtection());
                    System.out.println("Weight     : "+item.getCloth().getWeight());
                }
                count++;
            }

            System.out.println("------------------");
            System.out.println("Or write non for do not thing");
            System.out.println("------------------");
            Scanner itemScanner = new Scanner(System.in);
            while (true){
                String itemInput  = itemScanner.nextLine();
                if(itemInput.equals("non")){
                    monsterInventory.clear();
                    break;
                }else if(itemInput.contains("take")){
                    itemInput = itemInput.replace("take","").trim();
                    if(Integer.parseInt(itemInput) < monsterInventory.size()){
                        Item selectedItem = monsterInventory.get(Integer.parseInt(itemInput));
                        if((hero.getCurrentWeight() + (selectedItem.getCurrentType() == 1 ? selectedItem.getWeapon().getWeight() : selectedItem.getCloth().getWeight())) > hero.getMaxWeight()){
                            System.out.println("Your weight is too much. Try another item.");
                        }else{
                            hero.getInventory().add(selectedItem);
                            hero.setCurrentWeight((hero.getCurrentWeight()+(selectedItem.getCurrentType() == 1 ? selectedItem.getWeapon().getWeight() : selectedItem.getCloth().getWeight())));
                            monsterInventory.remove(Integer.parseInt(itemInput));
                            break;
                        }
                    }else{
                        System.out.println("Try Again");
                    }
                }
            }
        }
    }

    @Override
    public void locationVisions() {
        Level currentLevel = levels.get(hero.getLevel()-1);
        Room herosRoom = currentLevel.getDungeons().get(currentLevel.getCurrentCorridorRow(hero.getCurrentRoom())-1).getRooms().get(currentLevel.getCurrentRoomIndex(hero.getCurrentRoom()));
        System.out.println("The hero sees the following. ");

        if(herosRoom.getId() == 1){
            if(currentLevel.getLevel() != 1){
                System.out.println("Door (back)");
            }
            System.out.println("Door (d2)");
        }else if(herosRoom.getId() == currentLevel.getMaxRoomCount()){
            if(currentLevel.getLevel() != 16){
                System.out.println("Door (forward)");
            }
            System.out.println("Door (d"+(currentLevel.getMaxRoomCount()-1)+")");
        }else{
            int currentCorridorRow = currentLevel.getCurrentCorridorRow(hero.getCurrentRoom());
            int currentCorridorIndex = currentCorridorRow-1;

            if(((currentCorridorIndex*currentLevel.getRoomRangeNumber()+1)) != herosRoom.getId()){
                System.out.println("Door (d"+(herosRoom.getId()-1)+")");
            }
            if(((currentCorridorRow*currentLevel.getRoomRangeNumber())) != herosRoom.getId()){
                System.out.println("Door (d"+(herosRoom.getId()+1)+")");
            }
        }

        for (Stair item:
                currentLevel.getStairs()) {
            if(item.getFirstRoomId() == herosRoom.getId()){
                System.out.println("Stairs (up)");
            }
            if(item.getSecondRoomId() == herosRoom.getId()){
                System.out.println("Stairs (down)");
            }
        }
        int mCount = 0;
        for (Monster item:
                herosRoom.getMonsters()) {
            System.out.println("Monster (m"+mCount+")");
            mCount++;
        }
        if(herosRoom.getTownsPeople().size() > 0){
            System.out.println("Rescue all hostage ("+herosRoom.getTownsPeople().size()+" hostage found)");
        }
        System.out.println("Write inv for open your inventory");

    }

    @Override
    public boolean attack(Monster nMonster) {
        System.out.println("Prepare for battle ! ");
        System.out.println("Monster's HP is "+nMonster.getHealthPoint());
        boolean turn = true;
        boolean blockState = false;
        while (true){
            if(turn){
                System.out.println("Your turn. Make your move !");
                System.out.println("Choose your movement:");
                System.out.println("Press 1 for attack");
                System.out.println("Press 2 for block");
                int movement = scannerSelectedRangeControlForInt(attackSelectors,scannerTakeIntegerInput());

                if(movement == 1){
                    System.out.println("You are attacking.");
                    int attackBonusState = (int)(Math.random()*(2-1+1)+1) ;
                    int attackBonus = 0;
                    if(attackBonusState == 1){
                        attackBonus = hero.getWeapon().getDamage() + ((int)(Math.random()*(hero.getWeapon().getRange()-1+1)+1));
                    }else{
                        attackBonus = hero.getWeapon().getDamage() - ((int)(Math.random()*(hero.getWeapon().getRange()-1+1)+1));
                    }
                    int attackDamage = (hero.getWeapon().getDamage() + attackBonus);
                    if(attackDamage < 0)
                        attackDamage = 0;
                    nMonster.setHealthPoint((nMonster.getHealthPoint() - attackDamage));
                    System.out.println("You inflicted "+(hero.getWeapon().getDamage() + attackBonus)+" points of damage");
                }else if(movement == 2){
                    System.out.println("You will try block.");
                    blockState = true;
                }
                System.out.println("Monster have "+nMonster.getHealthPoint()+" HP");

                turn = false;
            }else{
                System.out.println("Monster is attacking !");
                if(blockState){
                    System.out.println("you blocked the monster's damage ");
                    blockState = false;
                }else{
                    int monstersDamage = ((int)(Math.random()*(hero.getWeapon().getDamage()-1+1)+1)-((10 * (int)(Math.random()*(hero.getCloth().getProtection()-1+1)+1))/100));
                    if(monstersDamage < 0)
                        monstersDamage = 0;
                    hero.setHealthPoint(hero.getHealthPoint()-monstersDamage);
                    System.out.println("The monster has dealt you "+monstersDamage+" points of damage ");
                    System.out.println("You have "+hero.getHealthPoint()+" HP");

                }
                turn = true;
            }
            if(hero.getHealthPoint() <= 0)
                return false;
            if(nMonster.getHealthPoint() <= 0)
                return true;

        }
    }
}

