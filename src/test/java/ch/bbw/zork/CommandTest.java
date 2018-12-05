package ch.bbw.zork;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CommandTest
{
    @Test
    public void testCommand()
    {
        Command command = new Command(new CommandWords(), "notavalidcommandword", "");
        assertEquals(null, command.getCommandWord(), "The command word should be null to indicate that this was a command that is not recognised by this game.");
        assertEquals(null, command.getSecondWord(), "Return the second word of this command. Returns null if there was no second word.");
        assertEquals("Return true if this command was not understood.", true, command.isUnknown());
        assertEquals("Return true if the command has a second word.", false, command.hasSecondWord());
    }
}