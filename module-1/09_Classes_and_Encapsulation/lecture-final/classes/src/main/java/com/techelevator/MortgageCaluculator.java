package com.techelevator;

import com.techelevator.models.Mortgage;

public class MortgageCaluculator
{
    public static void main(String[] args)
    {
        Mortgage mortgage = new Mortgage(100000,6,30);
        System.out.println(mortgage.getMonthlyPayment());
        System.out.println(mortgage.getTotalInterestPaid());

        System.out.println(mortgage.getBalance());
        mortgage.pay(599.55);
        mortgage.pay(599.55);
        mortgage.pay(599.55);
        mortgage.pay(599.55);
        mortgage.pay(599.55);
        System.out.println(mortgage.getBalance());
    }
}
