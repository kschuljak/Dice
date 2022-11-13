package com.techelevator;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DateFashionTest {

    /* you = stylishness range 0 - 10
       date = stylishness range 0 - 10
       returns:
       0 = no (if either <= 2)
       1 = maybe
       2 = yes (if either >= 8)
     */

    DateFashion dateFashion = new DateFashion();

    @Before
    public void setUp() {
        dateFashion = new DateFashion();
    }

    @Test
    public void getATable_Should_Return1_ifGivenStyleValuesBetween3And7() {

        //arrange
        int you1 = 5;
        int date1 = 5;
        int you2 = 3;
        int date2 = 7;
        int expected = 1;

        //act
        int actual1 = dateFashion.getATable(you1, date1);
        int actual2 = dateFashion.getATable(you2, date2);

        //assert
        assertEquals("Because both style values (5 & 5) are greater than 2 (upper limit for not stylish, inclusive) and less than 8 (lower limit for very stylish, inclusive)", expected, actual1);
        assertEquals("Because both style values (3 & 7) are greater than 2 (upper limit for not stylish, inclusive) and less than 8 (lower limit for very stylish, inclusive)", expected, actual2);
    }

    @Test
    public void getATable_Should_Return0_ifGivenStyleValues2And5_or5And2() {

        //arrange
        int you = 2;
        int you2 = 5;
        int date = 5;
        int date2 = 2;
        int expected = 0;

        //act
        int actual = dateFashion.getATable(you, date);
        int actual2 = dateFashion.getATable(you2, date2);

        //assert
        assertEquals("Because 'you' style rating is 2 (upper limit for not stylish, inclusive)", expected, actual);
        assertEquals("Because 'date' style rating is 2 (upper limit for not stylish, inclusive)", expected, actual2);
    }

    @Test
    public void getATable_Should_Return0_ifGivenStyleValues100And1() {

        //arrange
        int you = 100;
        int date = 1;
        int expected = 0;

        //act
        int actual = dateFashion.getATable(you, date);

        //assert
        assertEquals("Because 'date' style rating is 1, and not stylish is checked before very stylish", expected, actual);

    }

    @Test
    public void getATable_Should_Return0_ifGivenStyleValues0And10() {

        //arrange
        int you = 0;
        int date = 10;
        int expected = 0;

        //act
        int actual = dateFashion.getATable(you, date);

        //assert
        assertEquals("Because condition for style value <= 2 (not stylish) is checked before style value >= 8 (very stylish)", expected, actual);

    }

    @Test
    public void getATable_Should_Return0_ifGivenStyleValuesNegative10And10() {

        //arrange
        int you = -10;
        int date = 10;
        int expected = 0;

        //act
        int actual = dateFashion.getATable(you, date);

        //assert
        assertEquals("Because a negative number is still less than 2 (not stylish)", expected, actual);

    }

    @Test
    public void getATable_Should_Return2_ifGivenStyleValues15And5() {

        //arrange
        int you = 15;
        int date = 5;
        int expected = 2;

        //act
        int actual = dateFashion.getATable(you, date);

        //assert
        assertEquals("Because a positive number above expected range is still greater than 8 (very stylish)", expected, actual);

    }
}
