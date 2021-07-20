package io.muzoo.ssc.hw3.enemy;

import io.muzoo.ssc.hw3.Game;
import io.muzoo.ssc.hw3.Location;

public class Fox extends Monster {

    public Fox(Game game, Location location) {
        super(game, 200, 200, 50, location);
        monsterName = "fox";
    }

}
