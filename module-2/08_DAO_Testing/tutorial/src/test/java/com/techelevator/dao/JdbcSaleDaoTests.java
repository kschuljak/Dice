package com.techelevator.dao;

import com.techelevator.model.Sale;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

public class JdbcSaleDaoTests extends BaseDaoTests {

    // Step One: Add constants for Madge

    // Step Two: Add constants for customer without sale and non-existent customer

    private JdbcSaleDao jdbcSaleDao;

    @Before
    public void setup() {

        // Arrange - new instance of JdbcSaleDao before each and every test
        jdbcSaleDao = new JdbcSaleDao(dataSource);
    }

    @Test
    public void getSale_returns_correct_sale_for_id() {

        // Step One: Replace Assert.fail("Test not implemented.")
        Assert.fail("Test not implemented.");
    }

    @Test
    public void getSalesByCustomerId_returns_sales_for_customer_id() {

        // Step Two: Replace Assert.fail("Test not implemented.")
        Assert.fail("Test not implemented.");
    }

    @Test
    public void createSale_returns_sale_with_id_and_expected_values() {

        // Step Three: Replace Assert.fail("Test not implemented.")
        Assert.fail("Test not implemented.");
    }

    @Test
    public void updateSale_has_expected_values_when_retrieved() {

        // Step Four: Replace Assert.fail("Test not implemented.")
        Assert.fail("Test not implemented.");
    }

    @Test
    public void deleted_sale_cant_be_retrieved() {

        // Step Five: Replace Assert.fail("Test not implemented.")
        Assert.fail("Test not implemented.");
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
