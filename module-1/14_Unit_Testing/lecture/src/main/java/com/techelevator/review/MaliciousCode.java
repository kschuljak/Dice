package com.techelevator.review;

public class MaliciousCode {

    public static void main(String[] args) {

        Person person = new Person();
        person.firstName = "Some random name";
        // because 'firstName' in 'Person' class is 'protected', all classes in the same package can access & modify it
    }
}
