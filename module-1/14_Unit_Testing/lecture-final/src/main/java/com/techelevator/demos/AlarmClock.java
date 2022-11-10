package com.techelevator.demos;

public class AlarmClock
{
    /*
     The parameter weekday is true if it is a weekday,
     and the parameter vacation is true if we are on
     vacation. We sleep in if it is not a weekday or we're
     on vacation. Return true if we sleep in.

     sleepIn(false, false) → true
     sleepIn(true, false) → false
     sleepIn(false, true) → true
     */
    public boolean sleepIn(boolean isWeekday, boolean onVacation)
    {
        boolean sleepIn = !isWeekday || onVacation;

        return sleepIn;
    }


    /*
     Given a day of the week encoded as
     0=Sun, 1=Mon, 2=Tue, ...6=Sat,
     and a boolean indicating if we are on vacation,
     return a string of the form "7:00"
     indicating when the alarm clock should ring.

     On weekdays the alarm should be "7:00"
     and on the weekend it should be "10:00".
     Unless we are on vacation --
     then on weekdays it should be "10:00"
     and weekends it should be "off".

     setTime(1, false) → "7:00"
     setTime(5, false) → "7:00"
     setTime(0, false) → "10:00"
     */
    public String setTime(int day, boolean onVacation)
    {
        boolean isWeekend = day == 0 || day == 6;

        if (onVacation)
        {
            return isWeekend ? "off" : "10:00";
        }
        else
        {
            return isWeekend ? "10:00" : "7:00";
        }
    }

}
