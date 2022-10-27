package com.techelevator;

public class Exercise04_Cards {

    /*
    The folks at Scamper Shipping like to play a bit
    of virtual poker at lunch, Five Card Draw, no Jokers. The deck
    is represented an array of strings, encoded as:

        * "1-C" through "10-C", "J-C", "Q-C", "K-C"
        * "1-D" through "10-D", "J-D", "Q-D", "K-D"
        * "1-H" through "10-H", "J-H", "Q-H", "K-H"
        * "1-S" through "10-S", "J-S", "Q-S", "K-S"
    
    A hand is made up of a 5 card array. For example:
        ["3-H", "4-D", "10-S", "9-D", "2-S"]
     */

    /*
    Given a 5 card array, return the value of the first card.

    Examples:
    getFirstCard(["3-H", "7-H", "5-H", "8-H", "6-H"]) → "3-H"
    getFirstCard(["1-C", "1-D", "1-H", "1-S", "2-C"]) → "1-C"
    getFirstCard(["K-C", "Q-D", "J-H", "10-S", "Q-C"]) → "K-C"
    */
    public String getFirstCard(String[] hand) {
        return "";
    }

    /*
    One of the players feels lucky and discards the first card from their hand.

    Given a 5 card array, remove the first card, and return a new 4 card
    array made up of the second through fifth cards of the original array.

    Note: The given 5 card array is always guaranteed to have 5 elements.

    Examples:
    discardFirstCard(["3-H", "7-H", "5-H", "8-H", "6-H"]) → ["7-H", "5-H", "8-H", "6-H"]
    discardFirstCard(["1-C", "1-D", "1-H", "1-S", "2-C"]) → ["1-D", "1-H", "1-S", "2-C"]
    discardFirstCard(["K-C", "Q-D", "J-H", "10-S", "Q-C"]) → ["Q-D", "J-H", "10-S", "Q-C"]
     */
    public String[] discardFirstCard(String[] hand) {
        return new String[] {};
    }

    /*
    Once a player has drawn the top card from the deck, they must discard it.

    Given a deck of cards, return a new deck containing all the cards except
    the first from the original deck.

    Note: The new array returned is one element shorter than the original,
    except when the deck has no cards. Then the array returned must be empty.

    Examples:
    discardTopCard(["8-D", "10-H", "J-C", "8-D", "6-S", "Q-C", "2-D"]) → ["10-H", "J-C", "8-D", "6-S", "Q-C", "2-D"]
    discardTopCard(["4-D", "6-S", "K-D"]) → ["6-S", "K-D"]
    discardTopCard(["9-H"]) → []
    discardTopCard([]) → []
     */
    public String[] discardTopCard(String[] remainingDeck) {
        return new String[] {};
    }    
}
