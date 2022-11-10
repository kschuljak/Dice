package com.techelevator.review;

import java.math.BigDecimal;

public class Employee extends Person
{
    private BigDecimal salary;
    private String department;
    private String title;


    public BigDecimal getSalary()
    {
        return salary;
    }

    public void setSalary(BigDecimal salary)
    {
        this.salary = salary;
    }

    public String getDepartment()
    {
        return department;
    }

    public void setDepartment(String department)
    {
        this.department = department;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
        if(title.equalsIgnoreCase("manager"))
        {
            firstName = "Boss";
        }
    }
}
