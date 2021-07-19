package io.muzoo.ssc.hw3;

import io.muzoo.ssc.hw3.command.CommandParser;
import org.junit.jupiter.api.Test;

class CommandParserTest  {
    @Test
    void testParser() {
        CommandParser commandParser = new CommandParser();
        commandParser.parse("exit");
    }
}