package com.techelevator;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class Lucky13Test {

    // return false if number array contains the numbers 1 or 3

    Lucky13 lucky13 = new Lucky13();

    @Before
    public void setUp() {
        lucky13 = new Lucky13();
    }

    @Test
    public void getLucky_Should_ReturnTrue_ifGiven_ArrayWithout1or3() {

        //arrange
        int[] array1 = new int[]{0, 2, 100, -4, 5};
        int[] array2 = new int[]{2, 22, 222, 2222222, 222222222};
        int[] array3 = new int[]{7, 7, 7, 7, 7};

        //act
        boolean actual1 = lucky13.getLucky(array1);
        boolean actual2 = lucky13.getLucky(array2);
        boolean actual3 = lucky13.getLucky(array3);

        //assert
        assertTrue("Because integer array does not include the numbers 1 or 3", actual1);
        assertTrue("Because integer array does not include the numbers 1 or 3", actual2);
        assertTrue("Because integer array does not include the numbers 1 or 3", actual3);
    }

    @Test
    public void getLucky_Should_ReturnTrue_ifGiven_ArrayWith_NegativeOneAndNegativeThree() {

        //arrange
        int[] array = new int[]{-1, -3};

        //act
        boolean actual = lucky13.getLucky(array);

        //assert
        assertTrue("Because negative 1 is not positive 1, and -3 is not 3", actual);
    }

    @Test
    public void getLucky_Should_ReturnTrue_ifGiven_EmptyArray() {

        //arrange
        int[] array = new int[]{};

        //act
        boolean actual = lucky13.getLucky(array);

        //assert
        assertTrue("Because the array is empty, and thus does not contain 1 or 3", actual);
    }

    @Test
    public void getLucky_Should_ReturnError_ifGiven_Null() {

        //arrange
        int[] array = null;

        //act
        boolean actual = lucky13.getLucky(array);

        //assert
        assertTrue("Because array is null, returns true", actual);
    }
}
