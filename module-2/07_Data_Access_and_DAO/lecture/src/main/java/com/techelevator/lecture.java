package com.techelevator;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class lecture {
    public static void main(String[] args) {


        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:postgresql://localhost:5432/UnitedStates");
        // bad practice to hardcode username / password irl!
        dataSource.setUsername("postgres");
        dataSource.setPassword("postgres1");

        // JdbcTemplate - part of Spring JDBC
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        try {

            // 2. execute query
            String sql = "SELECT city_id " +
                    "   , city_name " +
                    "   , state_abbreviation " +
                    "   , population " +
                    "   , area " +
                    "FROM city;";

            SqlRowSet row = jdbcTemplate.queryForRowSet(sql);

            // 3. loop through and use the data
            // (forward-only read-only stream)
            // like while scanner.hasNext()
            while (row.next()) {
                int cityId = row.getInt("city_id");
                String cityName = row.getString("city_name");
                String stateAbbreviation = row.getString("state_abbreviation");
                long population = row.getLong("population");
                double area = row.getDouble("area");

                System.out.println(cityId + " " + cityName + ", " + stateAbbreviation);
            }
            // use disconnected architecture
            // - connect, get data, disconnect
            // -- if we need to make changes, we manipulate data the way we need, connect and update, disconnect

        } catch(Exception e) {
            System.out.println("An error has occurred: " + e.getMessage());
        }
    }
}
