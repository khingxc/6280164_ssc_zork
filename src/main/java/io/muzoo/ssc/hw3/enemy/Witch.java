package io.muzoo.ssc.hw3.enemy;

import io.muzoo.ssc.hw3.Game;
import io.muzoo.ssc.hw3.Location;

public class Witch extends Monster {

    public Witch(Game game, Location location) {
        super(game, 600, 600, 100, location);
        monsterName = "witch";
    }

}
