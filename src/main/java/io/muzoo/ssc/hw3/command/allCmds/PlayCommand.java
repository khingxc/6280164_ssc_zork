package io.muzoo.ssc.hw3.command.allCmds;

import io.muzoo.ssc.hw3.Game;
import io.muzoo.ssc.hw3.Player;
import io.muzoo.ssc.hw3.SurvivalMap;
import io.muzoo.ssc.hw3.command.Command;

import java.util.List;

public class PlayCommand implements OutGameCommand {
    @Override
    public int numArgs() {
        return 1;
    }

    @Override
    public String getCommand() {
        return "play";
    }

    @Override
    public void execute(Game game, List<String> arguments) {
        game.setTheMap(game);
        game.getOutput().println("set the map               ––checked");
        game.setPlayer(new Player());
        game.getOutput().println("set player                ––checked");
        game.getPlayer().setPlayerLocation(game.getMap().get(0));
        game.getOutput().println("set exposition for user   ––checked");
        game.setStart(true);
        game.getOutput().println("set start to be true      ––checked");
        game.getOutput().println("-----------------------------------------------------------------------------------------------");
        game.getOutput().println("GAME STARTED");
        game.getOutput().println("You were taken to the entrance of the mysterious maze, you need to find the way home!");
        game.getOutput().println("You task: to defeat one last enemy.");
        game.getOutput().println("You can skip others, but you will be stronger after you fight with them :)");
        game.getOutput().println("Good Luck!");
        game.getOutput().println("-----------------------------------------------------------------------------------------------");
    }
}
