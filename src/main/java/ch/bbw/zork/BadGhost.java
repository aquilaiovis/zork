package ch.bbw.zork;

public class BadGhost extends Ghost {

    public BadGhost(Game game) {
        super(game);
    }

    @Override
    public void interact() {
        if (super.getGame().getBackpack().getItem("cape") == null) {
            System.out.println("The ghost says: \"You have disturbed my eternal sleep. Now, I shall take your body and take over the wooorld!\"");
            super.getGame().over();
        }
    }
}
