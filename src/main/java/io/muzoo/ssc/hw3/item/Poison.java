package io.muzoo.ssc.hw3.item;

public class Poison extends Item {

    // if using poison, it will die immediately;
    // low possibility to get one
    // time using = 1;

    public Poison(int attackPower, int addHP, int timeUsing) {
        super(attackPower, 0, 1);
        itemName = "poison";
        description = "by throwing this poison at the monster, it will die immediately.";
    }
}
