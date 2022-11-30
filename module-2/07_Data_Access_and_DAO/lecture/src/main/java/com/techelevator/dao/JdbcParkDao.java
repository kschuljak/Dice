package com.techelevator.dao;

import com.techelevator.model.Park;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class JdbcParkDao implements ParkDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcParkDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Park getPark(int parkId) {

        Park park = null;

        String sql = "SELECT p.park_id " +
                "   , p.park_name " +
                "   , p.date_established " +
                "   , p.area " +
                "   , p.has_camping " +
                "FROM park AS p " +
                "INNER JOIN park_state AS ps " +
                "   ON p.park_id = ps.park_id " +
                " WHERE park_id = ?;";

        SqlRowSet row = jdbcTemplate.queryForRowSet(sql, parkId);

        if (row.next())

            park = mapRowToPark(row);

        return park;
    }

    @Override
    public List<Park> getParksByState(String stateAbbreviation) {

        List<Park> parks = new ArrayList<>();

        String sql = "SELECT p.park_id " +
                    "   , p.park_name " +
                    "   , p.date_established " +
                    "   , p.area " +
                    "   , p.has_camping " +
                    "FROM park AS p " +
                    "INNER JOIN park_state AS ps " +
                    "   ON p.park_id = ps.park_id " +
                    " WHERE state_abbreviation = ?;";

        SqlRowSet row = jdbcTemplate.queryForRowSet(sql, stateAbbreviation);

        while (row.next())
        {
            Park park = mapRowToPark(row);
            parks.add(park);
        }
        return parks;
    }

    @Override
    public Park createPark(Park park) {

        String sql = "INSERT INTO park (park_name, date_established, area, has_camping " +
                    "VALUES (?,?,?,?) RETURNING park_id;";

        //  when returning a value, you have to query an object instead of update
        // 1st arg = query
        // 2nd arg = expected data type
        Integer id = (Integer)jdbcTemplate.queryForObject(
                sql,
                Integer.class,
                park.getParkName(),
                park.getDateEstablished(),
                park.getArea(),
                park.getHasCamping()
        );

        park.setParkId(id);

        return park;
    }

    @Override
    public void updatePark(Park park) {

    }

    @Override
    public void deletePark(int parkId) {

    }

    @Override
    public void addParkToState(int parkId, String stateAbbreviation) {

    }

    @Override
    public void removeParkFromState(int parkId, String stateAbbreviation) {

    }

    private Park mapRowToPark(SqlRowSet row) {

        int parkId = row.getInt("park_id");
        String parkName = row.getString("park_name");
        // set as sql Date and then translate into LocalDate later if not null
        Date dateEstablished = row.getDate("date_established");
        double area = row.getDouble("area");
        boolean hasCamping = row.getBoolean("has_camping");

        Park park = new Park();
        park.setParkId(parkId);
        park.setParkName(parkName);
        if(dateEstablished != null){
            park.setDateEstablished(dateEstablished.toLocalDate());
        }
        park.setArea(area);
        park.setHasCamping(hasCamping);

        return park;
    }
}
