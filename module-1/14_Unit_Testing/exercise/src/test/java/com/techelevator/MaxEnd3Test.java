package com.techelevator;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
public class MaxEnd3Test {

        /*
     Given an array of ints length 3, figure out which is larger between the first and last elements
     in the array, and set all the other elements to be that value. Return the changed array.
     MakeArray([1, 2, 3]) → [3, 3, 3]
     MakeArray([11, 5, 9]) → [11, 11, 11]
     MakeArray([2, 11, 3]) → [3, 3, 3]
     */

    MaxEnd3 maxEnd3 = new MaxEnd3();

    @Before
    public void setUp() {
        maxEnd3 = new MaxEnd3();
    }

    @Test
    public void makeArray_Should_ReturnArrayPopulatedByNumberThatIsLarger_IndexZeroOrIndexTwo() {

        //arrange
        int[] array1 = new int[]{1, 5, 3};
        int[] array2 = new int[]{9, 5, 1};
        int[] array3 = new int[]{1, 19, 2};

        int[] expected1 = new int[]{3, 3, 3};
        int[] expected2 = new int[]{9, 9, 9};
        int[] expected3 = new int[]{2, 2, 2};

        //act
        int[] actual1 = maxEnd3.makeArray(array1);
        int[] actual2 = maxEnd3.makeArray(array2);
        int[] actual3 = maxEnd3.makeArray(array3);

        //assert
        assertArrayEquals("Because returns array repopulated by whatever number is larger, number at index 0 or number at index 2", expected1, actual1);
        assertArrayEquals("Because returns array repopulated by whatever number is larger, number at index 0 or number at index 2", expected2, actual2);
        assertArrayEquals("Because returns array repopulated by whatever number is larger, number at index 0 or number at index 2", expected3, actual3);
    }

    @Test
    public void makeArray_Should_ReturnArrayOfNumberThatIsLarger_BetweenFirstIndexVsLastIndex(){

        //arrange
        int[] array1 = new int[]{1, 5, 7, 18, 121};
        int[] array2 = new int[]{9, 1};
        int[] array3 = new int[]{1, 0, 17, 222, 19, 42, 4};

        int[] expected1 = new int[]{121, 121, 121, 121, 121};
        int[] expected2 = new int[]{9, 9};
        int[] expected3 = new int[]{4, 4, 4, 4, 4, 4, 4};

        //act
        int[] actual1 = maxEnd3.makeArray(array1);
        int[] actual2 = maxEnd3.makeArray(array2);
        int[] actual3 = maxEnd3.makeArray(array3);

        //assert
        assertArrayEquals("Because returns array repopulated by whatever number is larger, number at first index (i=0) or number at last index (i=length-1)", expected1, actual1);
        assertArrayEquals("Because returns array repopulated by whatever number is larger, number at first index (i=0) or number at last index (i=length-1)", expected2, actual2);
        assertArrayEquals("Because returns array repopulated by whatever number is larger, number at first index (i=0) or number at last index (i=length-1)", expected3, actual3);
    }

    @Test
    public void makeArray_Should_ReturnArrayOfOne_GivenArrayOfOne(){

        //arrange
        int[] array = new int[]{4};
        int[] expected = new int[]{4};

        //act
        int[] actual = maxEnd3.makeArray(array);

        //assert
        assertArrayEquals("First and last element are the same, so should return array of same one element", expected, actual);
    }

    // not sure how to write tests for these:
    // empty array = out of bounds error
    // null array = null pointer exception
}
