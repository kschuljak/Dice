package com.techelevator.models.cards.facecards;

import com.techelevator.models.cards.Card;

public class FaceCard extends Card
{
    private final String suit;
    private final String faceValue;

    public FaceCard(String suit, int pointValue, String faceValue)
    {
        super(pointValue);

        this.suit = suit;
        this.faceValue = faceValue;
    }

    public String getSuit()
    {
        return suit;
    }

    public String getFaceValue()
    {
        return faceValue;
    }

}
