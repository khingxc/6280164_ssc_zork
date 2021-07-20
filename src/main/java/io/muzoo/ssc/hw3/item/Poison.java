package io.muzoo.ssc.hw3.item;

public class Poison extends Item {

    // if using poison, it will die immediately;
    // low possibility to get one
    // time using = 1;

    public Poison() {
        super(500, 0, 1);
        itemName = "poison";
        description = "by throwing this poison at the monster, you won't have to do anything much :)";
    }
}
