package com.techelevator.dao;

import com.techelevator.model.Customer;

import java.util.List;

public interface CustomerDao {

    Customer getCustomer(int customerId);

    List<Customer> getAllCustomers();
}
