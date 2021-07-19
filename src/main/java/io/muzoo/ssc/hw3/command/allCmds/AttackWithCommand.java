package io.muzoo.ssc.hw3.command.allCmds;

import io.muzoo.ssc.hw3.Game;
import io.muzoo.ssc.hw3.monster.MonsterFactory;
import io.muzoo.ssc.hw3.Player;
import io.muzoo.ssc.hw3.command.Command;

import java.util.List;

public class AttackWithCommand implements Command {

    @Override
    public int numArgs() {
        return 0;
    }

    @Override
    public String getCommand() {
        return null;
    }

    @Override
    public void execute(Game game, List<String> arguments) {

    }
}
