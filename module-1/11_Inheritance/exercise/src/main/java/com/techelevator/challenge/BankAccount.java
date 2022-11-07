package com.techelevator.challenge;

import java.math.BigDecimal;

public class BankAccount {

    // instance variables
    private String accountHolderName;
    private String accountNumber;
    private BigDecimal balance = new BigDecimal("0.00");

    // getters
    public String getAccountHolderName() {
        return accountHolderName;
    }
    public String getAccountNumber() {
        return accountNumber;
    }
    public BigDecimal getBalance() {
        return balance;
    }

    // constructors
    public BankAccount(String accountHolderName, String accountNumber) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
    }
    public BankAccount(String accountHolderName, String accountNumber, BigDecimal balance) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    // methods
    public BigDecimal deposit(BigDecimal amountToDeposit) {
        BigDecimal balancePlusDeposit = balance.add(amountToDeposit);
        return balance;
    }
    public BigDecimal withdraw(BigDecimal amountToWithdraw) {
        BigDecimal balanceMinusWithdrawal = balance.subtract(amountToWithdraw);
        return balance;
    }
}
