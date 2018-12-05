package ch.bbw.zork;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;


public class ParserTest {

    private Parser parser;

    @Test
    public void testParser() {
        parser = new Parser(new ByteArrayInputStream("go west".getBytes()));
        assertEquals("The commands should be the same.", new Command(new CommandWords(), "go", "west"), parser.getCommand());
    }
}
