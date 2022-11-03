package com.techelevator;

import com.techelevator.models.Person;

public class PeopleProgram
{
    public static void main(String[] args) {

        Person sting = new Person("Sting", "", 71);
//        sting.setFirstName("Sting");
//        sting.setLastName("");
//        sting.setAge(71);

        System.out.println(sting.getFirstName() + " " + sting.getLastName() + ": " + sting.getAge());

        Person theRock = new Person();
        theRock.setFirstName("The");
        theRock.setLastName("Rock");
        theRock.setAge(50);

        System.out.println(theRock.getFullName() + ": " + theRock.getAge());

    }
}
