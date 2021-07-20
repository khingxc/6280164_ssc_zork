package io.muzoo.ssc.hw3.enemy;

import io.muzoo.ssc.hw3.Game;
import io.muzoo.ssc.hw3.Location;

public class Tiger extends Monster {

    public Tiger(Game game, Location location) {
        super(game, 350, 350, 70, location);
        monsterName = "tiger";
    }

}
