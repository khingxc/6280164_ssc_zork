package io.muzoo.ssc.hw3.map;

import java.util.HashMap;

public class Room {

    //references from ZUUL project from third assignment from Data Structures class

    private final String description; //create variable called description (of each room) which cannot be override since it is 'final'

    public Room(String description){
        this.description = description;
    }

    HashMap<String,Room> directionSetting = new HashMap<String,Room>();

    public void getDirectionSetting() {
        directionSetting.put("north",null);
        directionSetting.put("east",null);
        directionSetting.put("west",null);
        directionSetting.put("south",null);
    }

    public Room nextRoom(String dir, Room currentRoom){
        return currentRoom.directionSetting.get(dir);
    }

    public void setExits(String direction, Room neighbor){
        directionSetting.put(direction,neighbor);
    }

    public String getDescription() {
        return description;
    }

}
