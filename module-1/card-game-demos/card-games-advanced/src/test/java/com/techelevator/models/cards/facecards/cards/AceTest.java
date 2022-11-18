package com.techelevator.models.cards.facecards.cards;

import com.techelevator.models.cards.facecards.constants.Suits;
import org.junit.Test;

import static org.junit.Assert.*;

public class AceTest
{

    @Test
    public void getValue_should_defaultTo11()
    {
        // arrange
        Ace ace = new Ace(Suits.SPADES);
        int expected = 11;
        String message = "Because the default value of Ace should be 11.";

        // act
        int actual = ace.getValue();

        // assert
        assertEquals(message, expected, actual);

    }

    @Test
    public void toggle_should_changeValue_to1()
    {
        // arrange
        Ace ace = new Ace(Suits.SPADES);
        int expected = 1;
        String message = "Because toggling should change the value of an Ace from 11 to 1.";

        // act
        ace.toggleValue();
        int actual = ace.getValue();

        // assert
        assertEquals(message, expected, actual);

    }

    @Test
    public void toggle_should_changeValue_backTo11()
    {
        // arrange
        Ace ace = new Ace(Suits.SPADES);
        int expected = 11;
        String message = "Because toggling twice should change the value of an Ace back from 1 to 11.";

        // act
        ace.toggleValue();
        ace.toggleValue();
        int actual = ace.getValue();

        // assert
        assertEquals(message, expected, actual);

    }

    @Test
    public void getHighestValue_should_defaultTo11()
    {
        // arrange
        Ace ace = new Ace(Suits.SPADES);
        int expected = 11;
        String message = "Because the highest value of Ace should be 11.";

        // act
        int actual = ace.getHighestValue();

        // assert
        assertEquals(message, expected, actual);

    }

    @Test
    public void getLowestValue_should_defaultTo11()
    {
        // arrange
        Ace ace = new Ace(Suits.SPADES);
        int expected = 1;
        String message = "Because the lowest value of Ace should be 1.";

        // act
        int actual = ace.getLowestValue();

        // assert
        assertEquals(message, expected, actual);

    }

}