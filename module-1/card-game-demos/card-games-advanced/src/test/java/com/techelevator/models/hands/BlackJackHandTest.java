package com.techelevator.models.hands;

import com.techelevator.models.cards.facecards.builders.CardBuilder;
import com.techelevator.models.cards.facecards.builders.SuitBuilder;
import org.junit.Test;

import static org.junit.Assert.*;

public class BlackJackHandTest
{
    @Test
    public void isBust_should_returnTrue_forHandValueOver21()
    {
        // arrange
        BlackJackHand hand = new BlackJackHand();
        hand.deal(CardBuilder.KING_CLUBS());
        hand.deal(CardBuilder.FIVE_DIAMONDS());
        hand.deal(CardBuilder.QUEEN_DIAMONDS());

        String message = "\nBecause a K, 5, Q add up to 25" +
                "\nAnd that is a BUST";

        // act
        boolean actual = hand.isBust();

        // assert
        assertTrue(message, actual);
    }

    @Test
    public void isBust_should_returnTrueBeforeToggle_forHandWithAce()
    {
        // arrange
        BlackJackHand hand = new BlackJackHand();
        hand.deal(CardBuilder.KING_CLUBS());
        hand.deal(CardBuilder.FIVE_DIAMONDS());
        hand.deal(CardBuilder.ACE_HEARTS());

        String message = "\nBecause a K, 5, A add up to 26 BEFORE toggle" +
                "\nAnd that is a BUST";

        // act
        boolean actual = hand.isBust();

        // assert
        assertTrue(message, actual);
    }

    @Test
    public void isBust_should_returnFalseAfterToggle_forHandValue21OrLess()
    {
        // arrange
        BlackJackHand hand = new BlackJackHand();
        hand.deal(CardBuilder.KING_CLUBS());
        hand.deal(CardBuilder.FIVE_DIAMONDS());
        hand.deal(CardBuilder.ACE_HEARTS());

        String message = "\nBecause a K, 5, A add up to 16 after toggle" +
                "\nAnd that is NOT a BUST";

        // act
        hand.toggleCardValue(3);
        boolean actual = hand.isBust();

        // assert
        assertFalse(message, actual);
    }

}