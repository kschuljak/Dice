package com.techelevator;

import java.util.Scanner;

public class KilometerConverter {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Enter a kilometer value to start at: ");
        String value = input.nextLine();
        int kilometerStart = Integer.parseInt(value);

        System.out.println("Enter a kilometer value to end at: ");
        value = input.nextLine();
        int kilometerEnd = Integer.parseInt(value);

        System.out.println("How many should it increment by: ");
        value = input.nextLine();
        int incrementBy = Integer.parseInt(value);

        System.out.println("Going from " + kilometerStart + "km to " + kilometerEnd + "km in increments of " + incrementBy + "km.");

        for (int km = kilometerStart; km <= kilometerEnd; km += incrementBy) {
            double miles = kilometersToMiles(km);
            System.out.println(km + "km is " + miles + "mi.");
        }
    }
        public static double kilometersToMiles(int kilometers) {
            final double MILES_PER_KILOMETER = 0.621371;
            return kilometers * MILES_PER_KILOMETER;
        }

    
}
