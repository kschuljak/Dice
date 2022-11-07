package com.techelevator.challenge;

import java.math.BigDecimal;

public class SavingsAccount extends BankAccount {

    // constructors
    public SavingsAccount(String accountHolderName, String accountNumber, BigDecimal balance) {
        super(accountHolderName, accountNumber, balance);
    }
    public SavingsAccount(String accountHolderName, String accountNumber) {
        super(accountHolderName, accountNumber);
    }

    // override method
    public BigDecimal withdraw(BigDecimal amountToWithdraw) {
        BigDecimal localBalance = super.getBalance();
        BigDecimal newBalance = localBalance.subtract(amountToWithdraw);
        BigDecimal zeroBalance = new BigDecimal("0.00");
        BigDecimal oneHundredFifty = new BigDecimal("150.00");
        if ((newBalance.compareTo(zeroBalance) == 1 || newBalance.compareTo(zeroBalance) == 0) && newBalance.compareTo(oneHundredFifty) == -1) {
            BigDecimal serviceCharge = new BigDecimal("2.00");
            newBalance = newBalance.subtract(serviceCharge);
            if (newBalance.compareTo(zeroBalance) == 0 || newBalance.compareTo(zeroBalance) == 1) {
                amountToWithdraw = amountToWithdraw.add(serviceCharge);
                return super.withdraw(amountToWithdraw);
            } else {
                return super.getBalance();
            }
        }
        return super.withdraw(amountToWithdraw);
    }
}
