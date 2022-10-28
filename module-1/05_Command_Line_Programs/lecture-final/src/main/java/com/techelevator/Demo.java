package com.techelevator;

import java.util.Scanner;

public class Demo
{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("What is your favorite color? ");
        String color = input.nextLine();
        System.out.println("Your favorite color is " + color);
//        if(color == "red") // <-- this will not work
        if(color.equalsIgnoreCase("red"))
        {
            System.out.println("YES!!!");
        }

        System.out.println();
        System.out.print("Think of (and type) a number between 1 and 10: ");
        int number = input.nextInt();
        input.nextLine();
        System.out.println("Is the number " + number + "?");

        System.out.println();
        System.out.print("Think of (and type) another number between 1 and 10: ");
        String tempNumber = input.nextLine();
        number = Integer.parseInt(tempNumber);
        System.out.println("Is the number " + number + "?");


        System.out.println();
        System.out.print("What college has the best football team? ");
        String team = input.nextLine();
        System.out.println("So you think that " + team + " is the best?");


        System.out.println();
        System.out.print("Enter several numbers separated by a space (12 35 87): ");
        String line = input.nextLine();
        String[] numbers = line.split(" ");

        int sum = 0;
        for (int i = 0; i < numbers.length; i++)
        {
            String temp = numbers[i];
            System.out.println(temp);
            sum += Integer.parseInt(temp);
        }
        System.out.println("------");
        System.out.println(sum);

    }
}
