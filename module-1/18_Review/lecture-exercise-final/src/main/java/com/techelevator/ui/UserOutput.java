package com.techelevator.ui;

import com.techelevator.models.Inventory;
import com.techelevator.models.products.Product;

/**
 * Responsibilities:
 *      This class should handle formatting and displaying ALL messages to the user
 * 
 * Dependencies:
 *      None
 */
public class UserOutput 
{
    public static void displayWelcomeScreen()
    {
        System.out.println();
        System.out.println("*********************");
        System.out.println("Welcome to my Store!");
        System.out.println("*********************");
    }


    public static void displayHomeScreenMenu()
    {
        System.out.println();
        System.out.println("*********************");
        System.out.println("Home");
        System.out.println("*********************");
        System.out.println();
        System.out.println("A) Add item to cart");
        System.out.println("V) View cart");
        System.out.println("C) Checkout");
        System.out.println("X) Exit");
        System.out.println();
    }

    public static void displayInventory(Inventory inventory)
    {
        System.out.println();
        System.out.println("*********************");
        System.out.println("Products");
        System.out.println("*********************");
        System.out.println();

        for (Product product : inventory.getProducts())
        {
            System.out.println(product.getId() + ")  " + product.getName() + "  $" + product.getPrice());
        }

        System.out.println();
        System.out.println("B) Back");
        System.out.println();
    }

    public static void displayCart()
    {
        System.out.println();
        System.out.println("*********************");
        System.out.println("Shopping Cart");
        System.out.println("*********************");
        System.out.println();
        // loop through and display products and cart total
    }

    public static void displayCheckoutScreen()
    {
        System.out.println();
        System.out.println("*********************");
        System.out.println("Checkout");
        System.out.println("*********************");
        System.out.println();
        // display cart and cost
    }
}
