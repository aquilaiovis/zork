package ch.bbw.zork;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

        Item item = new Item();
        item.setName("Test item");
        room.addItem(item);
        assertEquals(item, room.getItem("Test item"), "The item should be the same.");
    }
}
