package com.techelevator;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BankCustomer {

    private String name;
    private String address;
    private String phoneNumber;
    private List<Accountable> accounts = new ArrayList<>();

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Accountable[] getAccounts() {
        return this.accounts.toArray(new Accountable[0]);
    }
    public void addAccount(Accountable newAccount) {
        Accountable[] accountArray = this.getAccounts();
        List<Accountable> accountList = new ArrayList<>();
        Collections.addAll(accountList, accountArray);
        accountList.add(newAccount);
        this.accounts = accountList;
    }

    public boolean isVip(){
        int isVIPMin = 25000;
        int total = 0;
        Accountable[] accountableList = getAccounts();
        for (Accountable accountable : accountableList) {
            total += accountable.getBalance();
        }
        return (total >= isVIPMin);
    }

    public BankCustomer() {
    }

    public BankCustomer(String name, String address, String phoneNumber, List<Accountable> accounts) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.accounts = accounts;
    }
}
