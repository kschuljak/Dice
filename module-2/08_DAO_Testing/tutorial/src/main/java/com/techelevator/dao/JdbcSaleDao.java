package com.techelevator.dao;

import com.techelevator.model.Sale;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class JdbcSaleDao implements SaleDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcSaleDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Sale getSale(int saleId) {
        Sale sale = null;
        String sql = "SELECT sale_id, total, is_delivery, customer_id " +
                     "FROM sale " +
                     "WHERE sale_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, saleId);
        if (results.next()) {
            sale = mapRowToSale(results);
        }
        return sale;
    }

    @Override
    public List<Sale> getSalesByCustomerId(int customerId) {
        List<Sale> sales = new ArrayList<>();
        String sql = "SELECT sale_id, total, is_delivery, customer_id " +
                "FROM sale " +
                "WHERE customer_id = ? " +
                "ORDER BY sale_id;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, customerId);
        while (results.next()) {
            Sale sale = mapRowToSale(results);
            sales.add(sale);
        }
        return sales;
    }

    @Override
    public Sale createSale(Sale sale) {
        String sql = "INSERT INTO sale (total, is_delivery, customer_id) " +
                     "VALUES (?, ?, ?) RETURNING sale_id";
        Integer saleId =
                jdbcTemplate.queryForObject(sql, Integer.class, sale.getTotal(),
                        sale.isDelivery(), sale.getCustomerId());
        // Set the saleId attribute of the Sale object to the saleId returned.
        sale.setSaleId(saleId);
        return sale;
    }

    @Override
    public boolean updateSale(Sale sale) {
        String sql = "UPDATE sale SET total = ?, is_delivery = ?, customer_id = ? " +
                     "WHERE sale_id = ?;";
        int numberOfRows =
                jdbcTemplate.update(sql, sale.getTotal(), sale.isDelivery(), sale.getCustomerId(),
                        sale.getSaleId());
        return numberOfRows == 1;
    }

    @Override
    public void deleteSale(int saleId) {
        String sql = "DELETE FROM sale WHERE sale_id = ?;";
        jdbcTemplate.update(sql, saleId);
    }

    private Sale mapRowToSale(SqlRowSet rowSet) {
        Sale sale = new Sale();
        sale.setSaleId(rowSet.getInt("sale_id"));
        sale.setTotal(rowSet.getBigDecimal("total"));
        sale.setDelivery(rowSet.getBoolean("is_delivery"));
        sale.setCustomerId(rowSet.getInt("customer_id"));
        if (rowSet.wasNull()) {
            sale.setCustomerId(null);
        }
        return sale;
    }
}
