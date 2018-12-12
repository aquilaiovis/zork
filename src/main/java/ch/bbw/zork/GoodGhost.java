package ch.bbw.zork;

public class GoodGhost extends Ghost {

    public GoodGhost(Game game) {
        super(game);
    }

    @Override
    public void interact() {
        System.out.println("Yo wanna hear a secret... The veil is in the ");
    }
}
