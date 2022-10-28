package com.techelevator;

import java.util.Scanner;

public class Demos {
    public static void main(String[] args) {

        // scanner used to get information from the user
        // new keyword = scanner object managed on the heap
        Scanner inputScanner = new Scanner(System.in);

        // println() does not require an argument & creates a new line
        // print() requires an argument & stays on the same line
        System.out.print("What is your favorite color? ");
        String color = inputScanner.nextLine();

        System.out.println("Your favorite color is " + color);
        System.out.println();

        System.out.print("Think of (and type) a number between 1 and 10: ");
        int number = inputScanner.nextInt(); // but when user hits 'enter', that's not an int
        inputScanner.nextLine(); // accepts users 'enter' keystroke, could be considered a hack
        System.out.println("Is the number " + number + "?");

        System.out.println();
        System.out.print("Think of (and type) another number between 1 and 10: ");
        String tempNumber = inputScanner.nextLine();
        number = Integer.parseInt(tempNumber); // will take string and return int
        System.out.println("Is the number " + number + "?");

        System.out.println();
        System.out.print("What college has the best football team? ");
        String team = inputScanner.nextLine();
        System.out.println("You think " + team + " is the best team?");

        System.out.println();
        System.out.print("Enter 3 numbers separated by a space. ex:(4 28 9): ");
        String userInputNumbers = inputScanner.nextLine();
        String[] userNumbers = userInputNumbers.split(" ");

        int sum = 0;
        for (int i = 0; i < userNumbers.length;i++) {
            String nextNumber = userNumbers[i];
            System.out.println(nextNumber);
            sum += Integer.parseInt(nextNumber);
        }
        System.out.println("----- sum of numbers -----");
        System.out.println(sum);

    }
}
