package ch.bbw.zork;import java.util.ArrayList;import java.util.Random;import java.util.Stack;/** * Class Game - the main class of the "Zork" game. * <p> * Author:  Michael Kolling * Version: 1.1 * Date:    March 2000 * <p> * This class is the main class of the "Zork" application. Zork is a very * simple, text based adventure game.  Users can walk around some scenery. * That's all. It should really be extended to make it more interesting! * <p> * To play this game, create an instance of this class and call the "play" * routine. * <p> * This main class creates and initialises all the others: it creates all * rooms, creates the parser and starts the game.  It also evaluates the * commands that the parser returns. */public class Game{    private final int MAX_GHOST_SPAWN_SECONDS = 10;    private Parser parser;    private Room outside, lab, tavern, gblock, office, garden;    private Room currentRoom;    private Ghost ghost;    private Item hammer, key, cape;    private ArrayList<Room> map;    private Stack<Room> previousRooms;    private Backpack backpack;    private boolean finished;    private int roomCounter;    /**     * Create the game and initialise its internal map.     */    public Game()    {        backpack = new Backpack(300);        parser = new Parser(System.in);        // Create all the rooms and link their exits together.        outside = new Room("outside", "outside G block on Peninsula campus");        lab = new Room("lab", "lab, a lecture theatre in A block");        tavern = new Room("tavern", "the Seahorse Tavern (the campus pub)");        gblock = new Room("gblock", "the G Block");        office = new Room("office", "the computing admin office");        garden = new Room("garden", "The garden");        // initialise room exits        outside.setExits(garden, lab, gblock, tavern);        lab.setExits(null, null, null, outside);        tavern.setExits(null, outside, null, null);        gblock.setExits(outside, office, garden, null);        office.setExits(null, null, null, gblock);        garden.setExits(null, null, gblock, outside);        currentRoom = outside; // start game outside        previousRooms = new Stack<>();        map = new ArrayList<>();        map.add(outside);        map.add(lab);        map.add(tavern);        map.add(gblock);        map.add(office);        map.add(garden);        hammer = new Item("Hammer", "This is a tool usually associated with so-called 'work'.", 300);        key = new Item("Key", "This is a tool usually associated with opening things.", 50);        cape = new Item("Cape", "Incredibly trendy.", 200);        lab.addItem(hammer);        lab.addItem(key);        office.addItem(cape);        tavern.setRequiredToOpen(key);        finished = false;        roomCounter = 0;    }    /**     * Main play routine.  Loops until end of play.     */    public void play()    {        printWelcome();        // Enter the main command loop.  Here we repeatedly read commands and        // execute them until the game is over.        while (!finished)        {            Command command = parser.getCommand();            processCommand(command);        }        System.out.println("Thank you for playing!  Farewell.");        System.exit(0);    }    /**     * Print out the opening message for the player.     */    private void printWelcome()    {        System.out.println();        System.out.println("Welcome to Zork!");        System.out.println("Zork is a simple adventure game.");        System.out.println("Type 'help' if you need help.");        System.out.println();        System.out.println(currentRoom.longDescription());    }    /**     * Given a command, process (that is: execute) the command.     * If this command ends the game, true is returned, otherwise false is     * returned.     */    private void processCommand(Command command)    {        if (command.isUnknown())        {            System.out.println("I don't know what you mean...");        }        switch (command.getCommandWord())        {            case "help":                printHelp();                break;            case "go":                goRoom(command);                // Gewonnen?                if (currentRoom == tavern)                {                    System.out.println("You've successfully arrived in the tavern. Victory!");                    System.out.println("you walked through " + roomCounter + " rooms until you arrived in the tavern.");                    finished = true;                }                break;            case "map":                System.out.println("You are currently in " + currentRoom.shortDescription());                for (Room r : map)                {                    System.out.println(r.shortDescription());                }                break;            case "get":                if (command.hasSecondWord())                {                    Item item = currentRoom.getItem(command.getSecondWord());                    if (item == null)                    {                        System.out.println("Item '" + command.getSecondWord() + "' not found in the current room.");                    }                    else if (backpack.contains(item))                    {                        currentRoom.remove(item);                        backpack.add(item);                    }                    break;                }            case "put":                if (command.hasSecondWord())                {                    Item item = backpack.getItem(command.getSecondWord());                    if (backpack.contains(item))                    {                        backpack.removeItem(item);                        currentRoom.addItem(item);                    }                }                break;            case "backpack":                for (Item item : backpack.getItems())                {                    System.out.println(item.getName());                }                break;            case "back":                if (!previousRooms.isEmpty())                {                    currentRoom = previousRooms.pop();                    System.out.println(currentRoom.longDescription());                }                else                {                    System.out.println("You are in the room you started in.");                }                break;            case "quit":                if (command.hasSecondWord())                {                    System.out.println("Quit what?");                }                else                {                    finished = true;                }                break;            case "restart":                backpack.removeAllItems();                for(Item i : lab.getItems()){                    lab.remove(i);                }                lab.addItem(hammer);                lab.addItem(key);                currentRoom = outside;                roomCounter = 0;                printWelcome();                break;            default:                System.out.println("Please use a valid command. Valid commands are:" + parser.showCommands());                break;        }    }    /*     * implementations of user commands:     */    /**     * Print out some help information.     * Here we print some stupid, cryptic message and a list of the     * command words.     */    private void printHelp()    {        System.out.println("You are lost. You are alone. You wander");        System.out.println("around at Monash Uni, Peninsula Campus.");        System.out.println();        System.out.println("Your command words are:");        System.out.println(parser.showCommands());    }    /**     * Try to go to one direction. If there is an exit, enter the new     * room, otherwise print an error message.     */    private void goRoom(Command command)    {        // if there is no second word, we don't know where to go...        if (!command.hasSecondWord())        {            System.out.println("Go where?");        }        else        {            String direction = command.getSecondWord();            // Try to leave current room.            Room nextRoom = currentRoom.nextRoom(direction);            if (nextRoom != null)            {                if (nextRoom.getRequiredToOpen() == null)                {                    previousRooms.push(currentRoom);                    currentRoom = nextRoom;                    System.out.println(currentRoom.longDescription());                    roomCounter++;                }                else                {                    boolean hasRequiredItem = false;                    for (Item i : backpack.getItems())                    {                        if (i == nextRoom.getRequiredToOpen())                        {                            hasRequiredItem = true;                        }                    }                    if (hasRequiredItem)                    {                        previousRooms.push(currentRoom);                        currentRoom = nextRoom;                        System.out.println(currentRoom.longDescription());                        roomCounter++;                    }                    else                    {                        System.out.println("You need an item to access this room");                        return;                    }                }                boolean roomChanged = false;                Random random = new Random();                // Fifty-fifty chance that a ghost spawns in the current room                if(random.nextBoolean())                {                    Thread thread = new Thread(() ->                    {                        int secondCounter = random.nextInt(MAX_GHOST_SPAWN_SECONDS);                        while(!roomChanged && secondCounter > 0)                        {                            try                            {                                Thread.sleep(1000);                            }                            catch (InterruptedException e)                            {                                e.printStackTrace();                            }                            secondCounter--;                        }                        if(!roomChanged)                        {                            if (random.nextBoolean())                            {                                ghost = new GoodGhost(this);                                System.out.print("\nA friendly ghost appears.");                            }                            else                            {                                ghost = new BadGhost(this);                                System.out.println("\nAn evil ghost appears.");                            }                            ghost.interact();                            System.out.print("\n> ");                        }                    });                    thread.setName("GhostSpawning");                    thread.start();                }            }            else            {                System.out.println("Invalid direction.");            }        }    }    public void over() {        finished = true;    }    public Backpack getBackpack()    {        return backpack;    }    public ArrayList<Room> getMap()    {        return map;    }}