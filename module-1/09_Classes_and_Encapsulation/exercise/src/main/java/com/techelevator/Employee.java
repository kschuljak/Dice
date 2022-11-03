package com.techelevator;

public class Employee {

    // instance variables
    private int employeeId;
    private String firstName;
    private String lastName;
    private String fullName;
    private String department;
    private double annualSalary;

    // employee id - getter
    public int getEmployeeId() {
        return employeeId;
    }

    // first name - getter
    public String getFirstName() {
        return firstName;
    }

    // last name - getter and setter
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    // full name (derived) - getter
    public String getFullName() {
        return lastName + ", " + firstName;
    }

    // department - getter and setter
    public String getDepartment() {
        return this.department;
    }
    public void setDepartment(String department) {
        this.department = department;
    }

    // getter - annual salary
    public double getAnnualSalary() {
        return annualSalary;
    }

    // constructor
    // arguments: employee id, first name, last name, salary
    public Employee(int employeeId, String firstName, String lastName, double annualSalary) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.annualSalary = annualSalary;
    }

    // method
    public void raiseSalary(double percent) {
        double percentage = percent / 100;
        double raiseAmount = annualSalary * percentage;
        double newSalary = annualSalary + raiseAmount;
        this.annualSalary = newSalary;
    }
}
