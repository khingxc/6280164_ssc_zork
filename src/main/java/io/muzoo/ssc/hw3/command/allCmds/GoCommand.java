package io.muzoo.ssc.hw3.command.allCmds;

import io.muzoo.ssc.hw3.Game;
import io.muzoo.ssc.hw3.Location;
import io.muzoo.ssc.hw3.Player;
import io.muzoo.ssc.hw3.command.Command;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GoCommand implements Command {

    private List<String> dirs;
    private Player player;
    private Location currentRoom;
    private String dir;

    public GoCommand(){
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

        this.player = game.getPlayer();
        this.currentRoom = game.getPlayerLoc();
        this.dir = arguments.get(0);

        if (arguments.size() < numArgs()){
            game.getOutput().println("where do you want to go?");
        }

        else if (arguments.size() > numArgs()){
            game.getOutput().println("please specify place you want to go!");
        }

        else{

            if (!(dirs.contains(dir))){
                game.getOutput().println("The direction you are putting in does not exist");
                game.getOutput().println("The available directions are");
                for (String d : dirs){
                    game.getOutput().println("* " + d);
                }
            }
            else{
                Location destination = currentRoom.nextRoom(dir, currentRoom);
                if (destination != null){
                    player.setPlayerLocation(destination);
                    player.addHP(10);
                }
                else{
                    game.getOutput().println("Sorry, you can't go that way :(");
                }
            }

        }

    }
}
