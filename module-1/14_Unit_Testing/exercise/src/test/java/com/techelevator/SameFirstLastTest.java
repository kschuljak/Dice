package com.techelevator;

import org.junit.Test;

import static org.junit.Assert.*;

public class SameFirstLastTest {

     /*
     Given an array of ints, return true if the array is length 1 or more, and the first element and
     the last element are equal.
     IsItTheSame([1, 2, 3]) → false
     IsItTheSame([1, 2, 3, 1]) → true
     IsItTheSame([1, 2, 1]) → true
     */

    @Test
    public void isItTheSame_Should_ReturnTrue_ifGiven_ArrayOfInts_FirstElementSameAsLastElement() {

        //arrange
        SameFirstLast sameFirstLast = new SameFirstLast();
        int[] intArray1 = new int[]{1, 2, 3, 4, 1};
        int[] intArray2 = new int[]{6, 3, 19, 6};
        int[] intArray3 = new int[]{0, 12, -4, 0};

        //act
        boolean actual1 = sameFirstLast.isItTheSame(intArray1);
        boolean actual2 = sameFirstLast.isItTheSame(intArray2);
        boolean actual3 = sameFirstLast.isItTheSame(intArray3);

        //assert
        assertTrue("Because first and last elements of int array are the same number (1 & 1)", actual1);
        assertTrue("Because first and last elements of int array are the same number (6 & 6)", actual2);
        assertTrue("Because first and last elements of int array are the same number (0 & 0", actual3);
    }

    @Test
    public void isItTheSame_Should_ReturnFalse_ifGiven_NullArray() {

        //arrange
        SameFirstLast sameFirstLast = new SameFirstLast();
        int[] intArray = null;

        //act
        boolean actual = sameFirstLast.isItTheSame(intArray);

        //assert
        assertFalse("Because null array argument should return false in methods error handling", actual);
    }

    @Test
    public void isItTheSame_Should_ReturnTrue_ifGiven_ArrayOfLengthOne() {

        //arrange
        SameFirstLast sameFirstLast = new SameFirstLast();
        int[] intArray = new int[]{7};

        //act
        boolean actual = sameFirstLast.isItTheSame(intArray);

        //assert
        assertTrue("Because in an array of length = 1, first element and last element are the same element (same index)", actual);
    }

    @Test
    public void isItTheSame_Should_ReturnFalse_ifGiven_EmptyArray() {

        //arrange
        SameFirstLast sameFirstLast = new SameFirstLast();
        int[] intArray = new int[]{};

        //act
        boolean actual = sameFirstLast.isItTheSame(intArray);

        //assert
        assertFalse("Because empty array argument should return false in methods error handling", actual);
    }
}
