package ch.bbw.zork;

import java.util.ArrayList;

public class Backpack
{
    private ArrayList<Item> items;
    private int maxWeightInGrams;
    private int currentWeight;

    public Backpack(int maxWeightInGrams)
    {
        items = new ArrayList<>();
        this.maxWeightInGrams = maxWeightInGrams;
        currentWeight = 0;
    }

    public Item getItem(String secondCommand)
    {
        for(Item item: items)
        {
            if(item.getName().equals(secondCommand))
            {
                if(item.getWeightInGrams() <= maxWeightInGrams - currentWeight)
                {
                    currentWeight += item.getWeightInGrams();
                    System.out.println(item.getName() + " was successfully picked up.");
                    return item;
                }
                else
                {
                    System.out.println(item.getName() + " is " + (currentWeight + item.getWeightInGrams() - maxWeightInGrams)
                            + " grams too heavy for your backpack.");
                    return null;
                }
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
                currentWeight -= item.getWeightInGrams();
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
