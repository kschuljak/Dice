package com.techelevator;

public class CheckingAccount extends BankAccount{

    // constructors
    public CheckingAccount(String accountHolderName, String accountNumber) {
        super(accountHolderName, accountNumber);

    }
    public CheckingAccount(String accountHolderName, String accountNumber, int balance) {
        super(accountHolderName, accountNumber, balance);
    }

    // override method
    @Override
    public int withdraw(int amountToWithdraw) {
        int newBalance = super.getBalance() - amountToWithdraw;
        if (newBalance < 0 && newBalance > -100) {
            int overdraftFee = 10;
            amountToWithdraw += overdraftFee;
            return super.withdraw(amountToWithdraw);
        }
        if (newBalance <= -100) {
            return super.getBalance();
        }
        return super.withdraw(amountToWithdraw);
    }
}
