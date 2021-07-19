package io.muzoo.ssc.hw3.item;

public class Item {

    protected String itemName;
    protected String description;
    protected int attackPower;
    protected int addHP;
    protected int timeUsing;

    public Item(int attackPower, int addHP, int timeUsing){
       this.attackPower = attackPower;
       this.addHP = addHP;
       this.timeUsing = timeUsing;
    }

    public String getItemName(){
        return itemName;
    }

    public String getDescription(){
        return description;
    }

    public int getAddHP(){
        return addHP;
    }

    public int getAttackPower(){
        return attackPower;
    }

    public int getTimeUsing(){
        return timeUsing;
    }

}
