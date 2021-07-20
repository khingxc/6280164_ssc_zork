package io.muzoo.ssc.hw3.command.allCmds;

import io.muzoo.ssc.hw3.Game;
import io.muzoo.ssc.hw3.Player;
import io.muzoo.ssc.hw3.command.Command;

import java.util.List;

public class TakeCommand implements Command {

    private Player player;
    private List<String> item;

    public TakeCommand(Player player){
        this.player = player;
    }

    @Override
    public int numArgs() {
        return 1;
    }

    @Override
    public String getCommand() {
        return "take";
    }

    @Override
    public void execute(Game game, List<String> arguments) {
        System.out.println("hi");
    }
}
