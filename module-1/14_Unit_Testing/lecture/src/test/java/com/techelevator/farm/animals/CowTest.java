package com.techelevator.farm.animals;

import org.junit.Test;

import static org.junit.Assert.*;

public class CowTest {
    @Test
    public void getSound_Should_beMoo_AfterCreating(){

        // arrange
        String expected = "moo!";
        Cow cow = new Cow();

        // act
        String actual = cow.getSound();

        // assert
        assertEquals("because Cow default for getSound is moo! after instantiation", expected, actual);

    }

}
