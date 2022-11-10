package com.techelevator.demos;

import org.junit.After;
import org.junit.Test;

import static org.junit.Assert.*;

/*
                 | is Workday  | on Vacation || Expected
                 ________________________________________
regular workday  | true        | false       || false
workay on vacay  | true        | true        || true
weekend          | false       | false       || true
weekend on vacay | false       | true        || true

4 different scenarios: should have 4 different tests (one per scenario)

 */
public class AlarmClockTest {

    AlarmClock alarmClock;
    private final boolean IS_WEEKDAY = true;
    private final boolean IS_NOT_WEEKDAY = false;
    private final boolean ON_VACATION = true;
    private final boolean NOT_ON_VACATION = false;

    /*
    @Before
    public void setup(){
        // runs before every test
        alarmClock = new AlarmClock();
    }

    @After
    public void cleanup(){
        // runs after every test
    }
     */

    // workday = true, vacation = false
    @Test
    public void sleepIn_Should_BeFalse_YesWeekdayNoVacation(){
        // arrange
        AlarmClock alarmClock = new AlarmClock();
        boolean isWeekday = true;
        boolean onVacation = false;
        // expected = false;

        // act
        boolean actual = alarmClock.sleepIn(isWeekday, onVacation);

        // assert
        assertFalse("because I should not be able to sleep in on a weekday not on vacation", actual);
    }

    @Test
    public void sleepIn_Should_BeTrue_YesWeekdayYesVacation() {
        // arrange
        AlarmClock alarmClock = new AlarmClock();

        // expected = true;

        // act (using constants declared at top of test class)
        boolean actual = alarmClock.sleepIn(IS_WEEKDAY, ON_VACATION);

        // assert
        assertTrue("because I should be able to sleep in on a weekday while on vacation", actual);
    }

    /* BAD TEST:  assertEquals(false, alarmClock.sleepIn(true, false));
    - break it up! use explicit 1) arrange, 2) act, 3) assert mindset
     */
}
