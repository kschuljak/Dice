package com.techelevator.models.exceptions;

import java.math.BigDecimal;

/**
 * Responsibilities:
 *      Store additional details for the exception when a customer does not have enough money
 * 
 */
public class InsuficientFundsException extends Exception
{
    private BigDecimal cartTotal;
    private BigDecimal paymentAmount;

    public InsuficientFundsException(String message, BigDecimal cartTotal, BigDecimal paymentAmount)
    {
        super(message);

        this.cartTotal = cartTotal;
        this.paymentAmount = paymentAmount;
    }

    public BigDecimal getCartTotal()
    {
        return this.cartTotal;
    }

    public BigDecimal getPaymentAmount()
    {
        return this.paymentAmount;
    }

    @Override
    public String getMessage()
    {
        String message = super.getMessage();

        return message 
            + "\nCart Total: $" + cartTotal.toString()
            + "\nPayment: $" + paymentAmount.toString();
    }
}
