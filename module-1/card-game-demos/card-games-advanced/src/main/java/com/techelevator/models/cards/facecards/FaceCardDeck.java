package com.techelevator.models.cards.facecards;

import com.techelevator.models.cards.Deck;
import com.techelevator.models.cards.facecards.builders.SuitBuilder;

import java.util.List;

public class FaceCardDeck extends Deck
{
    public FaceCardDeck()
    {
        super.cards.addAll(SuitBuilder.buildSpades());
        super.cards.addAll(SuitBuilder.buildHearts());
        super.cards.addAll(SuitBuilder.buildClubs());
        super.cards.addAll(SuitBuilder.buildDiamonds());
    }

    public FaceCardDeck(List<FaceCard> spades, List<FaceCard> hearts, List<FaceCard> clubs, List<FaceCard> diamonds)
    {
        super.cards.addAll(spades);
        super.cards.addAll(hearts);
        super.cards.addAll(clubs);
        super.cards.addAll(diamonds);
    }
}
