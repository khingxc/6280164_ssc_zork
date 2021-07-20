package io.muzoo.ssc.hw3;

import io.muzoo.ssc.hw3.item.Item;

import java.util.HashMap;
import java.util.Map;

public class Player {

    private int fullHP;
    private int currentHP;
    private int defaultAttackPower;
    private boolean isAlive;
    private Location currentLocation_loc;
    protected Map<Item, Integer> bag = new HashMap<>();
    protected Map<String, Item> itemLst = new HashMap<>();

    public Player(){
        this.fullHP = 500;
        this.currentHP = 500;
        this.defaultAttackPower = 50;
        this.isAlive = true;
    }

    //about player

    //player stats

    public int getFullHP(){
        return this.fullHP;
    }

    public int getCurrentHP(){
        return this.currentHP;
    }

    //func to update player's HP when he/she takes potion or walks to another room
    //if walks to another room -> call addHP(hiddenHP)
    //if potion -> call addHP(potion)

    public void addHP(int toAddHP){
        if ((currentHP < fullHP) && ((currentHP + toAddHP) <= fullHP)){
            this.currentHP += toAddHP;
        }
        else{
            this.currentHP += fullHP - currentHP;
        }
        return;
    }

    public int getDefaultAttackPower(){
        return defaultAttackPower;
    }

    public int attackWithItem(Item item){
        if (item.getAttackPower() == 0 && item.getAddHP() > 0){
            addHP(item.getAddHP());
        }
        return defaultAttackPower + item.getAttackPower();
    }

    //items related
    public void keepItem(Item item){
        System.out.println(item.toString());
        if (!itemLst.containsKey(item.getItemName())){
            this.bag.put(item, 1);
            this.itemLst.put(item.getItemName(), item);
        }
        else{
            this.bag.put(item, bag.get(item) + 1);
        }
    }

    // if the value = 0 -> remove out
    public void removeItem(Item item){
        if (bag.get(item) == 0){
            bag.remove(item);
            itemLst.remove(item.getItemName());
        }
    }

    public Map<String, Item> getItemLst() {
        return itemLst;
    }

    public void dropItem(String itemName){
        Item item = itemLst.get(itemName);
        if (bag.get(item) == 0){
            removeItem((item));
        }
        else{
            bag.put(item, bag.get(item)-1);
        }
    }

    public Location getCurrentLocationInLoc(){
        return currentLocation_loc;
    }

    public void setPlayerLocation(Location newLocation){
        this.currentLocation_loc = newLocation;

    }

    public int wasAttacked(int attackPower){

        if ((currentHP - attackPower) > 0){
            currentHP = currentHP - attackPower;
        }
        else{
            currentHP = 0;
            this.isAlive = false;
        }

        return currentHP;

    }

    public boolean isAlive(){
        return isAlive;
    }

    public void setAlive(boolean bool){
        this.isAlive = bool;
    }

    public Map<Item, Integer> getPlayersItems(){
        return bag;
    }

    public void useItem(Item item){
        this.defaultAttackPower += item.getAttackPower();
    }


}
