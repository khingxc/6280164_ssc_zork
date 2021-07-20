package io.muzoo.ssc.hw3.command.allCmds;

import io.muzoo.ssc.hw3.Game;
import io.muzoo.ssc.hw3.command.Command;

import java.util.List;

public class PlayCommand implements Command {
    @Override
    public int numArgs() {
        return 1;
    }

    @Override
    public String getCommand() {
        return "play command";
    }

    @Override
    public void execute(Game game, List<String> arguments) {
        System.out.println("hi");
    }
}
