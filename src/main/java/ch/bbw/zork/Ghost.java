package ch.bbw.zork;

public class Ghost
{
    private boolean friendly;

    public Ghost(boolean friendly)
    {
        this.friendly = friendly;
    }

    public boolean isFriendly()
    {
        return friendly;
    }

    public void setFriendly(boolean friendly)
    {
        this.friendly = friendly;
    }
}