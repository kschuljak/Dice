package com.techelevator.models.cards.facecards;

import com.techelevator.models.cards.Deck;

import java.util.List;

public class FaceCardDeck extends Deck
{

    public FaceCardDeck(List<FaceCard> spades, List<FaceCard> hearts, List<FaceCard> clubs, List<FaceCard> diamonds)
    {
        super.cards.addAll(spades);
        super.cards.addAll(hearts);
        super.cards.addAll(clubs);
        super.cards.addAll(diamonds);
    }

    public FaceCardDeck(List<FaceCard> cards)
    {
        super.cards.addAll(cards);
    }
}
