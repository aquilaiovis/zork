package ch.bbw.zork;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CommandWordsTest
{
    @Test
    public void testCommandWords()
    {
        CommandWords commands = new CommandWords();
        assertEquals("Check whether a given String is a valid command word. Return true if it is, false if it isn't.", true, commands.isCommand("go"));
        commands.showAll();
    }
}
