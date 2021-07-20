package io.muzoo.ssc.hw3;

import io.muzoo.ssc.hw3.Game;
import io.muzoo.ssc.hw3.Location;
import io.muzoo.ssc.hw3.Player;
import io.muzoo.ssc.hw3.enemy.*;
import io.muzoo.ssc.hw3.item.*;

public class SurvivalMap {

    public static void mapSetting(Game game){

        Location entrance, camping, forest, mountains, libraryInTheForest, flowerField,
                   besidesLake, bridge, treeTunnel, darkForest, witchHouse, exit;

        // create location
        entrance = new Location(" the entrance of this mysterious maze! ");
        camping = new Location(" the camping where there are lots of stuffs here, seems like there were people here, but they were gone.");
        forest = new Location("in the middle of the forest where the sun can reach to :)");
        mountains = new Location("the outside of the forest where I can see mountains in the far distance!!! The view from here is so nice");
        libraryInTheForest = new Location("the library in the forest (again) but it is so quite and chill here. Good place for reading :)");
        flowerField = new Location("the flower field where there are lots of little colourful flowers. It's amazing!");
        besidesLake = new Location("in the middle of the forest where there are less trees and is nearby the lake. Good spot for taking a break!");
        bridge = new Location("the bridge which is so long but the view there is all around beautiful along the way!");
        treeTunnel = new Location("in the tree tunnel where it is so dark in here.");
        darkForest = new Location("in the middle of the forest where all around is dark, no sunlight, dying trees. This is so scary!!!");
        witchHouse = new Location("the witch house where there are lots of candies and snacks! Is a devilish witch here!?!?!?");
        exit = new Location("the exit! Congrats!, you can get to the town safely!");

        //add to game
        game.getMap().add(entrance);
        game.getMap().add(camping);
        game.getMap().add(mountains);
        game.getMap().add(camping);
        game.getMap().add(flowerField);
        game.getMap().add(libraryInTheForest);
        game.getMap().add(treeTunnel);
        game.getMap().add(bridge);
        game.getMap().add(besidesLake);
        game.getMap().add(darkForest);
        game.getMap().add(witchHouse);
        game.getMap().add(exit);

        //survival map

        //entrance
        entrance.setExits("east", forest);
        entrance.setExits("south", camping);
        entrance.setMonster(null);
        entrance.setItem(null);

        //forest
        forest.setExits("west", entrance);
        forest.setExits("south", flowerField);
        forest.setExits("east", mountains);
        forest.setMonster(null);
        forest.setItem(null);

        //mountain forest
        mountains.setExits("west", forest);
        mountains.setExits("south", libraryInTheForest);
        mountains.setMonster(null);
        mountains.setItem(new Stick());


        //camping
        camping.setExits("north", entrance);
        camping.setMonster(new Bear(game, camping));
        camping.setItem(new Stick());

        //flower fields
        flowerField.setExits("north", forest);
        flowerField.setExits("south", bridge);
        flowerField.setMonster(null);
        flowerField.setItem(new Poison());

        //library in the forest
        libraryInTheForest.setExits("north", mountains);
        libraryInTheForest.setExits("south", besidesLake);
        libraryInTheForest.setMonster(new Fox(game, libraryInTheForest));
        libraryInTheForest.setItem(new Potion());

        //tree tunnel
        treeTunnel.setExits("east", bridge);
        treeTunnel.setExits("south", darkForest);
        treeTunnel.setMonster(null);
        treeTunnel.setItem(null);

        //bridge
        bridge.setExits("north", flowerField);
        bridge.setExits("west", treeTunnel);
        bridge.setExits("east", besidesLake);
        bridge.setMonster(new Tiger(game, bridge));
        bridge.setItem(new Poison());

        //besides the lake
        besidesLake.setExits("north", libraryInTheForest);
        besidesLake.setExits("west", bridge);
        besidesLake.setMonster(new Bear(game, besidesLake));
        besidesLake.setItem(new Potion());

        //dark forest
        darkForest.setExits("north", treeTunnel);
        darkForest.setExits("east", witchHouse);
        darkForest.setMonster(new Tiger(game, darkForest));
        darkForest.setItem(new Gun());

        //witch house
        witchHouse.setExits("west", darkForest);
        witchHouse.setExits("east", exit);
        witchHouse.setMonster(new Witch(game, witchHouse));
        witchHouse.setItem(null);

        //exit
        exit.setExits("west", witchHouse);
        exit.setMonster(null);
        exit.setItem(null);

        //enemies
//        game.getEnemies().add(entrance.monster);
//        game.getEnemies().add(forest.monster);
//        game.getEnemies().add(mountains.monster);
//        game.getEnemies().add(flowerField.monster);
//        game.getEnemies().add(treeTunnel.monster);
//        game.getEnemies().add(exit.monster);
        game.getEnemies().add(camping.monster);
        game.getEnemies().add(libraryInTheForest.monster);
        game.getEnemies().add(bridge.monster);
        game.getEnemies().add(besidesLake.monster);
        game.getEnemies().add(darkForest.monster);
        game.setUpTarget(witchHouse.monster);

        //target to defeat
        game.setUpTarget(witchHouse.monster);

    }
}
