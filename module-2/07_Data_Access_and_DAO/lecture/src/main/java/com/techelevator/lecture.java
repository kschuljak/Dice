package com.techelevator;

import com.techelevator.model.City;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.util.ArrayList;
import java.util.List;

public class lecture {
    public static void main(String[] args) {


        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:postgresql://localhost:5432/UnitedStates");
        // bad practice to hardcode username / password irl!
        dataSource.setUsername("postgres");
        dataSource.setPassword("postgres1");

        // JdbcTemplate - part of Spring JDBC
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        // list of city objects created while reading data below
        List<City> cities = new ArrayList<>();

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
                int population = row.getInt("population");
                double area = row.getDouble("area");

                City city = new City();
                city.setCityId(cityId);
                city.setCityName(cityName);
                city.setStateAbbreviation(stateAbbreviation);
                city.setPopulation(population);
                city.setArea(area);

                // add newly created city object to array list of city objects created above
                cities.add(city);

                System.out.println(cityId + " " + cityName + ", " + stateAbbreviation);
            }
            // use disconnected architecture
            // - connect, get data, disconnect
            // -- if we need to make changes, we manipulate data the way we need, connect and update, disconnect

        } catch(Exception e) {
            System.out.println("An error has occurred: " + e.getMessage());
        }

        // can now use list of city objects to get information even while disconnected from database
        for (City city : cities){
            System.out.println();
        }
    }
}
