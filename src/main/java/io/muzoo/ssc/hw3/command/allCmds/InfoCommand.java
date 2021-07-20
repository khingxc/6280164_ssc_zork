/*
print out information of the player and the room that the player is currently in, this command only available while playing game. These are:
Player stats, e.g. HP/HP Max, attack power, etc.
Room information, e.g. Monster stats (if any), item stats (if any), doors, etc.
 */


package io.muzoo.ssc.hw3.command.allCmds;

import io.muzoo.ssc.hw3.Game;
import io.muzoo.ssc.hw3.Player;
import io.muzoo.ssc.hw3.command.Command;

import java.util.List;

public class InfoCommand implements Command {

    private Player player;

    public InfoCommand(Player player){
        this.player = player;
    }

    @Override
    public int numArgs() {
        return 0;
    }

    @Override
    public String getCommand() {
        return "info";
    }

    @Override
    public void execute(Game game, List<String> arguments) {
        game.getOutput().println("current location: " + player.getCurrentLocationInLoc().getDescription());
    }
}
