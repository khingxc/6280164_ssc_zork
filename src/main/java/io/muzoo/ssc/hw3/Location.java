package io.muzoo.ssc.hw3;

import io.muzoo.ssc.hw3.enemy.Monster;
import io.muzoo.ssc.hw3.item.Item;

import java.util.HashMap;

public class Location {

    //references from ZUUL project from third assignment from Data Structures class

    private final String description; //create variable called description (of each room) which cannot be override since it is 'final'
    protected Monster monster;
    protected Item item;
    private boolean getToExit = false;

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

    public Monster hasMonster(){
        return monster;
    }

    public boolean isGetToExit(){
        return getToExit;
    }

    public Item hasItem() {
        return item;
    }

    public void setMonster(Monster monster){
        this.monster = monster;
    }

    public void setItem(Item item){
        this.item = item;
    }

}
