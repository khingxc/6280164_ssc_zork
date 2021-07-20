package io.muzoo.ssc.hw3.enemy;

import io.muzoo.ssc.hw3.Game;
import io.muzoo.ssc.hw3.item.Item;
import io.muzoo.ssc.hw3.Location;

import java.util.HashMap;
import java.util.Map;

public class Monster {

    protected String monsterName;
    private boolean isAlive = true;
    protected int defaultAttackPower;
    protected int fullHP;
    protected int currentHP;
    protected Item holdItem;
    protected Location location;
    protected Map<String, Monster> monsterMap = new HashMap<>();

    public Monster(Game game, int fullHP, int currentHP, int attackPower, Location location){
        this.fullHP = fullHP;
        this.currentHP = currentHP;
        this.defaultAttackPower = defaultAttackPower;
        this.location = location;
    }

    public boolean isAlive(){
        return isAlive;
    }

    public String getMonsterName(){
        return monsterName;
    }

    public int getFullHP(){
        return fullHP;
    }

    public int getAttackPower(){
        return defaultAttackPower;
    }

    public int getCurrentHP(){
        return currentHP;
    }

    public int wasAttacked(int attackPower){

        if ((currentHP - attackPower) > 0){
            currentHP = currentHP - attackPower;
        }
        else {
            currentHP = 0;
            this.isAlive = false;
        }

        return currentHP;

    }

    public Location getLocation(){
        return location;
    }

}
