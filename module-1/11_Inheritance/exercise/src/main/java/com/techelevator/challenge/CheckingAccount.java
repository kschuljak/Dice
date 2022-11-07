package com.techelevator.challenge;

import java.math.BigDecimal;

public class CheckingAccount extends BankAccount {

    // constructors
    public CheckingAccount(String accountHolderName, String accountNumber) {
        super(accountHolderName, accountNumber);

    }
    public CheckingAccount(String accountHolderName, String accountNumber, BigDecimal balance) {
        super(accountHolderName, accountNumber, balance);
    }

    // override method
    @Override
    public BigDecimal withdraw(BigDecimal amountToWithdraw) {
        BigDecimal localBalance = super.getBalance();
        BigDecimal zeroBalance = new BigDecimal("0.00");
        BigDecimal negativeOneHundred = new BigDecimal("-100.00");
        BigDecimal newBalance = localBalance.subtract(amountToWithdraw);
        if (newBalance.compareTo(zeroBalance) == -1 && newBalance.compareTo(negativeOneHundred) == 1) {
            BigDecimal overdraftFee = new BigDecimal("10.00");
            BigDecimal amountToWithdrawPlusOverdraftFee = amountToWithdraw.add(overdraftFee);
            return super.withdraw(amountToWithdrawPlusOverdraftFee);
        }
        if (newBalance.compareTo(negativeOneHundred) == -1 || newBalance.compareTo(negativeOneHundred) == 0) {
            return super.getBalance();
        }
        return super.withdraw(amountToWithdraw);
    }
}
