package ch.bbw.zork;

public class GoodGhost extends Ghost {

    public GoodGhost(Game game) {
        super(game);
    }

    @Override
    public void interact() {
        System.out.println("The ghost speaks: \"Yo wanna hear a secret... The invisibility cloak is in the " + getCapeRoom()
                + ". Yo look out for the bad ghosts. Those snitches wanna kill you if you're not wearing it!\"");
    }

    private String getCapeRoom() {
        for (Room room:super.getGame().getMap()) {
            for (Item item:room.getItems()) {
                if (item.getName().equals("Cape")) {
                    return room.getName();
                }
            }
        }
        return "backpack";
    }
}
