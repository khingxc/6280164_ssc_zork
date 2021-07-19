package io.muzoo.ssc.hw3.command.allCmds;

import io.muzoo.ssc.hw3.Game;
import io.muzoo.ssc.hw3.command.CommandFactory;
import io.muzoo.ssc.hw3.command.Command;

import java.util.List;

public class HelpCommand implements Command {

    @Override
    public int numArgs() {
        return 0;
    }

    @Override
    public String getCommand() {
        return "help";
    }

    @Override
    public void execute(Game game, List<String> arguments) {
        List<String> allCmds = CommandFactory.getAllCommands();                      //list of all commands from Command Factory
        game.getOutput().println("The followings are valid commands you can use.");  //print the head message

        //looping through the list and print out each command
        for (int i = 0; i < allCmds.size(); i++){
            System.out.println(i + 1 + ") " + allCmds.indexOf(i) + '\n');
        }
    }
}
