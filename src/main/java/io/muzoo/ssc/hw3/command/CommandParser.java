package io.muzoo.ssc.hw3.command;

import io.muzoo.ssc.hw3.command.Command;
import io.muzoo.ssc.hw3.command.CommandFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommandParser {

    private List<String> allCommandsSortedByLength = new ArrayList<>();
    {
        allCommandsSortedByLength.addAll(CommandFactory.getAllCommands());
        allCommandsSortedByLength.sort((o1, o2) -> o2.length() - o1.length());
    }

    private String matchInputCommand(String input){
        for (String command: allCommandsSortedByLength){
            if (input.startsWith(command)){
                return command;
            }
        }
        return null;
    }

    // "attack with weapon" -> ["attack with", "weapon"]
    public List<String> parse(String stringInput){
        String cleanedInput = stringInput.trim();
        String cmd = matchInputCommand(cleanedInput);
        Command command = CommandFactory.get(cmd);
        if (command.numArgs() > 0){
            //TODO: checking for space
            //TODO: handle invalid number of argument
            String argString = cleanedInput.substring(cmd.length() + 1);
            System.out.println(argString);
            return Arrays.asList(cmd, argString);
        }
        else{
            return Arrays.asList(cmd);
        }

    }

}
