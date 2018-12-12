package ch.bbw.zork;

public class GoodGhost extends Ghost {

    public GoodGhost(Game game) {
        super(game);
    }

    @Override
    public void interact() {
        System.out.println("Yo wanna hear a secret... The veil is in the " + getVeil() + ". Yo look out for the Bad " +
                "ghosts. Those snitches wanna kill you!");
    }

    private String getVeil() {
        for (Room room:super.getGame().getMap()) {
            for (Item item:room.getItems()) {
                if (item.getName().equals("veil")) {
                    return room.getName();
                }
            }
        }
        return "backpack";
    }
}
