package io.muzoo.ssc.hw3.command.allCmds;

import io.muzoo.ssc.hw3.Game;
import io.muzoo.ssc.hw3.Location;
import io.muzoo.ssc.hw3.Player;
import io.muzoo.ssc.hw3.command.Command;
import io.muzoo.ssc.hw3.item.Item;

import java.util.List;
import java.util.Locale;

public class TakeCommand implements Command {

    private Player player;

    @Override
    public int numArgs() {
        return 0;
    }

    @Override
    public String getCommand() {
        return "take";
    }

    @Override
    public void execute(Game game, List<String> arguments) {

        this.player = game.getPlayer();
        Location currentLoc = game.getPlayerLoc();
        if (currentLoc.hasItem() != null) {
            player.keepItem(currentLoc.hasItem());
            game.getOutput().println(currentLoc.hasItem().getItemName() + " has been added into the bag!");
            currentLoc.setItem(null);
        }
        else{
            game.getOutput().println("There is no item to keep around here :(");
        }
    }
}
