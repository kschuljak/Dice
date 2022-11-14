package com.techelevator.payroll;

public class Timesheet
{
    private String id;
    private String name;
    private double hours;
    private double rate;

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public double getHours()
    {
        return hours;
    }

    public void setHours(double hours) throws TimesheetNegativeHoursException
    {
        this.hours = hours;
        if(this.hours < 0)
        {
            throw new TimesheetNegativeHoursException(this);
        }
    }

    public double getRate()
    {
        return rate;
    }

    public void setRate(double rate)
    {
        this.rate = rate;
    }

    public double getGrossPay()
    {
        return hours * rate;
    }
}
