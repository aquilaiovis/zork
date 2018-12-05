package ch.bbw.zork;

import org.junit.Test;

public class BackpackTest
{
    @Test
    public void testBackpack()
    {
        Backpack backpack = new Backpack(300);
        Item hammer = new Item("Hammer", "This is a tool usually associated with so-called 'work'.", 300);
        Item key = new Item("Key", "This is a tool usually associated with opening things.", 50);
        backpack.add(hammer);

        // Should not work
        backpack.add(key);

        backpack.removeItem(hammer);
        backpack.add(key);
    }
}