package com.techelevator.models;

public class Person {

    private String firstName;
    private String lastName;
    private int age;
    private boolean isAdult;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
        if (this.age >= 18) {
            this.isAdult = true;
        }
    }

    public boolean isAdult() {
        return isAdult;
    }

    // methods
    public String getPerson() {
        return firstName + " " + lastName + ": " + age;
    }

    // constructor - initializes variables
    public Person(String firstName, String lastName, int age) {
        this.firstName = "";
        this.lastName = "";
        this.age = 0;
    }



}
