package io.muzoo.ssc.hw3.command.allCmds;

import io.muzoo.ssc.hw3.Game;
import io.muzoo.ssc.hw3.Player;
import io.muzoo.ssc.hw3.map.*;
import io.muzoo.ssc.hw3.command.Command;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GoCommand implements Command {

    private List<String> dirs;
    private Map<String, Room> map;
    private Player player;

    public GoCommand(Player player, Map<String, Room> map){
        this.player = player;
        this.map = map;
        dirs = new ArrayList<>();
        dirs.add("north");
        dirs.add("south");
        dirs.add("east");
        dirs.add("west");
    }

    @Override
    public int numArgs() {
        return 1;
    }

    @Override
    public String getCommand() {
        return "go";
    }

    @Override
    public void execute(Game game, List<String> arguments) {

        if (arguments.size() < numArgs()){
            game.getOutput().println("where do you want to go?");
        }

        else if (arguments.size() > numArgs()){
            game.getOutput().println("sorry, there are too much arguments");
        }

        else{

            if (!dirs.contains(arguments)){
                System.out.println("Direction Not Found");
            }
            else{

            }
        }

    }
}
