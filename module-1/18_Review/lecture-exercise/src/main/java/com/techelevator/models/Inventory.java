package com.techelevator.models;

/** 
 * Responsibilities:
 *      Track current inventory
 *      Add new inventory
 * 
 * Dependencies:
 *      Product
 *      FileProductLoader - this knows how to load all products from the file
 */
public class Inventory 
{

    private void loadInventory()
    {
        // Inventory should NOT know how to read from a file
        // we will use the FileProductLoader to get the products
    }
    
}
