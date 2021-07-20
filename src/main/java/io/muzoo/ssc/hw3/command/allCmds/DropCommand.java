package io.muzoo.ssc.hw3.command.allCmds;

import io.muzoo.ssc.hw3.Game;
import io.muzoo.ssc.hw3.Player;
import io.muzoo.ssc.hw3.command.Command;

import java.util.List;

public class DropCommand implements Command {

    private Player player;

    public DropCommand(){

    }

    @Override
    public int numArgs() {
        return 1;
    }

    @Override
    public String getCommand() {
        return "drop";
    }

    @Override
    public void execute(Game game, List<String> arguments) {

        this.player = game.getPlayer();

        if (player.getPlayersItems().containsKey(arguments.get(0))){
            player.dropItem(arguments.get(0));
            game.getOutput().println("You have dropped a " + arguments.get(0));
        }
        else{
            game.getOutput().println("You can't drop it since you don't have this item in your bag.");
        }

    }
}
