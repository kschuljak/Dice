package com.techelevator;

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

    @Test // NOT WORKING
    public void makeArray_Should_ReturnArrayPopulatedByNumberThatIsLarger_IndexZeroOrLastIndex() {

        //arrange
        MaxEnd3 maxEnd3 = new MaxEnd3();
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
        //assertEquals("Because returns array repopulated by whatever number is larger, number at first index (i=0) or number at last index (i=length-1)", expected1, actual1);
        assertEquals("Because returns array repopulated by whatever number is larger, number at first index (i=0) or number at last index (i=length-1)", expected2, actual2);
        //assertEquals("Because returns array repopulated by whatever number is larger, number at first index (i=0) or number at last index (i=length-1)", expected3, actual3);
    }
}
