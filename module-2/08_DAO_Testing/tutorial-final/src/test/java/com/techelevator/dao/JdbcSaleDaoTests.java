package com.techelevator.dao;

import com.techelevator.model.Sale;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

public class JdbcSaleDaoTests extends BaseDaoTests {

    // Step One: Add constants for Madge
    private static final int MADGE_CUSTOMER_ID = 3;
    private static final int MADGE_FIRST_SALE_ID = 5;

    // Step Two: Add constants for customer without sale and non-existent customer
    private static final int CUSTOMER_WITHOUT_SALES_ID = 5;
    private static final int NON_EXISTENT_CUSTOMER_ID = 7;

    private JdbcSaleDao jdbcSaleDao;

    @Before
    public void setup() {

        // Arrange - new instance of JdbcSaleDao before each and every test
        jdbcSaleDao = new JdbcSaleDao(dataSource);
    }

    @Test
    public void getSale_returns_correct_sale_for_id() {

        // Step One: Replace Assert.fail("Test not implemented.")
        // Assert.fail("Test not implemented.");

        // Arrange - Create an instance of Madge's first Sale object.
        Sale madgeFirstSale = mapValuesToSale(MADGE_FIRST_SALE_ID, new BigDecimal("23.98"), true, MADGE_CUSTOMER_ID);

        // Act - retrieve Madge's first sale
        Sale sale = jdbcSaleDao.getSale(MADGE_FIRST_SALE_ID);

        // Assert - retrieved sale is not null and matches expected sale
        Assert.assertNotNull("getSale(" + MADGE_FIRST_SALE_ID + ") returned null", sale);
        assertSalesMatch("getSale(" + MADGE_FIRST_SALE_ID + ") returned wrong or partial data", madgeFirstSale, sale);
    }

    @Test
    public void getSalesByCustomerId_returns_sales_for_customer_id() {

        // Step Two: Replace Assert.fail("Test not implemented.")
        // Assert.fail("Test not implemented.");

        // Act - retrieve sales for Madge
        List<Sale> sales = jdbcSaleDao.getSalesByCustomerId(MADGE_CUSTOMER_ID);
        // Assert - Madge has two existing sales
        Assert.assertEquals("getSalesByCustomerId(" + MADGE_CUSTOMER_ID + ") returned wrong number of sales",
                2, sales.size());

        // Act - retrieve customer with no sales
        sales = jdbcSaleDao.getSalesByCustomerId(CUSTOMER_WITHOUT_SALES_ID);
        // Assert - list of sales is empty for customer with no sales
        Assert.assertEquals("getSalesByCustomerId(" + CUSTOMER_WITHOUT_SALES_ID +
                ") without sales returned wrong number of sales", 0, sales.size());

        // Act - retrieve customer that doesn't exist
        sales = jdbcSaleDao.getSalesByCustomerId(NON_EXISTENT_CUSTOMER_ID);
        // Assert - list of sales is empty for customer that doesn't exist
        Assert.assertEquals("Customer doesn't exist, getSalesByCustomerId(" + NON_EXISTENT_CUSTOMER_ID +
                ") returned the wrong number of sales", 0, sales.size());
    }

    @Test
    public void createSale_returns_sale_with_id_and_expected_values() {

        // Step Three: Replace Assert.fail("Test not implemented.")
        // Assert.fail("Test not implemented.");

        // Arrange - instantiate a new Sale object for Madge
        Sale newSale = new Sale();
        newSale.setTotal(new BigDecimal("34.56"));
        newSale.setDelivery(true);
        newSale.setCustomerId(MADGE_CUSTOMER_ID);

        // Act - create sale from instantiated Sale object
        Sale createdSale = jdbcSaleDao.createSale(newSale);

        // Assert - created sale is correct
        Assert.assertNotEquals("saleId not set when created, remained 0", 0, createdSale.getSaleId());
        Assert.assertEquals(newSale.getTotal(), createdSale.getTotal());
        Assert.assertEquals(newSale.isDelivery(), createdSale.isDelivery());
        Assert.assertEquals(newSale.getCustomerId(), createdSale.getCustomerId());
    }

    @Test
    public void updateSale_has_expected_values_when_retrieved() {

        // Step Four: Replace Assert.fail("Test not implemented.")
        // Assert.fail("Test not implemented.");

        // Arrange - retrieve Madge's first sale and change values
        Sale saleToUpdate = jdbcSaleDao.getSale(MADGE_FIRST_SALE_ID);
        saleToUpdate.setTotal(new BigDecimal("89.32"));
        saleToUpdate.setDelivery(false);

        // Act - update the existing sale with changed values and re-retrieve
        jdbcSaleDao.updateSale(saleToUpdate);
        Sale updatedSale = jdbcSaleDao.getSale(MADGE_FIRST_SALE_ID);

        // Assert - sale has been updated correctly
        assertSalesMatch("Updated Madge's first sale returned wrong or partial data", saleToUpdate, updatedSale);
    }

    @Test
    public void deleted_sale_cant_be_retrieved() {

        // Step Five: Replace Assert.fail("Test not implemented.")
        // Assert.fail("Test not implemented.");

        // Act - delete existing first sale for Madge
        jdbcSaleDao.deleteSale(MADGE_FIRST_SALE_ID);

        // Assert - Madge's deleted sale can't be retrieved
        Sale sale = jdbcSaleDao.getSale(MADGE_FIRST_SALE_ID);
        Assert.assertNull(sale);
    }

    // Convenience method in lieu of a Sale constructor with all the fields as parameters.
    // Similar to mapRowToSale() in JdbcSaleDao.
    private static Sale mapValuesToSale(int saleId, BigDecimal total, boolean delivery, Integer customerId) {

        Sale sale = new Sale();
        sale.setSaleId(saleId);
        sale.setTotal(total);
        sale.setDelivery(delivery);
        sale.setCustomerId(customerId);
        return sale;
    }

    private void assertSalesMatch(String message, Sale expected, Sale actual) {

        Assert.assertEquals(message, expected.getSaleId(), actual.getSaleId());
        Assert.assertEquals(message, expected.getTotal(), actual.getTotal());
        Assert.assertEquals(message, expected.isDelivery(), actual.isDelivery());
        Assert.assertEquals(message, expected.getCustomerId(), actual.getCustomerId());
    }
}
