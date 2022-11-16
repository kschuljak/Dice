package com.techelevator.models;

import com.techelevator.models.products.Product;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * Responsibilities:
 *      Add product to cart
 *      Remove product from cart
 *      Calculate the cart total price
 * 
 * Dependencies:
 *      Product
 */
public class ShoppingCart 
{
    private Map<Product, Integer> cart = new HashMap<>();

    public void add(Product product)
    {
        int quantity = cart.getOrDefault(product, 0) + 1;
        cart.put(product, quantity);
    }

    public BigDecimal getTotal()
    {
        return BigDecimal.ZERO;
    }
    
}
