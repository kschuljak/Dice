package com.techelevator;

import com.techelevator.model.City;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.util.ArrayList;
import java.util.List;

public class SqlDemo
{
    public static void main(String[] args)
    {
        // 1. data source - vanilla JDBC
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:postgresql://localhost:5432/UnitedStates");
        dataSource.setUsername("postgres");
        dataSource.setPassword("postgres1");

        // JdbcTemplate - part of Spring JDBC
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        List<City> cities = new ArrayList<>();

        try
        {
            // 2. Execute the query
            String sql = "SELECT city_id " +
                    "   , city_name " +
                    "   , state_abbreviation " +
                    "   , population " +
                    "   , area " +
                    "FROM city;";

            SqlRowSet row = jdbcTemplate.queryForRowSet(sql);

            // 3. loop through and use the data
            while (row.next())
            {
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

                cities.add(city);
            }
        }
        catch (Exception e)
        {
            System.out.println("An error has occurred: " + e.getMessage());
        }

        for (City city : cities)
        {
            System.out.println(city);
        }


    }
}
