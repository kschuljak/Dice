package com.techelevator.locations.dao;

import com.techelevator.locations.model.Location;
import java.util.List;

public interface LocationDao {

    List<Location> list();

    Location get(int id);

    Location create(Location location);

    Location update(Location location, int id);

    void delete(int id);

}
