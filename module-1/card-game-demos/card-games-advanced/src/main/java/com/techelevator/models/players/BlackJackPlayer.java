package com.techelevator.models.players;

public class BlackJackPlayer extends Player
{
    private boolean stayed = false;

    public BlackJackPlayer(String name)
    {
        super(name);
    }

    public boolean hasStayed()
    {
        return stayed;
    }

    public void stay()
    {
        stayed = true;
    }
}
