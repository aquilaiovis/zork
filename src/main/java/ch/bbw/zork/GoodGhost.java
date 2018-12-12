package ch.bbw.zork;

public class GoodGhost extends Ghost {

    public GoodGhost(Game game) {
        super(game);
    }

    @Override
    public void interact() {
        System.out.println("Yo wanna hear a secret... The cape is in the " + getCapeRoom() + ". Yo look out for the Bad " +
                "ghosts. Those snitches wanna kill you if you're not wearing it!");
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
