package com.techelevator;

import static org.junit.Assert.*;
import static org.junit.Assume.*;

import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

import java.lang.reflect.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CheckingAccountTest {

    private static Class checkingAccountClass;
    private static Constructor twoArgConstructor;
    private static Constructor threeArgConstructor;

    private static boolean isWellFormed = false;
    private static boolean hasPassedHappyPathTests = false;

    @Test
    public void test01_CheckingAccountClassWellFormed() {
        try {

            // Assert CheckingAccount class exists
            checkingAccountClass = Class.forName("com.techelevator.CheckingAccount");

            // Assert CheckingAccount extends BankAccount
            Class superclass = checkingAccountClass.getSuperclass();
            assertEquals("CheckingAccount must extend BankAccount.", superclass.getName(),"com.techelevator.BankAccount");

            // Assert constructors exist
            twoArgConstructor = SafeReflection.getConstructor(checkingAccountClass, String.class, String.class);
            assertNotNull("CheckingAccount does not have the required two argument constructor CheckingAccount(String, String). Make sure access for the constructor is public.", twoArgConstructor);
            assertTrue("CheckingAccount constructor CheckingAccount(String, String) must be public.", Modifier.isPublic(twoArgConstructor.getModifiers()));

            threeArgConstructor = SafeReflection.getConstructor(checkingAccountClass, String.class, String.class, int.class);
            assertNotNull("CheckingAccount does not have the required three argument constructor CheckingAccount(String, String, int). Make sure access for the constructor is public.", threeArgConstructor);
            assertTrue("CheckingAccount constructor CheckingAccount(String, String, int) must be public.", Modifier.isPublic(threeArgConstructor.getModifiers()));

            // Assert override methods are present -- whether they work is confirmed in other test methods
            Method withdrawMethod = SafeReflection.getMethod(checkingAccountClass, "withdraw", int.class);
            assertEquals("CheckingAccount must override withdraw(int). Make sure access for the method is public.", withdrawMethod.getDeclaringClass().getName(),"com.techelevator.CheckingAccount");

            // Assert BankAccount fields are NOT redefined in CheckingAccount
            Field accountHolderNameField = SafeReflection.getDeclaredField(checkingAccountClass, "accountHolderName");
            assertEquals("CheckingAccount must not redefine the field accountHolderName.", null, accountHolderNameField);
            Field accountNumberField = SafeReflection.getDeclaredField(checkingAccountClass, "accountNumber");
            assertEquals("CheckingAccount must not redefine the field accountNumber.", null, accountNumberField);
            Field balanceField = SafeReflection.getDeclaredField(checkingAccountClass, "balance");
            assertEquals("CheckingAccount must not redefine the field balance.", null, balanceField);

            // Assert BankAccount getters/setters are NOT redefined in CheckingAccount
            Method accountHolderNameGetter = SafeReflection.getMethod(checkingAccountClass, "getAccountHolderName");
            assertEquals("CheckingAccount must not redefine getter getAccountHolderName().","com.techelevator.BankAccount", accountHolderNameGetter.getDeclaringClass().getName());
            Method accountHolderNameSetter = SafeReflection.getMethod(checkingAccountClass, "setAccountHolderName", String.class);
            assertEquals("CheckingAccount must not redefine setter setAccountHolderName(String).", null, accountHolderNameSetter);
            Method accountNumberGetter = SafeReflection.getMethod(checkingAccountClass, "getAccountNumber");
            assertEquals("CheckingAccount must not redefine getAccountNumber().","com.techelevator.BankAccount", accountNumberGetter.getDeclaringClass().getName());
            Method accountNumberSetter = SafeReflection.getMethod(checkingAccountClass, "setAccountNumber", String.class);
            assertEquals("CheckingAccount must not redefine setter setAccountNumber(String).", null, accountNumberSetter);
            Method balanceGetter = SafeReflection.getMethod(checkingAccountClass, "getBalance");
            assertEquals("CheckingAccount must not redefine getter getBalance().","com.techelevator.BankAccount", balanceGetter.getDeclaringClass().getName());
            Method balanceSetter = SafeReflection.getMethod(checkingAccountClass, "setBalance", Integer.TYPE);
            assertEquals("CheckingAccount must not redefine setter setBalance(int).", null, balanceSetter);

            // Assert BankAccount methods are NOT redefined in CheckingAccount
            Method depositMethod = SafeReflection.getMethod(checkingAccountClass, "deposit", int.class);
            assertEquals("CheckingAccount must not redefine deposit(int).","com.techelevator.BankAccount", depositMethod.getDeclaringClass().getName());

            isWellFormed = true;
        } catch (Exception e) {
            fail("com.techelevator.CheckingAccount class does not exist.");
        }
    }

    @Test
    public void test02_HappyPath_Tests() throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
        assumeTrue("CheckingAccount is not well formed.", isWellFormed);

        // Assert constructors set fields
        // Two arg constructor
        Object checkingAccount = twoArgConstructor.newInstance("John Smith", "CHK:1234");
        Method getAccountHolderName = checkingAccount.getClass().getSuperclass().getMethod("getAccountHolderName");
        assertEquals("CheckingAccount two argument constructor CheckingAccount(String, String) does not correctly set the field AccountHolderName.","John Smith", getAccountHolderName.invoke(checkingAccount));
        Method getAccountNumber = checkingAccount.getClass().getSuperclass().getMethod("getAccountNumber");
        assertEquals("CheckingAccount two argument constructor CheckingAccount(String, String) does not correctly set the field AccountNumber.","CHK:1234", getAccountNumber.invoke(checkingAccount));
        // Three arg constructor
        checkingAccount = threeArgConstructor.newInstance("John Smith", "CHK:1234", 100);
        getAccountHolderName = checkingAccount.getClass().getMethod("getAccountHolderName");
        assertEquals("CheckingAccount three argument constructor CheckingAccount(String, String, int) does not correctly set the field AccountHolderName.","John Smith", getAccountHolderName.invoke(checkingAccount));
        getAccountNumber = checkingAccount.getClass().getMethod("getAccountNumber");
        assertEquals("CheckingAccount three argument constructor CheckingAccount(String, String, int) does not correctly set the field AccountNumber.","CHK:1234", getAccountNumber.invoke(checkingAccount));
        Method getBalance = checkingAccount.getClass().getMethod("getBalance");
        assertEquals("CheckingAccount three argument constructor CheckingAccount(String, String, int) does not correctly set the field Balance.",100, getBalance.invoke(checkingAccount));

        // Assert "no issue" withdraw decreases balance
        Method withdraw = checkingAccount.getClass().getMethod("withdraw", int.class);
        withdraw.invoke(checkingAccount, 23);
        assertEquals("CheckingAccount withdraw fails to decrease balance. Current balance: 100, withdraw: 23, new balance should be 77.", 77, getBalance.invoke(checkingAccount));

        hasPassedHappyPathTests = true;
    }

    @Test
    public void test03_EdgeCase_Tests() throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
        assumeTrue("CheckingAccount happy path tests have not passed.", hasPassedHappyPathTests);

        // Assert 1 dollar under 0 balance allows overdraft and assesses fee
        Object checkingAccount = threeArgConstructor.newInstance("", "", 100);
        Method getBalance = checkingAccount.getClass().getMethod("getBalance");
        Method withdraw = checkingAccount.getClass().getMethod("withdraw", int.class);
        withdraw.invoke(checkingAccount, 101);
        assertEquals("CheckingAccount current balance: 100, withdraw: 101, new balance should be -11 (-1 > -100, -10 fee incurred).", -11, getBalance.invoke(checkingAccount));

        // Assert 10 dollar above -100 balance allows overdraft and assesses fee
        checkingAccount = threeArgConstructor.newInstance("", "", 100);
        getBalance = checkingAccount.getClass().getMethod("getBalance");
        withdraw = checkingAccount.getClass().getMethod("withdraw", int.class);
        withdraw.invoke(checkingAccount, 190);
        assertEquals("CheckingAccount current balance: 100, withdraw: 190, new balance should be -100 (-90 > -100, -10 fee incurred).", -100, getBalance.invoke(checkingAccount));

        // Assert 1 dollar above -100 balance allows overdraft and assesses fee
        checkingAccount = threeArgConstructor.newInstance("", "", 100);
        getBalance = checkingAccount.getClass().getMethod("getBalance");
        withdraw = checkingAccount.getClass().getMethod("withdraw", int.class);
        withdraw.invoke(checkingAccount, 199);
        assertEquals("CheckingAccount current balance: 100, withdraw: 199, new balance should be -109 (-99 > -100, -10 fee incurred).", -109, getBalance.invoke(checkingAccount));

        // Assert withdraw that would make -100 balance denies overdraft and doesn't assess fee
        checkingAccount = threeArgConstructor.newInstance("", "", 100);
        getBalance = checkingAccount.getClass().getMethod("getBalance");
        withdraw = checkingAccount.getClass().getMethod("withdraw", int.class);
        withdraw.invoke(checkingAccount, 200);
        assertEquals("CheckingAccount current balance: 100, withdraw: 200, overdraft should be denied (100 - 200 >= -100) and balance remains 100.", 100, getBalance.invoke(checkingAccount));
    }
}
