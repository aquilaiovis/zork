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
                System.out.println(item.getName() + " was successfully picked up.");
                return item;
            }
        }
        System.out.println("This item is not in the current room.");
        return null;
    }

    public void addItem(Item item)
    {
        items.add(item);
    }

    public void removeItem(String secondCommand)
    {
        for(Item item: items)
        {
            if(item.getName().equals(secondCommand))
            {
                items.remove(item);
                System.out.println(item.getName() + " was successfully removed.");
            }
        }
        System.out.println("This item is not in your backpack.");
    }

    public ArrayList<Item> getItems()
    {
        return items;
    }
}
