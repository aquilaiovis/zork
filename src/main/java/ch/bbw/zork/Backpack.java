package ch.bbw.zork;

import java.util.ArrayList;

public class Backpack
{
    private ArrayList<Item> items;

    public Backpack()
    {
        items = new ArrayList<>();
    }

    public Item getItem(String secondCommand)
    {
        for(Item item: items)
        {
            if(item.getName().equals(secondCommand))
            {
                return item;
            }
        }
        return null;
    }
}
