package com.techelevator.demos;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class MergeLanesTest
{

    @Test
    public void merge_Should_CreateList_WithAlternatingItems()
    {
        // arrange
        MergeLanes mergeLanes = new MergeLanes();
        List<Integer> left = Arrays.asList(1,2,3);
        List<Integer> right = Arrays.asList(4,5,6);
        List<Integer> expected = Arrays.asList(1,4,2,5,3,6);

        // act
        List<Integer> actual = mergeLanes.merge(left, right);

        // assert
        assertEquals("Because equal size lists should return an inteleaved list.",expected, actual);
    }

}
