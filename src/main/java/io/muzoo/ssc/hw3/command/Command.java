package io.muzoo.ssc.hw3.command;

import io.muzoo.ssc.hw3.Game;
import java.util.List;

public interface Command {

    int numArgs();

    String getCommand();

    void execute(Game game, List<String> arguments);

}
