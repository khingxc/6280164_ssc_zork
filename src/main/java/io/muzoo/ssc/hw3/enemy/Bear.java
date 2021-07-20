package io.muzoo.ssc.hw3.enemy;

import io.muzoo.ssc.hw3.Game;
import io.muzoo.ssc.hw3.Location;

public class Bear extends Monster {

    public Bear(Game game, Location location) {
        super(game, 300, 300, 60, location);
        monsterName = "bear";
    }

}
