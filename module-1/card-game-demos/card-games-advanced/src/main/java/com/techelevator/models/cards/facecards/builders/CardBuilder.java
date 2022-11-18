package com.techelevator.models.cards.facecards.builders;

import com.techelevator.models.cards.facecards.FaceCard;
import com.techelevator.models.cards.facecards.cards.*;
import com.techelevator.models.cards.facecards.constants.Suits;

public class CardBuilder
{
    // private so no-one can create an instance
    private CardBuilder(){}

    public static FaceCard ACE_SPADES() { return new Ace(Suits.SPADES); }
    public static FaceCard TWO_SPADES() { return new Two(Suits.SPADES); }
    public static FaceCard THREE_SPADES() { return new Three(Suits.SPADES); }
    public static FaceCard FOUR_SPADES() { return new Four(Suits.SPADES); }
    public static FaceCard FIVE_SPADES() { return new Five(Suits.SPADES); }
    public static FaceCard SIX_SPADES() { return new Six(Suits.SPADES); }
    public static FaceCard SEVEN_SPADES() { return new Seven(Suits.SPADES); }
    public static FaceCard EIGHT_SPADES() { return new Eight(Suits.SPADES); }
    public static FaceCard NINE_SPADES() { return new Nine(Suits.SPADES); }
    public static FaceCard TEN_SPADES() { return new Ten(Suits.SPADES); }
    public static FaceCard JACK_SPADES() { return new Jack(Suits.SPADES); }
    public static FaceCard QUEEN_SPADES() { return new Queen(Suits.SPADES); }
    public static FaceCard KING_SPADES() { return new King(Suits.SPADES); }

    public static FaceCard ACE_HEARTS() { return new Ace(Suits.HEARTS); }
    public static FaceCard TWO_HEARTS() { return new Two(Suits.HEARTS); }
    public static FaceCard THREE_HEARTS() { return new Three(Suits.HEARTS); }
    public static FaceCard FOUR_HEARTS() { return new Four(Suits.HEARTS); }
    public static FaceCard FIVE_HEARTS() { return new Five(Suits.HEARTS); }
    public static FaceCard SIX_HEARTS() { return new Six(Suits.HEARTS); }
    public static FaceCard SEVEN_HEARTS() { return new Seven(Suits.HEARTS); }
    public static FaceCard EIGHT_HEARTS() { return new Eight(Suits.HEARTS); }
    public static FaceCard NINE_HEARTS() { return new Nine(Suits.HEARTS); }
    public static FaceCard TEN_HEARTS() { return new Ten(Suits.HEARTS); }
    public static FaceCard JACK_HEARTS() { return new Jack(Suits.HEARTS); }
    public static FaceCard QUEEN_HEARTS() { return new Queen(Suits.HEARTS); }
    public static FaceCard KING_HEARTS() { return new King(Suits.HEARTS); }

    public static FaceCard ACE_CLUBS() { return new Ace(Suits.CLUBS); }
    public static FaceCard TWO_CLUBS() { return new Two(Suits.CLUBS); }
    public static FaceCard THREE_CLUBS() { return new Three(Suits.CLUBS); }
    public static FaceCard FOUR_CLUBS() { return new Four(Suits.CLUBS); }
    public static FaceCard FIVE_CLUBS() { return new Five(Suits.CLUBS); }
    public static FaceCard SIX_CLUBS() { return new Six(Suits.CLUBS); }
    public static FaceCard SEVEN_CLUBS() { return new Seven(Suits.CLUBS); }
    public static FaceCard EIGHT_CLUBS() { return new Eight(Suits.CLUBS); }
    public static FaceCard NINE_CLUBS() { return new Nine(Suits.CLUBS); }
    public static FaceCard TEN_CLUBS() { return new Ten(Suits.CLUBS); }
    public static FaceCard JACK_CLUBS() { return new Jack(Suits.CLUBS); }
    public static FaceCard QUEEN_CLUBS() { return new Queen(Suits.CLUBS); }
    public static FaceCard KING_CLUBS() { return new King(Suits.CLUBS); }

    public static FaceCard ACE_DIAMONDS() { return new Ace(Suits.DIAMONDS); }
    public static FaceCard TWO_DIAMONDS() { return new Two(Suits.DIAMONDS); }
    public static FaceCard THREE_DIAMONDS() { return new Three(Suits.DIAMONDS); }
    public static FaceCard FOUR_DIAMONDS() { return new Four(Suits.DIAMONDS); }
    public static FaceCard FIVE_DIAMONDS() { return new Five(Suits.DIAMONDS); }
    public static FaceCard SIX_DIAMONDS() { return new Six(Suits.DIAMONDS); }
    public static FaceCard SEVEN_DIAMONDS() { return new Seven(Suits.DIAMONDS); }
    public static FaceCard EIGHT_DIAMONDS() { return new Eight(Suits.DIAMONDS); }
    public static FaceCard NINE_DIAMONDS() { return new Nine(Suits.DIAMONDS); }
    public static FaceCard TEN_DIAMONDS() { return new Ten(Suits.DIAMONDS); }
    public static FaceCard JACK_DIAMONDS() { return new Jack(Suits.DIAMONDS); }
    public static FaceCard QUEEN_DIAMONDS() { return new Queen(Suits.DIAMONDS); }
    public static FaceCard KING_DIAMONDS() { return new King(Suits.DIAMONDS); }
}
