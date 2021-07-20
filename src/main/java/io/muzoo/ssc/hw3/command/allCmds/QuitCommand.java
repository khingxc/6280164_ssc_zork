package io.muzoo.ssc.hw3.command.allCmds;

import io.muzoo.ssc.hw3.Game;
import io.muzoo.ssc.hw3.command.Command;

import java.util.List;

public class QuitCommand implements Command {

    @Override
    public int numArgs() {
        return 0;
    }

    @Override
    public String getCommand() {
        return "quit";
    }

    @Override
    public void execute(Game game, List<String> arguments) {
        game.getOutput().println("Back to Main Menu Page");
        game.setStart(false);
        game.mainMenu();
    }
}
