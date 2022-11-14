package com.techelevator.payroll;

public class TimesheetNegativeHoursException extends Exception{

    private Timesheet timesheet;

    public TimesheetNegativeHoursException(Timesheet timesheet) {
        super("Hours cannot be negative.");
    }

    public Timesheet getTimesheet() {
        return timesheet;
    }

}
