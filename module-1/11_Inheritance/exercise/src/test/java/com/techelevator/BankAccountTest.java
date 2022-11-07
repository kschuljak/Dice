package com.techelevator;

import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

import java.lang.reflect.*;

import static org.junit.Assert.*;
import static org.junit.Assume.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BankAccountTest {

    private static Class bankAccountClass;
    private static Constructor twoArgConstructor;
    private static Constructor threeArgConstructor;

    private static boolean isWellFormed = false;
    private static boolean hasPassedHappyPathTests = false;

    @Test
    public void test01_BankAccountClassWellFormed() {
        try {

            // Assert BankAccount class exists
            bankAccountClass = Class.forName("com.techelevator.BankAccount");

            // Assert constructors exist
            twoArgConstructor = SafeReflection.getConstructor(bankAccountClass, String.class, String.class);
            assertNotNull("BankAccount does not have the required two argument constructor BankAccount(String, String). Make sure access for the constructor is public.", twoArgConstructor);
            assertTrue("BankAccount constructor BankAccount(String, String) must be public.", Modifier.isPublic(twoArgConstructor.getModifiers()));

            threeArgConstructor = SafeReflection.getConstructor(bankAccountClass, String.class, String.class, int.class);
            assertNotNull("BankAccount does not have the required three argument constructor BankAccount(String, String, int). Make sure access for the constructor is public.", threeArgConstructor);
            assertTrue("BankAccount constructor BankAccount(String, String, int) must be public.", Modifier.isPublic(threeArgConstructor.getModifiers()));

            // Assert fields exist, are of correct type and access
            Field accountHolderNameField = SafeReflection.getDeclaredField(bankAccountClass, "accountHolderName");
            assertNotNull("BankAccount does not have the required field accountHolderName.", accountHolderNameField);
            assertEquals("BankAccount field accountHolderName must be type String.", "java.lang.String", accountHolderNameField.getType().getName());
            assertTrue("BankAccount field accountHolderName must be private.", Modifier.isPrivate(accountHolderNameField.getModifiers()));

            Field accountNumberField = SafeReflection.getDeclaredField(bankAccountClass, "accountNumber");
            assertNotNull("BankAccount does not have the required field accountNumber.", accountNumberField);
            assertEquals("BankAccount field accountNumber must be type String.", "java.lang.String", accountNumberField.getType().getName());
            assertTrue("BankAccount field accountNumber must be private.", Modifier.isPrivate(accountNumberField.getModifiers()));

            Field balanceField = SafeReflection.getDeclaredField(bankAccountClass, "balance");
            assertNotNull("BankAccount does not have the required field balance.", balanceField);
            assertEquals("BankAccount field balance must be type int.", "int", balanceField.getType().getName());
            assertTrue("BankAccount field balance must be private.", Modifier.isPrivate(balanceField.getModifiers()));

            // Assert getters and setters for fields
            Method accountHolderNameGetter = SafeReflection.getMethod(bankAccountClass, "getAccountHolderName");
            assertTrue("BankAccount must have getter getAccountHolderName(). Make sure access for the getter is public.", accountHolderNameGetter != null);
            assertTrue("BankAccount getter getAccountHolderName() must return type String", accountHolderNameGetter.getReturnType() == String.class);
            assertTrue("BankAccount getter getAccountHolderName() must be public.", Modifier.isPublic(accountHolderNameGetter.getModifiers()));
            Method accountHolderNameSetter = SafeReflection.getMethod(bankAccountClass, "setAccountHolderName", String.class);
            assertTrue("BankAccount must not have a setter setAccountHolderName(String)", accountHolderNameSetter == null);

            Method accountNumberGetter = SafeReflection.getMethod(bankAccountClass, "getAccountNumber");
            assertTrue("BankAccount must have getter getAccountNumber(). Make sure access for the getter is public.", accountNumberGetter != null);
            assertTrue("BankAccount getter getAccountNumber() must return type String", accountNumberGetter.getReturnType() == String.class);
            assertTrue("BankAccount getter getAccountNumber() must be public.", Modifier.isPublic(accountNumberGetter.getModifiers()));
            Method accountNumberSetter = SafeReflection.getMethod(bankAccountClass, "setAccountNumber", String.class);
            assertTrue("BankAccount must not have a setter setAccountNumber(String)", accountNumberSetter == null);

            Method balanceGetter = SafeReflection.getMethod(bankAccountClass, "getBalance");
            assertTrue("BankAccount must have getter getBalance(). Make sure access for the getter is public.", balanceGetter != null);
            assertTrue("BankAccount getter getBalance() must return type int", balanceGetter.getReturnType() == Integer.TYPE);
            assertTrue("BankAccount getter getBalance() must be public.", Modifier.isPublic(balanceGetter.getModifiers()));
            Method balanceSetter = SafeReflection.getMethod(bankAccountClass, "setBalance", Integer.TYPE);
            assertTrue("BankAccount must not have a setter setBalance(int)", balanceSetter == null);

            // Assert methods are present -- whether they work is done in other test methods
            Method depositMethod = SafeReflection.getMethod(bankAccountClass, "deposit", int.class);
            assertTrue("BankAccount must have method deposit(int). Make sure access for the method is public.", depositMethod != null);
            assertTrue("BankAccount method deposit(int) must return type int", depositMethod.getReturnType() == Integer.TYPE);
            assertTrue("BankAccount method deposit(int) must be public.", Modifier.isPublic(depositMethod.getModifiers()));

            Method withdrawMethod = SafeReflection.getMethod(bankAccountClass, "withdraw", int.class);
            assertTrue("BankAccount must have method withdraw(int). Make sure access for the method is public.", withdrawMethod != null);
            assertTrue("BankAccount method withdraw(int) must return type int", withdrawMethod.getReturnType() == Integer.TYPE);
            assertTrue("BankAccount method withdraw(int) must be public.", Modifier.isPublic(withdrawMethod.getModifiers()));

            isWellFormed = true;
        }
        catch (Exception e) {
            fail("com.techelevator.BankAccount class does not exist.");
        }
    }

    @Test
    public void test02_HappyPath_Tests() throws InvocationTargetException, IllegalAccessException, InstantiationException, NoSuchMethodException {
        assumeTrue("BankAccount is not well formed.", isWellFormed);

        // Assert constructors set fields
        // Two arg constructor
        Object bankAccount = twoArgConstructor.newInstance("John Smith", "CHK:1234");
        Method getAccountHolderName = bankAccount.getClass().getMethod("getAccountHolderName");
        assertEquals("BankAccount two argument constructor BankAccount(String, String) does not correctly set the field AccountHolderName.","John Smith", getAccountHolderName.invoke(bankAccount));
        Method getAccountNumber = bankAccount.getClass().getMethod("getAccountNumber");
        assertEquals("BankAccount two argument constructor BankAccount(String, String) does not correctly set the field AccountNumber.","CHK:1234", getAccountNumber.invoke(bankAccount));
        // Three arg constructor
        bankAccount = threeArgConstructor.newInstance("John Smith","CHK:1234", 100);
        getAccountHolderName = bankAccount.getClass().getMethod("getAccountHolderName");
        assertEquals("BankAccount three argument constructor BankAccount(String, String, int) does not correctly set the field AccountHolderName.","John Smith", getAccountHolderName.invoke(bankAccount));
        getAccountNumber = bankAccount.getClass().getMethod("getAccountNumber");
        assertEquals("BankAccount three argument constructor BankAccount(String, String, int) does not correctly set the field AccountNumber.","CHK:1234", getAccountNumber.invoke(bankAccount));
        Method getBalance = bankAccount.getClass().getMethod("getBalance");
        assertEquals("BankAccount three argument constructor BankAccount(String, String, int) does not correctly set the field Balance.",100, getBalance.invoke(bankAccount));

        // Assert deposit increases balance
        Method deposit = bankAccount.getClass().getMethod("deposit", int.class);
        deposit.invoke(bankAccount, 23);
        assertEquals("BankAccount deposit fails to increase balance. Current balance: 100, deposit: 23, new balance should be 123.", 123, getBalance.invoke(bankAccount));

        // Assert withdraw decreases balance
        Method withdraw = bankAccount.getClass().getMethod("withdraw", int.class);
        withdraw.invoke(bankAccount, 22);
        assertEquals("BankAccount withdraw fails to decrease balance. Current balance: 123, withdraw: 22, new balance should be 101.", 101, getBalance.invoke(bankAccount));

        hasPassedHappyPathTests = true;
    }

    @Test
    public void test03_EdgeCase_Tests() throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
        assumeTrue("BankAccount happy path tests have not passed.", hasPassedHappyPathTests);

        //Assert
        Object bankAccount = twoArgConstructor.newInstance("","");
        Method getBalance = bankAccount.getClass().getMethod("getBalance");
        assertEquals("BankAccount two argument constructor BankAccount(String, String) does not default balance to 0.",0, getBalance.invoke(bankAccount));
    }

}
