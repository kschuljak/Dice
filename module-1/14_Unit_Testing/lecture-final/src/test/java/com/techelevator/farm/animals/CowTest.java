package com.techelevator.farm.animals;

import org.junit.Test;

import static org.junit.Assert.*;

public class CowTest
{
    @Test
    public void getSound_Should_BeMoo_AfterCreation()
    {
        // arrange -- setup
        String expected = "moo!";
        Cow cow = new Cow();

        // act -- the thing you are testing (ONE THING)
        String actual = cow.getSound();

        // assert
        assertEquals("Because a cow should say moo! after instantiation.",expected, actual);

    }

}
