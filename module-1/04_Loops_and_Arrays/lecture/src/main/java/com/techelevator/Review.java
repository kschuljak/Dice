package com.techelevator;

import java.util.Scanner;

public class Review {
    public static void main(String[] args) {

        System.out.println("comparing test and test: " + areEqual("test", "test"));

        // allows you to get user input
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the first word: ");
        String one = input.nextLine(); // test
        System.out.println("Enter the second word: ");
        String two = input.nextLine(); // test

        System.out.println("areEqual2: " + areEqual2(one, two)); // false
        System.out.println("areEqual3: " + areEqual3(one, two)); // true
        System.out.println("areEqual4: " + areEqual4(one, two)); // true
        System.out.println("areEqual5: " + areEqual5(one, two)); // false
        System.out.println("areEqual6: " + areEqual6(one, two)); // true
    }

    public static boolean areEqual(String a, String b){
        return a == b;
    }

    public static boolean areEqual2(String one, String two){
        return one == two;
    }

    public static boolean areEqual3(String c, String d){
        return c.equals(d);
    }

    public static boolean areEqual4(String e, String f){
        return e.equalsIgnoreCase(f);
    }

    public static boolean areEqual5(String g, String h){
        return g.trim() == h.trim();
    }

    public static boolean areEqual6(String i, String j){
        return i.trim().equals(j.trim());
    }

}
