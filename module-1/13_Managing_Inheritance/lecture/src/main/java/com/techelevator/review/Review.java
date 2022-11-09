package com.techelevator.review;

import com.techelevator.farm.models.Sellable;

public class Review {

    public static void main(String[] args) {

//        Person person = new Person("Daniel");
//
//        System.out.println(person.getName());
//
//        // displays string path of the class & memory address of the class object
//        // (if toString() method is not overwritten)
//        System.out.println(person);

        Employee employee = new Employee("Daniel", "Software Engineering");

        System.out.println(employee.getName());
        System.out.println(employee.getDepartment());
        System.out.println(employee);

        // employee 'IS-A' person (Employee inherits from Person)
        Person person = employee;

        System.out.println(person.getName());
        // System.out.println(person.getDepartment());   !!!inaccessible
        // person only points to superclass `Person` and not subclass `Employee`

        System.out.println(person.toString());

        Employee person2 = new Employee("Vanessa","Web Development");
        System.out.println(person2.getName());


        // an Employee is always a Person, but a Person is not always an Employee
        // Employee emp = person;   !!!cannot do
        // unless you know the superclass object is also the subclass object and typecast it
        Employee emp = (Employee)person2;
        System.out.println(emp.getName());
        System.out.println(emp.getDepartment());
    }
}
