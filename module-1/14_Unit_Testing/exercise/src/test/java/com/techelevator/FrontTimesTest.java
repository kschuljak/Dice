package com.techelevator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FrontTimesTest {

    /*
    front string = all characters up to & including 3rd character
    return n number of copies of the front string, concatenated

     */

    FrontTimes frontTimes = new FrontTimes();

    @Before
    public void setup(){
        frontTimes = new FrontTimes();
    }

    @Test
    public void generateString_Should_Return_substringOfFirstThreeCharacters_concatenated3times_ifGiven_stringAnd3() {

        //arrange
        String str = "abcde";
        String str2 = "ABCDE";
        String str3 = "!*HELLO43";
        int n = 3;
        String expected = "abcabcabc";
        String expected2 = "ABCABCABC";
        String expected3 = "!*H!*H!*H";

        //act
        String actual = frontTimes.generateString(str, n);
        String actual2 = frontTimes.generateString(str2, n);
        String actual3 = frontTimes.generateString(str3, n);

        //assert
        assertEquals("because argument string is longer than 3 characters and n=3", expected, actual);
        assertEquals("because argument string > 3 chars, n=3, and method has no letter case conversion", expected2, actual2);
        assertEquals("because argument string > 3 chars, n=3, and method does not limit character range", expected3, actual3);
    }

    @Test
    public void generateString_Should_Return_EmptyString_ifGiven_null() {

        //arrange
        String str = null;
        int n = 1;
        String expected = "";

        //act
        String actual = frontTimes.generateString(str, n);

        //assert
        assertEquals("because result set to empty string in method and if str=null returns result", expected, actual);
    }

    @Test
    public void generateString_Should_Return_EmptyString_ifGiven_abcdeAnd0() {

        //arrange
        String str = "abcde";
        int n = 0;
        String expected = "";

        //act
        String actual = frontTimes.generateString(str, n);

        //assert
        assertEquals("because front string is added to an empty result string n number of times and n=0", expected, actual);
    }

    @Test
    public void generateString_Should_Return_EmptyString_ifGiven_EmptyStringAnd3() {

        //arrange
        String str = "";
        int n = 3;
        String expected = "";

        //act
        String actual = frontTimes.generateString(str, n);

        //assert
        assertEquals("because front string is added to an empty result string n number of times and front string is empty", expected, actual);
    }

    @Test
    public void generateString_Should_Return_aaa_ifGiven_aAnd3() {

        //arrange
        String str = "a";
        int n = 3;
        String expected = "aaa";

        //act
        String actual = frontTimes.generateString(str, n);

        //assert
        assertEquals("because front string is a substring of all characters up to the third character, or the end of the string, whichever comes first", expected, actual);
    }
}
