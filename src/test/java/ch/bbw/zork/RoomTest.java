package ch.bbw.zork;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RoomTest
{
    @Test
    public void testCommandWords()
    {
        Room room = new Room("This is a test room.");
        room.setExits(room, null, room, null);
        room.shortDescription();
        room.longDescription();
        room.nextRoom("north");

        Item item = new Item("Penispumpe", "Generic item", 2000);
        item.setName("Test item");
        room.addItem(item);
        assertEquals("The item should be the same.", item, room.getItem("Test item"));
    }
}
