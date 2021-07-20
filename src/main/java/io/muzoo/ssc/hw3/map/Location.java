package io.muzoo.ssc.hw3.map;

import java.util.HashMap;

public class Location {

    //references from ZUUL project from third assignment from Data Structures class

    private final String description; //create variable called description (of each room) which cannot be override since it is 'final'

    public Location(String description){
        this.description = description;
    }

    HashMap<String, Location> directionSetting = new HashMap<String, Location>();

    public void getDirectionSetting() {
        directionSetting.put("north",null);
        directionSetting.put("east",null);
        directionSetting.put("west",null);
        directionSetting.put("south",null);
    }

    public Location nextRoom(String dir, Location currentLocation){
        return currentLocation.directionSetting.get(dir);
    }

    public void setExits(String direction, Location neighbor){
        directionSetting.put(direction,neighbor);
    }

    public String getDescription() {
        return description;
    }

}
