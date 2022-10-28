package com.techelevator;

import java.util.Scanner;

class DiscountCalculator {

    /**
     * The main method is the start and end of our program
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Discount Calculator");

        // Prompt the user for a discount amount
        // The answer needs to be saved as a double
        System.out.print("Enter the discount amount (w/out percentage): ");

        String stringDiscount = scanner.nextLine();
        double doubleDiscount = Double.parseDouble(stringDiscount);


        // Prompt the user for a series of prices
        System.out.print("Please provide a series of prices (space separated): ");
        String priceInputLine = scanner.nextLine();
        String[] priceValues = priceInputLine.split(" ");

        double discountPercentage = doubleDiscount / 100;
        System.out.println("Discount: " + doubleDiscount + "%");


        for (int i = 0; i < priceValues.length; i++) {
            double doublePrice = Double.parseDouble(priceValues[i]);
            double discountTotal = doublePrice * discountPercentage;
            double discountedPrice = doublePrice - discountTotal;
            System.out.println("Original Price: $" + doublePrice);
            System.out.println("Discounted Price: $" + discountedPrice);
            System.out.println("You saved $" + discountTotal);

        }
    }
    /*
    public static double discountConversion(double[] priceValues, double discount) {

        double discountPercentage = discount / 100;
        System.out.println("Discount: " + discount + "%");

        for (int i = 0; i < priceValues.length; i++) {

            double discountTotal = price * discountPercentage;
            double discountedPrice = price - discountTotal;
            System.out.println("Original Price: $" + price);
            System.out.println("Discounted Price: $" + discountedPrice);
            System.out.println("You saved $" + discountTotal);
            return discountedPrice;
        }
    }
    */
}

// create variables to store user input
// parse Strings into doubles
// pass in variables to conversion function
// return result in function
// output result
