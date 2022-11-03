package com.techelevator.models;

public class Person
{
    // private variables
    private String firstName = "";
    private String lastName = "";
    private int age = 0;

    // public properties
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
    }

    // derived property (calculated)
    public String getFullName()
    {
        return firstName + " " + lastName;
    }


    // constructors go here

    public Person()
    {
    }

    public Person(String firstName, String lastName, int age)
    {
//        setFirstName(firstName);
//        setLastName(lastName);
//        setAge(age);

        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

}
