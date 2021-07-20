package io.muzoo.ssc.hw3.command;

import io.muzoo.ssc.hw3.command.allCmds.*;

import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.util.stream.Collectors;

public class CommandFactory {

    private static final List<Class<? extends Command>> REGISTERED_COMMANDS = Arrays.asList(
//            AttackWithCommand.class,
//            DropCommand.class,
            ExitCommand.class, HelpCommand.class);
//            GoCommand.class,
//            HelpCommand.class,
//            InfoCommand.class,
//            PlayCommand.class,
//            QuitCommand.class,
//            TakeCommand.class);

    private static final Map<String, Command> COMMANDS_MAP = new HashMap<>();

    static {{
        for (Class<? extends Command> commandClass: REGISTERED_COMMANDS){
            try {
                Command command = commandClass.getDeclaredConstructor().newInstance(); //commandClass.getDeclaredConstructor().newInstance();
                COMMANDS_MAP.put(command.getCommand(), command);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        }
    }}

    public static Command get(String command){
        return COMMANDS_MAP.get(command);
    }

    public static List<String> getAllCommands(){
        return COMMANDS_MAP.keySet().stream().collect(Collectors.toList());
    }

}
