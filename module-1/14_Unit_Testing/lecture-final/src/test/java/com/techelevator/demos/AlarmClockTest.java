package com.techelevator.demos;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AlarmClockTest
{
    AlarmClock alarmClock;

    private final boolean IS_WEEKEDAY = true;
    private final boolean IS_NOT_WEEKEDAY = false;
    private final boolean ON_VACATION = true;
    private final boolean NOT_ON_VACATION = false;

    @Before
    public void setup()
    {
        // runs before EVERY test
        alarmClock = new AlarmClock();
    }

    @After
    public void cleanup()
    {
        //anything that we want run after EVERY test
    }

    @Test
    public void sleepInBadTest()
    {
        assertEquals(false, alarmClock.sleepIn(true, false));
    }


    @Test
    public void sleepIn_Should_BeFalse_OnWeekayAtHome()
    {
        // arrange
        // act
        boolean actual = alarmClock.sleepIn(IS_WEEKEDAY, NOT_ON_VACATION);

        // assert
        assertFalse("Because I should not be able to sleep in on a weekday at home", actual);
    }

    @Test
    public void sleepIn_Should_BeTrue_OnWeekayOnVacation()
    {
        // arrange
        // act
        boolean actual = alarmClock.sleepIn(IS_WEEKEDAY, ON_VACATION);

        // assert
        assertTrue("Because I SHOULD be able to sleep in on a weekday while on vacation", actual);
    }

    // set time tests

    @Test
    public void setTime_ShouldBe_700_OnWeekdayAtHome_Edges()
    {
        // arrange
        int monday = 1;
        int friday = 5;

        String expected = "7:00";

        // act
        String mondayActual = alarmClock.setTime(monday, NOT_ON_VACATION);
        String fridayActual = alarmClock.setTime(friday, NOT_ON_VACATION);

        // assert
        assertEquals("Because Monday at Home should be 7:00", expected, mondayActual);
        assertEquals("Because Friday at Home should be 7:00", expected, fridayActual);

    }



}
