package com.techelevator.dao;

import com.techelevator.model.Park;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class JdbcParkDao implements ParkDao
{
    private final JdbcTemplate jdbcTemplate;

    public JdbcParkDao(DataSource dataSource)
    {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Park getPark(int parkId)
    {
        Park park = null;

        // write the query
        String sql = "SELECT p.park_id " +
                "    , p.park_name " +
                "    , p.date_established " +
                "    , p.area " +
                "    , p.has_camping " +
                "FROM park as p " +
                "WHERE p.park_id = ?;";

        SqlRowSet row = jdbcTemplate.queryForRowSet(sql, parkId);

        if (row.next())
        {
            park = mapRowToPark(row);
        }

        return park;
    }

    @Override
    public List<Park> getParksByState(String stateAbbreviation)
    {
        List<Park> parks = new ArrayList<>();

        // write the query
        String sql = "SELECT p.park_id " +
                    "    , p.park_name " +
                    "    , p.date_established " +
                    "    , p.area " +
                    "    , p.has_camping " +
                    "FROM park as p " +
                    "INNER JOIN park_state as ps " +
                    "    ON p.park_id = ps.park_id " +
                    "WHERE state_abbreviation = ?;";

        SqlRowSet row = jdbcTemplate.queryForRowSet(sql, stateAbbreviation);

        while (row.next())
        {
            Park park = mapRowToPark(row);
            parks.add(park);
        }

        return parks;
    }

    @Override
    public Park createPark(Park park)
    {
        String sql = "INSERT INTO park (park_name, date_established, area, has_camping) " +
                     "VALUES (?,?,?,?) RETURNING park_id;";

        Integer id = jdbcTemplate.queryForObject(sql, // 1st argument is the query
                                                Integer.class, // 2nd argument must be the data type you are expecting
                                                park.getParkName(),
                                                park.getDateEstablished(),
                                                park.getArea(),
                                                park.getHasCamping());
        park.setParkId(id);

        return park;
    }

    @Override
    public void updatePark(Park park)
    {
        String sql = "UPDATE park " +
                    "SET park_name = ? " +
                    "   , date_established = ? " +
                    "   , area = ? " +
                    "   , has_camping = ?" +
                    "WHERE park_id = ? ";

        jdbcTemplate.update(sql,
                    park.getParkName(),
                    park.getDateEstablished(),
                    park.getArea(),
                    park.getHasCamping(),
                    park.getParkId());
    }

    @Override
    public void deletePark(int parkId)
    {
        String sql = "DELETE FROM park WHERE park_id = ?;";

        jdbcTemplate.update(sql, parkId);
    }

    @Override
    public void addParkToState(int parkId, String stateAbbreviation)
    {
        String sql = "INSERT INTO park_state (park_id, state_abbreviation)" +
                     "VALUES (?,?) ";

        jdbcTemplate.update(sql, parkId, stateAbbreviation);

    }

    @Override
    public void removeParkFromState(int parkId, String stateAbbreviation)
    {
        String sql = "DELETE FROM park_state " +
                     "WHERE park_id = ?" +
                     "   AND state_abbreviation = ?; ";

        jdbcTemplate.update(sql, parkId, stateAbbreviation);
    }

    private Park mapRowToPark(SqlRowSet row)
    {
        int parkId = row.getInt("park_id");
        String parkName = row.getString("park_name");
        Date dateEstablished = row.getDate("date_established");
        double area = row.getDouble("area");
        boolean hasCamping = row.getBoolean("has_camping");

        Park park = new Park();
        park.setParkId(parkId);
        park.setParkName(parkName);
        park.setArea(area);
        park.setHasCamping(hasCamping);
        if(dateEstablished != null)
        {
            park.setDateEstablished(dateEstablished.toLocalDate());
        }

        return park;
    }
}
