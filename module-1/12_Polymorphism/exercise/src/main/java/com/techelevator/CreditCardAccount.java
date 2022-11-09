package com.techelevator;

public class CreditCardAccount implements Accountable{

    private String accountHolder;
    private String accountNumber;
    private int debt = 0;

    public CreditCardAccount(String accountHolder, String accountNumber) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public int getDebt() {
        return debt;
    }

    public int pay(int amountToPay) {
        int debtAmount = getDebt();
        this.debt = debtAmount - amountToPay;
        return debt * -1;
    }
    public int charge(int amountToCharge) {
        int debtAmount = getDebt();
        this.debt = debtAmount + amountToCharge;
        return debt * -1;
    }

    @Override
    public int getBalance() {
        return this.getDebt() * -1;
    }
}
