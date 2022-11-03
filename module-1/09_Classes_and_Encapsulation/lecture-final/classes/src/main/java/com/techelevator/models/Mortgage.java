package com.techelevator.models;

public class Mortgage
{
    private double principal;
    private double balance;
    private double apr;
    private int term;

    public double getPrincipal() {
        return principal;
    }

    public double getBalance() {
        return balance;
    }

    public double getApr() {
        return apr;
    }

    public int getTerm() {
        return term;
    }

    // derived properties
    public int getNumberOfPayments() {
        return term * 12;
    }

    public double getMir() {
        return apr / 1200;
    }

    public double getMonthlyPayment()
    {
        double numerator = principal * getMir();
        double denominator = 1 - Math.pow(1 + getMir(), -getNumberOfPayments());
        return numerator / denominator;
    }

    public double getTotalInterestPaid()
    {
        return  (getMonthlyPayment() * getNumberOfPayments()) - principal;
    }

    public Mortgage(double principal, double apr, int term) {
        this.principal = principal;
        this.apr = apr;
        this.term = term;
        this.balance = principal;
    }

    public Mortgage(double principal, double apr, int term, double balance) {
        this.principal = principal;
        this.balance = balance;
        this.apr = apr;
        this.term = term;
    }

    public void pay(double amount)
    {
        // calculate the amount of interest
        double interest = balance * getMir();
        double principalPaid = amount - interest;

        balance -= principalPaid;
    }
}
