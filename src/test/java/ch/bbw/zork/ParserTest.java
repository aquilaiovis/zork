package ch.bbw.zork;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;


public class ParserTest {

    private Parser parser;

    @Test
    public void testParserSameInput() {
        parser = new Parser(new ByteArrayInputStream("go west".getBytes()));
        assertEquals("The commands should be the same.", new Command(new CommandWords(), "go", "west"), parser.getCommand());
    }

    @Test
    public void testParserDifferentInput() {
        parser = new Parser(new ByteArrayInputStream("go home".getBytes()));
        assertEquals("The commands should not be the same.", new Command(new CommandWords(), "go", "west").equals(parser.getCommand()), false);
    }
}
