package ch.bbw.zork;

public class BadGhost extends Ghost {

    public BadGhost(Game game) {
        super(game);
    }

    @Override
    public void interact() {
        if (super.getGame().getBackpack().getItem("cape") == null) {
            super.getGame().over();
        }
    }
}
