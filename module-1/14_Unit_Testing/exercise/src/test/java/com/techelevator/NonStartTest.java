package com.techelevator;

import org.junit.Test;

import static org.junit.Assert.*;

public class NonStartTest {

    // return string one (less first character) + string two (less first character

    @Test
    public void getPartialString_Should_ReturnTwoStrings_LessFirstCharacter_Concatenated_GivenTwoStrings() {

        //arrange
        NonStart nonStart = new NonStart();
        String a1 = "Hello";
        String b1 = "There";
        String expected1 = "ellohere";
        String a2 = "javabean";
        String b2 = "coffee";
        String expected2 = "avabeanoffee";
        String a3 = "AbCdE";
        String b3 = "FgHiJkL";
        String expected3 = "bCdEgHiJkL";

        //act
        String actual1 = nonStart.getPartialString(a1, b1);
        String actual2 = nonStart.getPartialString(a2, b2);
        String actual3 = nonStart.getPartialString(a3, b3);

        //assert
        assertEquals("Because should return concatenated substrings starting at index 1", expected1, actual1);
        assertEquals("Because should return concatenated substrings starting at index 1", expected2, actual2);
        assertEquals("Because should return concatenated substrings starting at index 1", expected3, actual3);
    }

    @Test
    public void getPartialString_Should_ReturnEmptyString_GivenTwoNullStrings() {

        //arrange
        NonStart nonStart = new NonStart();
        String a = null;
        String b = null;
        String expected = "";

        //act
        String actual = nonStart.getPartialString(a, b);

        //assert
        assertEquals("Because null error handling sets value to empty string", expected, actual);
    }

    @Test
    public void getPartialString_Should_ReturnEmptyString_GivenTwoEmptyStrings() {

        //arrange
        NonStart nonStart = new NonStart();
        String a = "";
        String b = "";
        String expected = "";

        //act
        String actual = nonStart.getPartialString(a, b);

        //assert
        assertEquals("Because two empty strings return an empty string", expected, actual);
    }

    @Test
    public void getPartialString_Should_ReturnSubstring_OfStringMinusFirstIndex_GivenOneString_AndOneEmptyString() {

        //arrange
        NonStart nonStart = new NonStart();
        String a = "";
        String b = "Hello World!";
        String expected = "ello World!";

        //act
        String actual = nonStart.getPartialString(a, b);

        //assert
        assertEquals("Because an empty string and a populated string returns a substring of populated string less index 0", expected, actual);
    }

}
