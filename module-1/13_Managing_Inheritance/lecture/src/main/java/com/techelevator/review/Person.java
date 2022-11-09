package com.techelevator.review;

// every class created extends Object implicitly
// so `class Person extends Object` is redundant
public class Person {

    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.getName() + " is a Person.";
    }
}
