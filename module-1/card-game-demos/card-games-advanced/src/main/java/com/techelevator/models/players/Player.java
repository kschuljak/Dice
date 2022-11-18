package com.techelevator.models.players;

import com.techelevator.models.cards.Card;
import com.techelevator.models.hands.BlackJackHand;
import com.techelevator.models.hands.Hand;

public class Player
{
    private String name;
    private BlackJackHand hand;

    public Player(String name)
    {
        this.name = name;
        this.hand = new BlackJackHand();
    }

    public void deal(Card card)
    {
        hand.deal(card);
    }

    public String getName()
    {
        return name;
    }

    public Hand showHand()
    {
        hand.show();
        return hand;
    }

    public int getHandValue()
    {
        return hand.getValue();
    }
}
