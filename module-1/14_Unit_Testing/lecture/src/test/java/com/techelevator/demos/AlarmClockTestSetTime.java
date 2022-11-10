package com.techelevator.demos;

import org.junit.Test;

import static org.junit.Assert.*;

public class AlarmClockTestSetTime {

    private final boolean NOT_ON_VACATION = false;
    private final boolean ON_VACATION = true;
    private final int SUN = 0;
    private final int MON = 1;
    private final int TUE = 2;
    private final int WED = 3;
    private final int THU = 4;
    private final int FRI = 5;
    private final int SAT = 6;
    // 0 & 6 = weekend
    // 1 - 5 = weekend
    // input 7
    // input -1

    // EXPECTED:
    // NOT weekday & vacation - "off"
    // NOT weekday & NOT vacation - "10:00"
    // weekday & vacation - "10:00
    // weekday & NOT vacation - "7:00

    @Test
    public void setTime_ShouldBe_700_YesWeekdayNoVacation_Edges() {

        // arrange
        AlarmClock alarmClock = new AlarmClock();
        String expected = "7:00";

        // act
        String mondayActual = alarmClock.setTime(MON, NOT_ON_VACATION);
        String fridayActual = alarmClock.setTime(FRI, NOT_ON_VACATION);

        // assert
        assertEquals("because weekday (monday) not on vacation", expected, mondayActual);
        assertEquals("because weekday (friday) not on vacation", expected, fridayActual);
    }
}
