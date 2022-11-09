package com.techelevator.review;

public class Employee extends Person{

    private String department;

    public Employee(String name, String department) {
        super(name);
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }
    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return super.getName() + " works in " + this.getDepartment();
    }
}
