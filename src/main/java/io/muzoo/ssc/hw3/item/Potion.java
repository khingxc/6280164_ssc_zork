package io.muzoo.ssc.hw3.item;

public class Potion extends Item{

    public Potion() {
        super(0, 100, 1);
        itemName = "potion";
        description = "by drinking potion, it will boost up your energy by 100";
    }

}
