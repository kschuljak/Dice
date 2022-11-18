package com.techelevator.models.cards;

import com.techelevator.models.cards.facecards.builders.CardBuilder;
import com.techelevator.models.cards.facecards.builders.SuitBuilder;
import com.techelevator.models.hands.Hand;
import org.junit.Test;

import static org.junit.Assert.*;

public class HandTest
{
    @Test
    public void getValue_should_addDefaultCardValues()
    {
        // arrange
        Hand hand = new Hand();
        hand.deal(CardBuilder.FIVE_CLUBS());
        hand.deal(CardBuilder.EIGHT_DIAMONDS());
        int expected = 13;
        String message = "Because the hand has cards with values of 5 and 8";

        // act
        int actual = hand.getValue();

        // assert
        assertEquals(message, expected, actual);
    }

    @Test
    public void hasMultipleValues_should_returnFalseForStandardCards()
    {
        // arrange
        Hand hand = new Hand();
        hand.deal(CardBuilder.FIVE_CLUBS());
        hand.deal(CardBuilder.EIGHT_DIAMONDS());
        String message = "Because 5 and 8 don't have multiple values.";

        // act
        boolean actual = hand.hasMultipleValues();

        // assert
        assertFalse(message, actual);
    }

    @Test
    public void hasMultipleValues_should_returnTrueForHandWithAce()
    {
        // arrange
        Hand hand = new Hand();
        hand.deal(CardBuilder.FIVE_CLUBS());
        hand.deal(CardBuilder.EIGHT_DIAMONDS());
        hand.deal(CardBuilder.ACE_SPADES());
        String message = "Because the hand has a 5, 8, A.";

        // act
        boolean actual = hand.hasMultipleValues();

        // assert
        assertTrue(message, actual);
    }

    @Test
    public void getHighestValue_should_use11ForAceCalculation()
    {
        // arrange
        Hand hand = new Hand();
        hand.deal(CardBuilder.FIVE_CLUBS());
        hand.deal(CardBuilder.EIGHT_DIAMONDS());
        hand.deal(CardBuilder.ACE_SPADES());
        String message = "Because the hand has a 5,8,A.";
        int expected = 24;

        // act
        int actual = hand.getHighestValue();

        // assert
        assertEquals(message, expected, actual);
    }

    @Test
    public void getLowestValue_should_use1ForAceCalculation()
    {
        // arrange
        Hand hand = new Hand();
        hand.deal(CardBuilder.FIVE_CLUBS());
        hand.deal(CardBuilder.EIGHT_DIAMONDS());
        hand.deal(CardBuilder.ACE_SPADES());
        String message = "Because the hand has a 5,8,A.";
        int expected = 14;

        // act
        int actual = hand.getLowestValue();

        // assert
        assertEquals(message, expected, actual);
    }

    @Test
    public void getPossibleValues_should_useReturnArrayWithDefaultValue_WhenThereIsNoAce()
    {
        // arrange
        Hand hand = new Hand();
        hand.deal(CardBuilder.FIVE_CLUBS());
        hand.deal(CardBuilder.EIGHT_DIAMONDS());
        String message = "Because the hand has a 5,8.";
        int[] expected = {13};

        // act
        int[] actual = hand.getPossibleValues();

        // assert
        assertArrayEquals(message, expected, actual);
    }

    @Test
    public void getPossibleValues_should_useReturnArrayWithHighestAndLowestValues_WhenThereIsAnAce()
    {
        // arrange
        Hand hand = new Hand();
        hand.deal(CardBuilder.FIVE_CLUBS());
        hand.deal(CardBuilder.EIGHT_DIAMONDS());
        hand.deal(CardBuilder.ACE_SPADES());
        String message = "Because the hand has a 5,8,A.";
        int[] expected = {24,14};

        // act
        int[] actual = hand.getPossibleValues();

        // assert
        assertArrayEquals(message, expected, actual);
    }

    @Test
    public void getValue_should_returnCorrectValue_WhenAceIsToggled()
    {
        // arrange
        Hand hand = new Hand();
        hand.deal(CardBuilder.FIVE_CLUBS());
        hand.deal(CardBuilder.EIGHT_DIAMONDS());
        hand.deal(CardBuilder.ACE_SPADES());

        int expected = 14;
        String message = "Because the Ace in hand 5,8,A should be toggled to 1.";

        // act
        hand.toggleCardValue(3);
        int actual = hand.getValue();

        // assert
        assertEquals(message, expected, actual);
    }

    @Test
    public void getValue_should_returnCorrectValueWithMultipleAces_WhenNotAllAreToggled()
    {
        // arrange
        Hand hand = new Hand();
        hand.deal(CardBuilder.EIGHT_DIAMONDS());
        hand.deal(CardBuilder.ACE_SPADES());
        hand.deal(CardBuilder.ACE_DIAMONDS());
        hand.deal(CardBuilder.ACE_HEARTS());

        int expected = 20;
        String message = "\nBecause only the 2nd and 3rd ace " +
                "\nin hand 8, A, A, A should be toggled to 1." +
                "\n8 + 11 + 1 + 1 = 21";

        // act
        hand.toggleCardValue(3);
        hand.toggleCardValue(4);
        int actual = hand.getValue();

        // assert
        assertEquals(message, expected, actual);
    }

}