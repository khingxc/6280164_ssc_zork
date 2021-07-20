package io.muzoo.ssc.hw3.command.allCmds;

import io.muzoo.ssc.hw3.Game;
import io.muzoo.ssc.hw3.Player;
import io.muzoo.ssc.hw3.command.Command;
import io.muzoo.ssc.hw3.enemy.Monster;
import io.muzoo.ssc.hw3.item.Item;

import java.util.List;
import java.util.Map;

public class AttackWithCommand implements Command {

    private Player player;
    private Monster monster;

    @Override
    public int numArgs() {
        return 1;
    }

    @Override
    public String getCommand() {
        return "attack with";
    }

    @Override
    public void execute(Game game, List<String> arguments) {

        player = game.getPlayer();
        monster = game.getPlayer().getCurrentLocationInLoc().hasMonster();
        Item tool = player.getItemLst().get(arguments.get(0));
//        game.getOutput().println(tool.getItemName());
        if ((player.getItemLst().containsKey(arguments.get(0))) && (player.getPlayersItems().get(tool) > 0)){
            game.getOutput().println("Player uses " + tool.getItemName() + " to fight with an enemy!");
            monster.wasAttacked(player.attackWithItem(tool));
            tool.updateTimeUsing();
            game.getOutput().println("current enemy HP: " + monster.getCurrentHP());
        }
        else{
            game.getOutput().println("Item you called is not in the bag\n");
            game.getOutput().println("Let's see what you currently have in your bag.\n");
            game.getOutput().println("item(s) in the bag: " + player.getPlayersItems().size());
            Map<Item, Integer> playersBag = player.getPlayersItems();
            if (player.getPlayersItems().size() > 0){
                for (Map.Entry<Item, Integer> item : playersBag.entrySet()) {
                    System.out.println("* " + item.getKey().getItemName() + " [" + item.getValue() + "] ");
                }
            }
        }
        if (game.getPlayerLoc().hasMonster().isAlive()) {
            game.getOutput().println(monster.getMonsterName() + " attacked you back!");
            player.wasAttacked(monster.getAttackPower());
            game.getOutput().println("current HP: " + player.getCurrentHP());
        }




    }
}
