package io.muzoo.ssc.hw3.map;

public class SurvivalMap {

    public Location currentLocation;

    private Location entrance, camping, forest, mountains, libraryInTheForest, flowerField,
            besidesLake, bridge, treeTunnel, darkForest, witchHouse, exit;

    public void createRooms(){

        // create the rooms
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

        //survival map

        //entrance
        entrance.setExits("east", forest);
        entrance.setExits("south", camping);

        //forest
        forest.setExits("west", entrance);
        forest.setExits("south", flowerField);
        forest.setExits("east", mountains);

        //mountain forest
        mountains.setExits("west", forest);
        mountains.setExits("south", libraryInTheForest);

        //camping
        camping.setExits("north", entrance);

        //flower fields
        flowerField.setExits("north", forest);
        flowerField.setExits("south", bridge);

        //library in the forest
        libraryInTheForest.setExits("north", mountains);
        libraryInTheForest.setExits("south", besidesLake);

        //tree tunnel
        treeTunnel.setExits("east", bridge);
        treeTunnel.setExits("south", darkForest);

        //bridge
        bridge.setExits("north", flowerField);
        bridge.setExits("west", treeTunnel);
        bridge.setExits("east", besidesLake);

        //besides the lake
        besidesLake.setExits("north", libraryInTheForest);
        besidesLake.setExits("west", bridge);

        //dark forest
        darkForest.setExits("north", treeTunnel);
        darkForest.setExits("east", witchHouse);

        //witch house
        witchHouse.setExits("west", darkForest);
        witchHouse.setExits("east", exit);

        //exit
        exit.setExits("west", witchHouse);

    }
}
