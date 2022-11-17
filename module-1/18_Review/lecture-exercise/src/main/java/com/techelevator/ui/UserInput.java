package com.techelevator.ui;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * Responsibilities:
 *      This class should handle receiving ALL input from the User
 * 
 * Dependencies:
 *      None
 */
public class UserInput 
{
    private static Scanner input = new Scanner(System.in);

    public static String GetHomeScreenSelection()
    {
        System.out.println("What would you like to do?");
        String selection = input.nextLine().toLowerCase();

        return selection;
    }

    public static BigDecimal getPayment()
    {
        System.out.println("Please enter payment amount: $");
        String amount = input.nextLine().toLowerCase();

        return new BigDecimal(amount);
    }
}
