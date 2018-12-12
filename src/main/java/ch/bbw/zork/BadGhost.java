package ch.bbw.zork;

public class BadGhost extends Ghost {

    private Game game;

    public BadGhost(Game game) {
        this.game = game;
    }

    @Override
    public void interact() {
        game.over();
    }
}
