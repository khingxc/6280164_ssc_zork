package io.muzoo.ssc.hw3.enemy;

public class Enemy {

    protected String enemyName;
    protected int attackPower;
    protected int fullHP;
    protected int currentHP;
    protected boolean alive;

    public Enemy(int fullHP, int currentHP, int attackPower, boolean alive){
        this.fullHP = fullHP;
        this.currentHP = currentHP;
        this.attackPower = attackPower;
        this.alive = alive;
    }

    public String getEnemyName(){
        return enemyName;
    }

    public int getFullHP(){
        return fullHP;
    }

    public int getAttackPower(){
        return attackPower;
    }

    public int getCurrentHP(){
        return currentHP;
    }

}
