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

    public static String getUserSelection()
    {
        System.out.print("Please make a selection: ");
        String selection = input.nextLine().toLowerCase();

        return selection;
    }

    public static BigDecimal getPayment()
    {
        System.out.print("Please enter payment amount: $");
        String amount = input.nextLine().toLowerCase();

        return new BigDecimal(amount);
    }
}
