package com.techelevator.application;

import com.techelevator.models.CashRegister;
import com.techelevator.ui.UserInput;
import com.techelevator.ui.UserOutput;

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

            // create basic wireframe in application to check screen navigation/ app flow
            // store is the container that manages everything
            // need a place to store inventory - store in Store (private inventory variable - encapsulated in Store)

            // add to cart
            // 1 - display inventory
            // 2 - get user selection
            // 3 - add to cart/ cancel (based on user selection)
    {

        UserOutput.DisplayWelcomeScreen();

        while(true)
        {
            // display main menu
            UserOutput.DisplayHomeScreenMenu();
            String option = UserInput.GetHomeScreenSelection();

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
