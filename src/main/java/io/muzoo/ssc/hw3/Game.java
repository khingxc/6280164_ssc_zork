package io.muzoo.ssc.hw3;

import io.muzoo.ssc.hw3.command.Command;
import io.muzoo.ssc.hw3.command.CommandFactory;
import io.muzoo.ssc.hw3.command.CommandParser;
import io.muzoo.ssc.hw3.command.allCmds.OutGameCommand;
import io.muzoo.ssc.hw3.enemy.Monster;
import io.muzoo.ssc.hw3.command.allCmds.OutGameCommand;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {

    //#############################################################################

    //set up

    private boolean startCheck = false;
    private GameOutput output = new GameOutput();
    private CommandParser commandParser = new CommandParser();

    //#############################################################################

    //player

    private Player player;
    public void setPlayer(Player p){
        this.player = p;
    }
    public Player getPlayer(){
        return player;
    }
    public Location getPlayerLoc() {
        return getPlayer().getCurrentLocationInLoc();
    }

    //#############################################################################

    //monsters

    private Monster targetToDefeat;
    private List<Monster> enemies = new ArrayList<>();

    public void setUpTarget(Monster t){
        this.targetToDefeat = t;
    }
    public Monster getTargetToDefeat(){
        return targetToDefeat;
    }

    public void setUpEnemies(List<Monster> e){
        this.enemies = e;
    }
    public void addEnemy(Monster e){
        enemies.add(e);
    }
    public List<Monster> getEnemies(){
        return enemies;
    }

    //#############################################################################

    //location

    private List<Location> maps = new ArrayList<>();

    public void setMap(List<Location> m){
        maps = m;
    }

    public List<Location> getMap(){
        return maps;
    }

    public void setTheMap(Game game){
        SurvivalMap.mapSetting(game);
    }

    //#############################################################################

    //start game checking

    public boolean isStartCheck(boolean startCheck){
        return startCheck;
    }

    public void setStart(boolean status){
        startCheck = status;
    }

    //#############################################################################

    public void run() {
        mainMenu();
        while (true) {
            Scanner in = new Scanner(System.in);
            String s = in.nextLine();
            List<String> words = commandParser.parse(s);
            Command command = CommandFactory.get(words.get(0));

            if (command != null) {
                if (startCheck) {
                    command.execute(this, words.subList(1, words.size()));
                    death(this);
                    ending();
                } else {
                    if (command instanceof OutGameCommand) {
                        command.execute(this, words.subList(1, words.size()));
                    }

                }
            }
        }
    }

    public void mainMenu(){
        output.println("--------------------------------------------------------");
        output.println("                       Zork                             ");
        output.println("     by Khwanchanok Chaichanayothinwatchara 6280164     ");
        output.println("        type: 'play survival' to start the game         ");
        output.println("--------------------------------------------------------");

    }

    public void ending(){
        if (!targetToDefeat.isAlive()){
            getOutput().println("Congrats! You defeat an evil witch!!");
            player.setAlive(false);
            startCheck = false;
            mainMenu();
        }
    }

    public void death(Game game){

        for (int i = 0; i < getEnemies().size(); i++ ){
            Monster e = getEnemies().get(i);
            if (e.getCurrentHP() <= 0){
                player.getCurrentLocationInLoc().setMonster(null);
                game.getOutput().println(e.getMonsterName() + " is dead");
                game.getOutput().println("Current HP has been upgraded to " + player.getDefaultAttackPower() + "!!!!");
                enemies.remove(e);
            }
        }

        if (player.getCurrentHP() <= 0){
            getOutput().println("player fainted, game over :(");
            player.setAlive(false);
            startCheck = false;
            mainMenu();

        }
    }

    public GameOutput getOutput() {
        return output;
    }

    public void exit() {
        System.exit(0);
    }
}
