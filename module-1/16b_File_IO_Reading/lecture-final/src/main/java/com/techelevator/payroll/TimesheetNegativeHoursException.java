package com.techelevator.payroll;

public class TimesheetNegativeHoursException extends Exception
{
    private Timesheet timesheet;

    public TimesheetNegativeHoursException(Timesheet timesheet)
    {
        super("Hours cannot be negative.");

        this.timesheet = timesheet;
    }

    public Timesheet getTimesheet()
    {
        return timesheet;
    }
}
