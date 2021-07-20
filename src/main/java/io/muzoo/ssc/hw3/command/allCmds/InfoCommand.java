/*
print out information of the player and the room that the player is currently in, this command only available while playing game. These are:
Player stats, e.g. HP/HP Max, attack power, etc.
Room information, e.g. Monster stats (if any), item stats (if any), doors, etc.
 */


package io.muzoo.ssc.hw3.command.allCmds;

import io.muzoo.ssc.hw3.Game;
import io.muzoo.ssc.hw3.Location;
import io.muzoo.ssc.hw3.Player;
import io.muzoo.ssc.hw3.command.Command;
import io.muzoo.ssc.hw3.item.Item;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InfoCommand implements Command {

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
        Player player = game.getPlayer();
        Location location = game.getPlayerLoc();
        game.getOutput().println("current location: " + location.getDescription());
        if (location.hasItem() == null){
            game.getOutput().println("there is no item nearby :(");
        }
        else{
            game.getOutput().println("item nearby: " + location.hasItem().getItemName());
        }

        if (location.hasMonster() != null){
            game.getOutput().println("There is an enemy here nearby you");
            game.getOutput().println("enemy name: " + location.hasMonster().getMonsterName());
            game.getOutput().println("enemy current HP: " + location.hasMonster().getCurrentHP());
        }
        game.getOutput().println("your current HP: " + player.getCurrentHP());
        game.getOutput().println("your attack value: " + player.getDefaultAttackPower());
        game.getOutput().println("item(s) in the bag: " + player.getPlayersItems().size());
        Map<Item, Integer> playersBag = player.getPlayersItems();
        if (player.getPlayersItems().size() > 0){
            for (Map.Entry<Item, Integer> item : playersBag.entrySet()) {
                System.out.println("* " + item.getKey().getItemName() + " [" + item.getValue() + "] ");
            }
        }

    }
}
