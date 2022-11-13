package com.techelevator;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class WordCountTest {

    /*
     * Given an array of strings, return a Map<String, Integer> with a key for
     * each different string, with the value the number of times that string appears
     * in the array.
     *
     * ** A CLASSIC **
     *
     * getCount(["ba", "ba", "black", "sheep"]) → {"ba" : 2, "black": 1, "sheep": 1 }
     * getCount(["a", "b", "a", "c", "b"]) → {"a": 2, "b": 2, "c": 1}
     * getCount([]) → {}
     * getCount(["c", "b", "a"]) → {"c": 1, "b": 1, "a": 1}
     *
     */

    WordCount wordCount = new WordCount();

    @Before
    public void setUp(){
        wordCount = new WordCount();
    }

    @Test
    public void getCount_ShouldReturn_Map_KeyString_ValueNumberOfTimesKeyAppearsInStringArray_GivenStringArray() {

        //arrange
        String[] array1 = new String[]{"Hello", "Hello", "How", "Are", "You", "Hello", "You"};
        String[] array2 = new String[]{"a", "b", "z"};
        String[] array3 = new String[]{"same", "same", "same", "same", "same", "same"};

        Map<String, Integer> expected1 = new HashMap<>();
        expected1.put("Hello", 3);
        expected1.put("How", 1);
        expected1.put("Are", 1);
        expected1.put("You", 2);

        Map<String, Integer> expected2 = new HashMap<>();
        expected2.put("a", 1);
        expected2.put("b", 1);
        expected2.put("z", 1);

        Map<String, Integer> expected3 = new HashMap<>();
        expected3.put("same", 6);

        //act
        Map<String, Integer> actual1 = wordCount.getCount(array1);
        Map<String, Integer> actual2 = wordCount.getCount(array2);
        Map<String, Integer> actual3 = wordCount.getCount(array3);

        //assert
        assertEquals("Because map key should be element of array and map value should be number of times that element appeared in the array", expected1, actual1);
        assertEquals("Because map key should be element of array and map value should be number of times that element appeared in the array", expected2, actual2);
        assertEquals("Because map key should be element of array and map value should be number of times that element appeared in the array", expected3, actual3);
    }

    @Test
    public void getCount_ShouldReturn_EmptyMap_GivenEmptyStringArray() {

        //arrange
        String[] array = new String[]{};
        Map<String, Integer> expected = new HashMap<>();

        //act
        Map<String, Integer> actual = wordCount.getCount(array);

        //assert
        assertEquals("Because empty array has no values to populate map with", expected, actual);
    }

    @Test
    public void getCount_ShouldReturn_EmptyMap_GivenNull() {

        //arrange
        String[] array = null;
        Map<String, Integer> expected = new HashMap<>();

        //act
        Map<String, Integer> actual = wordCount.getCount(array);

        //assert
        assertEquals("Because method error handling returns empty map if given null", expected, actual);
    }
}
