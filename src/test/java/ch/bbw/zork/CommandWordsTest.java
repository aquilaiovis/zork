package ch.bbw.zork;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CommandWordsTest
{
    @Test
    public void testCommandWords()
    {
        CommandWords commands = new CommandWords();
        assertEquals(true, commands.isCommand("go"), "Check whether a given String is a valid command word. Return true if it is, false if it isn't.");
        commands.showAll();
    }
}
