package com.techelevator.models.products;

import java.math.BigDecimal;

/**
 * Responsibilities:
 *      Knows the id, name and price of the product
 */
public class Product 
{
    private String id;
    private String name;
    private BigDecimal price;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Product(String id, String name, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Product() {
    }
}
