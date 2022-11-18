package com.techelevator.models.cards.facecards.builders;

import java.util.Arrays;
import java.util.List;

import com.techelevator.models.cards.facecards.*;
import com.techelevator.models.cards.facecards.cards.*;
import com.techelevator.models.cards.facecards.constants.Suits;

public final class SuitBuilder
{
    // private so no-one can create an instance
    private SuitBuilder(){}

    public static List<FaceCard> buildSpades()
    {
        FaceCard[] cards = new FaceCard[]{
            CardBuilder.ACE_SPADES(),
            CardBuilder.TWO_SPADES(),
            CardBuilder.THREE_SPADES(),
            CardBuilder.FOUR_SPADES(),
            CardBuilder.FIVE_SPADES(),
            CardBuilder.SIX_SPADES(),
            CardBuilder.SEVEN_SPADES(),
            CardBuilder.EIGHT_SPADES(),
            CardBuilder.NINE_SPADES(),
            CardBuilder.TEN_SPADES(),
            CardBuilder.JACK_SPADES(),
            CardBuilder.QUEEN_SPADES(),
            CardBuilder.KING_SPADES(),
        };

        return Arrays.asList(cards);
    }

    public static List<FaceCard> buildHearts()
    {
        FaceCard[] cards = new FaceCard[]{
            CardBuilder.ACE_HEARTS(),
            CardBuilder.TWO_HEARTS(),
            CardBuilder.THREE_HEARTS(),
            CardBuilder.FOUR_HEARTS(),
            CardBuilder.FIVE_HEARTS(),
            CardBuilder.SIX_HEARTS(),
            CardBuilder.SEVEN_HEARTS(),
            CardBuilder.EIGHT_HEARTS(),
            CardBuilder.NINE_HEARTS(),
            CardBuilder.TEN_HEARTS(),
            CardBuilder.JACK_HEARTS(),
            CardBuilder.QUEEN_HEARTS(),
            CardBuilder.KING_HEARTS(),
        };

        return Arrays.asList(cards);
    }

    public static List<FaceCard> buildClubs()
    {
        FaceCard[] cards = new FaceCard[]{
            CardBuilder.ACE_CLUBS(),
            CardBuilder.TWO_CLUBS(),
            CardBuilder.THREE_CLUBS(),
            CardBuilder.FOUR_CLUBS(),
            CardBuilder.FIVE_CLUBS(),
            CardBuilder.SIX_CLUBS(),
            CardBuilder.SEVEN_CLUBS(),
            CardBuilder.EIGHT_CLUBS(),
            CardBuilder.NINE_CLUBS(),
            CardBuilder.TEN_CLUBS(),
            CardBuilder.JACK_CLUBS(),
            CardBuilder.QUEEN_CLUBS(),
            CardBuilder.KING_CLUBS(),
        };

        return Arrays.asList(cards);
    }

    public static List<FaceCard> buildDiamonds()
    {
        FaceCard[] cards = new FaceCard[]{
            CardBuilder.ACE_DIAMONDS(),
            CardBuilder.TWO_DIAMONDS(),
            CardBuilder.THREE_DIAMONDS(),
            CardBuilder.FOUR_DIAMONDS(),
            CardBuilder.FIVE_DIAMONDS(),
            CardBuilder.SIX_DIAMONDS(),
            CardBuilder.SEVEN_DIAMONDS(),
            CardBuilder.EIGHT_DIAMONDS(),
            CardBuilder.NINE_DIAMONDS(),
            CardBuilder.TEN_DIAMONDS(),
            CardBuilder.JACK_DIAMONDS(),
            CardBuilder.QUEEN_DIAMONDS(),
            CardBuilder.KING_DIAMONDS(),
        };

        return Arrays.asList(cards);
    }

}
