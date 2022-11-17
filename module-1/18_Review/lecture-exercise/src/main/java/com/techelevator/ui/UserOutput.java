package com.techelevator.ui;

/**
 * Responsibilities:
 *      This class should handle formatting and displaying ALL messages to the user
 * 
 * Dependencies:
 *      None
 */
public class UserOutput 
{

    public static void DisplayWelcomeScreen()
    {
        System.out.println();
        System.out.println("****************************");
        System.out.println("*** WELCOME TO THE STORE ***");
        System.out.println("****************************");
    }

    public static void DisplayHomeScreenMenu()
    {
        System.out.println();
        System.out.println("****************************");
        System.out.println("What would you like to do? ");
        System.out.println("A) View Items");
        System.out.println("B) View Cart");
        System.out.println("C) Add Item to Cart");
        System.out.println("D) Checkout");

    }
    
}
