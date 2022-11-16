package com.techelevator.models;

import java.math.BigDecimal;

import com.techelevator.models.exceptions.InsuficientFundsException;

/**
 * Responsibilities:
 *      Manage all payment transactions
 *      Accept payment
 * 
 * Dependencies:
 *      ShoppingCart
 */
public class CashRegister 
{
    public BigDecimal pay()
    {
        // accepts payment and returns the change amount
        return BigDecimal.ONE;
    }
}
