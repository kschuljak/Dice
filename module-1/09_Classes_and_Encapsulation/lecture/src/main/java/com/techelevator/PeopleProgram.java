package com.techelevator;

import com.techelevator.models.Person;

public class PeopleProgram {

    public static void main(String[] args) {

        // Person sting = new Person();
        // sting.setFirstName("Sting");
        // sting.setLastName("");
        // sting.setAge(71);

        // can also initialize object using 'generate a constructor'

        Person sting = new Person("Sting", "", 71);
        System.out.println(sting.getPerson());

    }
}
