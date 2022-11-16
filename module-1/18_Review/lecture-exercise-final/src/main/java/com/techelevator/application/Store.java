package com.techelevator.application;

import com.techelevator.models.CashRegister;
import com.techelevator.models.Inventory;
import com.techelevator.models.file_io.Logger;
import com.techelevator.models.products.Product;
import com.techelevator.ui.UserInput;
import com.techelevator.ui.UserOutput;

import java.math.BigDecimal;

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
    // store the inventory
    private Inventory inventory;
    // manage cash
    private CashRegister cashRegister;
    private Logger exceptionLogger = new Logger("errors");
    private Logger activityLogger = new Logger("logs");

    public Store()
    {
        inventory = new Inventory();
        inventory.loadInventory();
    }

    public void run()
    {
        // display a welcome screen
        UserOutput.displayWelcomeScreen();

        while(true)
        {
            // display main menu
            UserOutput.displayHomeScreenMenu();
            String option = UserInput.getUserSelection();

            if(option.equals("a"))
            {
                // do add item task
                addItemToCart();
            }
            else if(option.equals("v"))
            {
                // display the cart
                viewCart();
            }
            else if(option.equals("c"))
            {
                // go to cash register to check out
                checkout();
                // then break to exit
                break;
            }
            else if(option.equals("x"))
            {
                // just break to exit the application
                break;
            }
            else
            {
                // invalid option try again
            }

        }

    }

    private void addItemToCart()
    {
        // 1 display inventory
        UserOutput.displayInventory(inventory);

        // 2 get user selection
        String option = UserInput.getUserSelection();

        // 3 add to cart or cancel
        if(option.equals("b")) return;

        // get product by id and add to cart
        try
        {
            Product product = inventory.find(option);
            // add the product to the cart
            activityLogger.logMessage("Added product to cart: " + product.getId() + " : "+ product.getName());
        }
        catch (Exception ex)
        {
          // log the exception
            exceptionLogger.logMessage(ex.getMessage());
        }

    }

    private void viewCart()
    {
        // 1 display cart
        UserOutput.displayCart();

        // 2 get user selection
        String option = UserInput.getUserSelection();

        // 3 use the users selected option
    }

    private void checkout()
    {
        // 1 display cart
        UserOutput.displayCheckoutScreen();

        // 2 get user selection
        BigDecimal payment = UserInput.getPayment();

        // 3 process the payment
    }
}
