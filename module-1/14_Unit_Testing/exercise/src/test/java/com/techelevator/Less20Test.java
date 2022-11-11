package com.techelevator;


import org.junit.Test;

import static org.junit.Assert.*;



public class Less20Test {

    // return true if n is positive & n is 1 or 2 less than a multiple of 20

    @Test
    public void isLessThanMultipleOf20_Should_ReturnTrue_ifGiven_multipleOf20minusTwo() {

        //arrange
        Less20 less20 = new Less20();
        int n1 = 38;
        int n2 = 78;
        int n3 = 3998;
        int n4 = 18;

        //act
        boolean actual1 = less20.isLessThanMultipleOf20(n1);
        boolean actual2 = less20.isLessThanMultipleOf20(n2);
        boolean actual3 = less20.isLessThanMultipleOf20(n3);
        boolean actual4 = less20.isLessThanMultipleOf20(n4);

        //assert
        assertTrue("because 38 (value of n) is positive, 20*2=40, and 40-2=38", actual1);
        assertTrue("because 78 (value of n) is positive, 20*4=80, and 80-2=78", actual2);
        assertTrue("because 3998 (value of n) is positive, 20*200=4000, and 4000-2=3998", actual3);
        assertTrue("because 18 (value of n) is positive, 20*1=20, and 20-2=18", actual4);
    }

    @Test
    public void isLessThanMultipleOf20_Should_ReturnTrue_ifGiven_multipleOf20minusOne() {

        //arrange
        Less20 less20 = new Less20();
        int n1 = 39;
        int n2 = 79;
        int n3 = 3999;
        int n4 = 19;

        //act
        boolean actual1 = less20.isLessThanMultipleOf20(n1);
        boolean actual2 = less20.isLessThanMultipleOf20(n2);
        boolean actual3 = less20.isLessThanMultipleOf20(n3);
        boolean actual4 = less20.isLessThanMultipleOf20(n4);

        //assert
        assertTrue("because 38 (value of n) is positive, 20*2=40, and 40-1=39", actual1);
        assertTrue("because 78 (value of n) is positive, 20*4=80, and 80-1=79", actual2);
        assertTrue("because 3998 (value of n) is positive, 20*200=4000, and 4000-1=3999", actual3);
        assertTrue("because 18 (value of n) is positive, 20*1=20, and 20-1=19", actual4);
    }

    @Test
    public void isLessThanMultipleOf20_Should_ReturnFalse_ifGiven_multipleOf20() {

        //arrange
        Less20 less20 = new Less20();
        int n1 = 40;
        int n2 = 80;
        int n3 = 4000;
        int n4 = 20;

        //act
        boolean actual1 = less20.isLessThanMultipleOf20(n1);
        boolean actual2 = less20.isLessThanMultipleOf20(n2);
        boolean actual3 = less20.isLessThanMultipleOf20(n3);
        boolean actual4 = less20.isLessThanMultipleOf20(n4);

        //assert
        assertFalse("because 40 (value of n) is positive, 20*2=40, and 40 is not 40less1 or 40less2", actual1);
        assertFalse("because 80 (value of n) is positive, 20*4=40, and 80 is not 80less1 or 80less2", actual2);
        assertFalse("because 4000 (value of n) is positive, 20*200=4000, and 4000 is not 4000less1 or 4000less2", actual3);
        assertFalse("because 20 (value of n) is positive, 20*1=20, and 20 is not 20less1 or 20less2", actual4);
    }

    @Test
    public void isLessThanMultipleOf20_Should_ReturnFalse_ifGiven_nIsZero() {

        //arrange
        Less20 less20 = new Less20();
        int n = 0;

        //act
        boolean actual = less20.isLessThanMultipleOf20(n);

        //assert
        assertFalse("because n is 0, and 0%20=0", actual);

    }

    @Test
    public void isLessThanMultipleOf20_Should_ReturnFalse_ifGiven_nIsNegative19() {

        //arrange
        Less20 less20 = new Less20();
        int n = -19;

        //act
        boolean actual = less20.isLessThanMultipleOf20(n);

        //assert
        assertFalse("because negative n, and in java % returns remainder, which can be negative (not modulus, which stays positive)", actual);

    }

}

