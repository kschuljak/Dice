package com.techelevator.application;

import com.techelevator.models.CashRegister;

/**
 * The store class is the main application.
 * 
 * Responsibilities:
 *      manage the flow of the application
 * 
 * Dependencies:
 *      Inventory
 *      ShoppingCart
 *      CashRegister
 * 
 *      UI:
 *      UserInput
 *      UserOutput
 * 
 *      Utility:
 *      Logger - used to log errors and transactions
 */
public class Store 
{
    public void run()
    {

        while(true)
        {
            // display main menu
            String option = "";

            if(option.equals("add"))
            {
                // do add item task
            }
            else if(option.equals("pay"))
            {
                // go to cash register to check out
                break;
            }
            else
            {
                // invalid option try again
            }

        }

    }
}
