package com.techelevator;

public class Exercise00_GettingStarted {

    /*
    This example tests some of the weather logic found in this unit's tutorial. It's used in the
    lesson and video in Intro to Tools: Running unit tests.
     */

    // You can use this constant in your solutions.
    private final int FREEZING_TEMPERATURE_F = 32;

    /*
    Advise the caller if rain is expected in the forecast. If precipitation is expected, the forecast may be calling for rain or snow.
    If the temperature stays below freezing, snow is expected. If the temperature climbs above the
    freezing temperature, rain is expected. So, you'll need to test whether precipitation is expected
    *and* the temperature is above freezing.
     */
    public boolean isRainExpected(boolean precipitationExpected, int highTemperatureF) {
        // NOTE: This test fails because the next line handles the condition of a temperature
        // of 32 degrees improperly. If you run the unit tests, you'll see that when parameters
        // precipitationExpected:true and highTemperatureF:32 are passed in, the expected return
        // value is false, but this code returns true.
        // Modify the following line to change ">=" to ">" and re-run the test. It will pass.

        boolean isAboveFreezing = highTemperatureF > FREEZING_TEMPERATURE_F;

        if (precipitationExpected && isAboveFreezing) {
            return true;
        } else {
            return false;
        }
    }
}
