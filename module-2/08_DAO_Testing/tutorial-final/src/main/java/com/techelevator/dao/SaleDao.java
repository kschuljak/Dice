package com.techelevator.dao;

import com.techelevator.model.Sale;

import java.util.List;

public interface SaleDao {

    Sale getSale(int saleId);

    List<Sale> getSalesByCustomerId(int customerId);

    Sale createSale(Sale sale);

    boolean updateSale(Sale sale);

    void deleteSale(int saleId);
}
