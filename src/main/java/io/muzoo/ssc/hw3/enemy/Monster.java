package io.muzoo.ssc.hw3.enemy;

public class Monster {

    protected String monsterName;
    protected int defaultAttackPower;
    protected int fullHP;
    protected int currentHP;
    protected boolean alive;

    public Monster(int fullHP, int currentHP, int attackPower){
        this.fullHP = fullHP;
        this.currentHP = currentHP;
        this.defaultAttackPower = defaultAttackPower;
        this.alive = true;
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
        else{
            currentHP = 0;
            alive = false;
        }

        return currentHP;

    }

}
