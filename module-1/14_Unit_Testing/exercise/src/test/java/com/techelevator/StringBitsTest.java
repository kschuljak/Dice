package com.techelevator;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StringBitsTest {

    /*
     * Given a string, return a new string made of every other char starting with
     * the first, so "Hello" yields "Hlo". GetBits("Hello") → "Hlo" GetBits("Hi")
     * → "H" GetBits("Heeololeo") → "Hello"
     */

    StringBits stringBits = new StringBits();

    @Before
    public void setUp() {
        stringBits = new StringBits();
    }

    @Test
    public void getBits_ShouldReturn_StringOfEveryOtherChar_StartingWithFirst_GivenString() {

        //arrange
        String string1 = "Hello There!";
        String expected1 = "HloTee";
        String string2 = "Boo";
        String expected2 = "Bo";
        String string3 = "AaBbCcDdEe";
        String expected3 = "ABCDE";

        //act
        String actual1 = stringBits.getBits(string1);
        String actual2 = stringBits.getBits(string2);
        String actual3 = stringBits.getBits(string3);

        //assert
        assertEquals("Because return string should contain every other character of argument string", expected1, actual1);
        assertEquals("Because return string should contain every other character of argument string", expected2, actual2);
        assertEquals("Because return string should contain every other character of argument string", expected3, actual3);
    }

    @Test
    public void getBits_ShouldReturn_EmptyString_GivenEmptyString() {

        //arrange
        String string = "";
        String expected = "";

        //act
        String actual = stringBits.getBits(string);

        //assert
        assertEquals("Because return string should be empty if given empty string as argument", expected, actual);
    }

    @Test
    public void getBits_ShouldReturn_EmptyString_GivenNull() {

        //arrange
        String string = null;
        String expected = "";

        //act
        String actual = stringBits.getBits(string);

        //assert
        assertEquals("Because return string should be empty if given null based on error handling in method", expected, actual);
    }


}
