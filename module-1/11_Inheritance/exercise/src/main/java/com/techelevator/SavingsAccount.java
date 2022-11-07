package com.techelevator;

public class SavingsAccount extends BankAccount{

    // constructors
    public SavingsAccount(String accountHolderName, String accountNumber, int balance) {
        super(accountHolderName, accountNumber, balance);
    }
    public SavingsAccount(String accountHolderName, String accountNumber) {
        super(accountHolderName, accountNumber);
    }

    // override method
    public int withdraw(int amountToWithdraw) {
        int newBalance = super.getBalance() - amountToWithdraw;
        if (newBalance >= 0 && newBalance < 150) {
            int serviceCharge = 2;
            newBalance -= serviceCharge;
            if (newBalance >= 0) {
                amountToWithdraw += serviceCharge;
                return super.withdraw(amountToWithdraw);
            } else {
                return super.getBalance();
            }
        }
        return super.withdraw(amountToWithdraw);
    }
}
