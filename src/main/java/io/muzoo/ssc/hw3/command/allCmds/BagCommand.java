package io.muzoo.ssc.hw3.command.allCmds;

import io.muzoo.ssc.hw3.Game;
import io.muzoo.ssc.hw3.Player;
import io.muzoo.ssc.hw3.command.Command;
import io.muzoo.ssc.hw3.item.Item;

import java.util.List;
import java.util.Map;

public class BagCommand implements Command {

    private Player player;

    @Override
    public int numArgs() {
        return 0;
    }

    @Override
    public String getCommand() {
        return "bag";
    }

    @Override
    public void execute(Game game, List<String> arguments) {
        player = game.getPlayer();
        game.getOutput().println("item(s) in the bag: " + player.getPlayersItems().size());
        Map<Item, Integer> playersBag = player.getPlayersItems();
        if (player.getPlayersItems().size() > 0){
            for (Map.Entry item : playersBag.entrySet()) {
                System.out.println("* " + item.getKey() + " [" + item.getValue() + "] ");
            }
        }
    }
}
