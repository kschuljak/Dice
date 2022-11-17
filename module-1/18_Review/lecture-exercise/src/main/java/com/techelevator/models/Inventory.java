package com.techelevator.models;

import com.techelevator.models.products.Product;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Responsibilities:
 *      Track current inventory
 *      Add new inventory
 * 
 * Dependencies:
 *      Product
 *      FileProductLoader - this knows how to load all products from the file
 */
public class Inventory {

    private List<Product> products = new ArrayList<>();

    public List<Product> getProducts() {
        return products;
    }

    public Inventory()
    {
        // Inventory should NOT know how to read from a file
        // we will use the FileProductLoader to get the products
        // - FOR SIMPLICITY, NOT SEPARATING INTO FILE PRODUCT LOADER

        loadInventory();
    }

    public void loadInventory(){

        File productsFile = new File("data/products.csv");
        try(Scanner reader = new Scanner(productsFile))
        {
            reader.nextLine();
            while (reader.hasNextLine()){
                String line = reader.nextLine();
                String[] columns = line.split(" ");

                String id = columns[0];
                String name = columns[1];
                BigDecimal price = new BigDecimal(columns[2]);

                Product product = new Product(id, name, price);
                products.add(product);
            }

        }
        catch(IOException ex)
        {

        }
    }

    public void addProduct(Product product){
        products.add(product);
    }

    
}
