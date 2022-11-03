package com.techelevator.models;

public class Mortgage {

    // private variables
    private double principal;
    private double balance;
    private double apr;
    private int term;

    // getters (no setters)
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
    public double getMonthlyPayment() {
        // monthly payment = (principal * mir) / 1 - (1 + mir) ^-payments
        double numerator = principal * getMir();
        double denominator = 1 - Math.pow(1 + getMir(), -getNumberOfPayments());
        return numerator / denominator;
    }
    public double getTotalInterestPaid() {
        return (getMonthlyPayment() * getNumberOfPayments()) - principal;
    }

    public void pay(double amount) {

        double interest = balance * getMir();
        double principalPaid = amount - interest;

        balance -= principalPaid;
    }

    // constructors
    public Mortgage(double principal, double apr, int term) {
        this.principal = principal;
        this.apr = apr;
        this.term = term;
        this.balance = principal;
    }

    public Mortgage(double principal, double apr, int term, double balance) {
        this.principal = principal;
        this.apr = apr;
        this.term = term;
        this.balance = balance;
    }
}

// - principal : double
// - balance : double
// - apr : double
// - term: int

// + getPrincipal()
// + getBalance()
// + getApt
// + getTerm()

// derived properties
// + getMonthlyPayment()
// + getTotalInterest()
// + numberOfPayments()

// constructors
// Mortgage(principal, apr, term)
// Mortgage(principal, apr, term, currentBalance)

// pay(amount): void
