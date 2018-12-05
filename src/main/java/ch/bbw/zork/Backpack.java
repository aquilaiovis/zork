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

    public Item getItem(String secondCommandWord)
    {
        for (Item item : items)
        {
            if (item.getName().equals(secondCommandWord))
            {
                return item;
            }
        }
        return null;
    }

    public boolean contains(Item item)
    {
        if (items.contains(item))
        {
            System.out.println("This item was already picked up.");
            return false;
        }
        else
        {
            return true;
        }
    }

    public void add(Item item)
    {
        if (item.getWeightInGrams() <= maxWeightInGrams - currentWeight)
        {
            currentWeight += item.getWeightInGrams();
            System.out.println(item.getName() + " was successfully picked up.");
            items.add(item);
        }
        else
        {
            System.out.println(item.getName() + " is " + (currentWeight + item.getWeightInGrams() - maxWeightInGrams)
                    + " grams too heavy for your backpack.");
        }
    }

    public void removeItem(Item item)
    {
        if(item == null)
        {
            System.out.println("This item is not in your backpack.");
        }
        else
        {
            currentWeight -= item.getWeightInGrams();
            items.remove(item);
            System.out.println(item.getName() + " was successfully removed.");
        }
    }

    public ArrayList<Item> getItems()
    {
        return items;
    }
}
