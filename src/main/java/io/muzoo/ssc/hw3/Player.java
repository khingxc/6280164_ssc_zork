package io.muzoo.ssc.hw3;

import io.muzoo.ssc.hw3.item.Item;
import io.muzoo.ssc.hw3.map.Location;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Player {

    private String playerName;
    private int fullHP;
    private int currentHP;
    private int hiddenHP;
    private int defaultAttackPower;
    private Location currentLocation_loc;
    private String currentLocation_str;
    private List<Item> bag = new ArrayList<>();

    public Player(){
        fullHP = 500;
        currentHP = 500;
        hiddenHP = 50;
        defaultAttackPower = 50;
    }

    //about player

    public String getPlayerName(){
        return playerName;
    }

    //player stats

    public int getFullHP(){
        return fullHP;
    }

    public int getCurrentHP(){
        return currentHP;
    }

    //func to update player's HP when he/she takes potion or walks to another room
    //if walks to another room -> call addHP(hiddenHP)
    //if potion -> call addHP(potion)

    public void addHP(int toAddHP){
        if ((currentHP < fullHP) && ((currentHP + toAddHP) <= fullHP)){
            currentHP += toAddHP;
        }
        else{
            currentHP += fullHP - currentHP;
        }
    }

    public int getDefaultAttackPower(){
        return defaultAttackPower;
    }

    //items related
    public void keepItem(Item item){
        bag.add(item);
        System.out.println(item + " is being kept to the bag");
    }

    public Location getCurrentLocationInLoc(){
        return currentLocation_loc;
    }

    public void wasAttacked(int attackPower){

        if ((currentHP - attackPower) > 0){
            currentHP -= attackPower;
        }
        else{
            currentHP = 0;
        }

    }

    public void useItem(Item item){
        defaultAttackPower += item.getAttackPower();
    }

}
