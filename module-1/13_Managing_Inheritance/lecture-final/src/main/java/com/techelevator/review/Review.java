package com.techelevator.review;

import com.techelevator.farm.models.Singable;

import java.util.*;

public class Review
{
    public static void main(String[] args)
    {
        Employee employee = new Employee("Daniel", "Software Engineering");

        System.out.println(employee.getName());
        System.out.println(employee.getDepartment());
        System.out.println(employee);

        System.out.println();
        Person person = employee;//new Person("Vanessa");
        System.out.println(person.getName());
//        System.out.println(person.getDepartment());
        System.out.println(person.toString());

        System.out.println();

        Employee emp = (Employee)person;
        System.out.println(emp.getName());
        System.out.println(emp.getDepartment());

        long big = 50;
        int small = (int)big;



    }
}
