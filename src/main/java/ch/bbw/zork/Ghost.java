package ch.bbw.zork;

public abstract class Ghost {

    private Game game;

    public Ghost(Game game) {
        this.game = game;
    }

    public abstract void interact();


    public Game getGame() {
        return game;
    }
}