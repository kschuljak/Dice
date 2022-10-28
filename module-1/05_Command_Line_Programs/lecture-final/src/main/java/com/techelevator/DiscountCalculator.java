package com.techelevator;

import java.util.Scanner;

class DiscountCalculator {

    /**
     * The main method is the start and end of our program
     */
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to the Discount Calculator");

        // Prompt the user for a discount amount
        // The answer needs to be saved as a double
        System.out.print("Enter the discount amount (w/out percentage): ");
        double discount = input.nextDouble();
        double discountedPercent = discount / 100;
        input.nextLine();



        // Prompt the user for a series of prices
        System.out.print("Please provide a series of prices (space separated): ");
        String line = input.nextLine();
        String[] priceValues = line.split(" ");

        for (int i = 0; i < priceValues.length; i++)
        {
            String priceValue = priceValues[i];

            double price = Double.parseDouble(priceValue);
            double discountedPrice = price - (price * discountedPercent);

            System.out.println("Original Price: $" + price);
            System.out.println("Discount: " + discount);
            System.out.println("Discounted Price: $" + discountedPrice);
            System.out.println();
        }



        /*
        original price: $20
        discount: 15
        discounted price: $17
         */






    }

}
