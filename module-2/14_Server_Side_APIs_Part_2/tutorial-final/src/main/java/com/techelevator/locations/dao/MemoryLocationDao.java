package com.techelevator.locations.dao;

import com.techelevator.locations.model.Location;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class MemoryLocationDao implements LocationDao {

    private List<Location> locations = new ArrayList<>();

    public MemoryLocationDao() {
    	initializeLocationData();
    }

    @Override
    public List<Location> list() {
        return Collections.unmodifiableList(locations);
    }

    @Override
    public Location get(int id) {
        for (Location location : locations) {
            if (location.getId() == id) {
                return location;
            }
        }

        return null;
    }

    @Override
    public Location create(Location location) {
        location.setId(getMaxIdPlusOne());
        locations.add(location);
        return location;
    }

    @Override
    public Location update(Location location, int id) {
        Location result = location;
        boolean finished = false;

        for (int i = 0; i < locations.size(); i++) {
            if (locations.get(i).getId() == id) {
                if (result.getId() == 0) {
                    result.setId(id);
                }
                locations.set(i, result);
                finished = true;
                break;
            }
        }
        if (!finished) {
            return null;
        }

        return result;
    }

    @Override
    public void delete(int id) {
        Location target = null;
        for (Location location : locations) {
            if (location.getId() == id) {
                target = location;
            }
        }
        // when using foreach we must remove the item after iterating to avoid a ConcurrentModificationException
        locations.remove(target);
    }

    private void initializeLocationData() {
        locations.add(new Location(1,
                "Baker Electric Building",
                "7100 Euclid Ave",
                "Cleveland",
                "OH",
                "44103"));
        locations.add(new Location(2,
                "Rev1 Ventures",
                "1275 Kinnear Rd",
                "Columbus",
                "OH",
                "43212"));
        locations.add(new Location(3,
                "HCDC Business Center",
                "1776 Mentor Ave",
                "Cincinnati",
                "OH",
                "45212"));
        locations.add(new Location(4,
                "House of Metal",
                "901 Pennsylvania Ave",
                "Pittsburgh",
                "PA",
                "15233"));
        locations.add(new Location(5,
                "TechTown Detroit",
                "440 Burroughs St",
                "Detroit",
                "MI",
                "48202"));
        locations.add(new Location(6,
                "Duane Morris Plaza",
                "30 S 17th St",
                "Philadelphia",
                "PA",
                "19103"));
    }

    /**
     * finds the max id in the list of locations and returns it
     *
     * @return int the max id
     */
    private int getMaxId() {
        int maxId = 0;
        for (Location Location : locations) {
            if (Location.getId() > maxId) {
                maxId = Location.getId();
            }
        }
        return maxId;
    }

    /**
     * Adds 1 to the max id and returns it
     *
     * @return
     */
    private int getMaxIdPlusOne() {
        return getMaxId() + 1;
    }

}
