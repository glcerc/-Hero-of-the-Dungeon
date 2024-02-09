# Hero of the Dungeon
The main purpose of the project is to analyze and model the given game project according to the object-oriented method, and to make its design based on the object. Object-oriented design principles in design and design patterns used.
APP Name: Hero of the Dungeon
Users: All age groups who enjoy playing games
# 1.2 Components of the Game
# 1.2.1 Items
There are two kinds of items in the game as clothes and weapons. There are three main categories of clothing, light clothing, leather armor, and chainmail armor. Four different outfits were created for each category. There are three main categories of weapons swords, 
axes, bows. For each main category there are three subcategories. Two weapons were created for each subcategory. The hero can use the outfits and weapons found by entering the inventory. Weapons and clothes drop randomly from killed monsters.
# 1.2.2 Characters
There are three characters in the game. The hero is driven by the player. There are people in the game who are taken hostage by monsters.
# 2. EXPLANATIONS ABOUT SOURCE CODES
Keywords: Composition - Inheritance - Polymorphism - Interfaces - Exceptions - Strings –
Files
There are 4 packages in our Project. Their names are Classes, Datas, Interfaces, Models in order.
# 2.1 Classes
There are 4 classes in the Classes package: Console, Game,Game Manager,System Manager
# 2.1.1 Console Class
The Console class is a subclass of the System Manager. The Inheritance structure was used here. Console class has 4 methods:
startUI ()
startMenu ()
startNewGame()
startLeaderBoard()
# 2.1.2 Game Class
The Game class is a subclass of the Game Manager. Game class has constructor,weaponsListCreator(), clothsListCreator( ), levelCreator( ),setWeapon,setCloth,controlHandler inside. A new Hero is created as a constructor parameter.
# 2.1.3 Game Manager Class
Game Manager is an abstract class. The Game Manager class is a subclass of the SystemManager.Game Manager class implements a Game interface.Game Manager class has levelCreator( ),dungeonCreator( ),stairCreator( ),monsterCreator(),townsPersonCreator( ),controlHandler(),monsterChooseItem( ), locationVisions( ),attack( ).Levels, attackSelectors,listOfWeapons,listOfClothes array lists created. Hero hero structure was created with the composition technique. Game Manager has a hero.Levels were created with the levelCreator() method. With the for loop, random rooms and corridors were created with the Math.random method for levels from 1 to 16. Added to the level array with the add method.Dungeons created with dungeonCreator() method. Game Manager class has stairCreator(), monsterCreator( ), townsPersonCreator( ),controlHnadler( ), monsterChooseItem( ) and locationVisions( ) methods.The hero attacks the monster with the attack() method.
# 2.1.4 System Manager Class
System Manager is an abstract class. System Manager class implements an System_ interface.With the scannerTakeIntegerInput() method, we get the input value that we defined as a String from the user and convert it from String to int with Integer.parseInt(input ). An error is thrown when entering a value other than the user's numeric value with Exception.System Manager has scannerSelectedRangeControlForInt(),detectLeaderBoard(),writePosition()methods.
# 2.2 Datas
This package has been created to hold data and files. File’s keyword used here.
# 2.2.1 Clothes.txt
The names, weights, values, main categories and protections of the clothes are kept in this file.
# 2.2.2 LeaderBoard.txt
The five high scores in the game are kept in this file. Sorted by the sum of the values of the items in the inventory and the number of people saved by the hero.
# 2.2.3 Weapons.txt
The names, weights, values, main categories,sub categories range and damage of the weapons are kept in this file.
# 2.3 Interfaces
The mandatory methods used in Game Manager and System Manager in the project were written and implemented in the Interface package.
# 2.3.1 Game
# 2.3.2 System_
# 2.3 Models
The Models package is built for property-holding classes.
# 2.3.1 Character
Character class is super(base) class. Hero,Monster,TownsPerson extends Character.Inheritance and polymorphism are used. Character class has int type id,currentRoom variables. Set get methods are used.
# 2.3.2 Cloth
Cloth class has int type id, weight,value, mainCategory,production variables and String type name variable.Constructor created set get methods are used.
# 2.3.3 Corridor
Corridor class has int type id, level class variables. Room arraylist created. Constructorcreated set get methods are used.
# 2.3.4 Hero
Hero class is a subclass of the Character class. Extended, inheritance and polymorphism are used.Hero class has int type healthPoint,maxHealthPoint,gender,maxWeight,currentWeight,numberOfRescue,level,currentRoom,currentScore variables and String type name variable. With the composition structure, an object from the clothing and weapon class has been created in the item class. (Cloth cloth,Weapon weapon) .Hero class has a weapon and cloth. Constructor created set get methods are used.
# 2.3.5 Item
Item class has int type id, current type variables. With the composition structure, an object from the clothing and weapon class has been created in the item class. (Cloth cloth,Weapon weapon) .Item class has a weapon and cloth. Constructor created set get methods are used.
# 2.3.6 Level
Level class has int type level,corridorRangeNumber,roomRangeNumbervariables..Constructor created set get methods are used.
# 2.3.7 Monster
Monster class is a subclass of the Character class. Extended, inheritance and polymorphism are used. Monster class has int type healthPoint,currentLevel variables. The items that will drop from the monsters when they die are created with the arraylist method in the name of inventory. Constructor created set get methods are used.
# 2.3.8 Room 
Room class has int type id variable. The monster and townspeople that should be in the room were created with the arraylist method.. Constructor created set get methods are used.
# 2.3.9 Stair
Stair class has int type firstRoomId, secondRoomId variables. Constructor created set get methods are used.
# 2.3.10 TownsPerson
TownsPerson class is a subclass of the Character class. Extended, inheritance and polymorphism are used. TownsPerson class has int type currentLevel,healthRestorationPoint variables.Constructor created set get methods are used.
# 2.3.11 Weapon
Weapon class has int type id, weight,value,mainCategory,subCategory,damage,rangevariables and String type name variable. Constructor created set get methods are used
