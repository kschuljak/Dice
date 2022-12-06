package com.techelevator.locations.services;

import com.techelevator.locations.model.Location;
import com.techelevator.util.BasicLogger;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

public class LocationService {

    private static final String API_BASE_URL = "http://localhost:3000/locations/";
    private final RestTemplate restTemplate = new RestTemplate();
    // RestTemplate throws a RestClientResponseException when an error response code is received
    // , or a ResourceAccessException when no response is received at all

    public Location add(Location newLocation) {

        // helper method 'makeEntity' - add a header to the POST request
        HttpEntity<Location> entity = makeEntity(newLocation);

        Location returnedLocation = null;

        try {
            // postForObject(1:url, 2:entity, 3:class used to construct the return object)
            returnedLocation = restTemplate.postForObject(API_BASE_URL, entity, Location.class);
        } catch (RestClientResponseException ex) {
            BasicLogger.log(ex.getRawStatusCode() + ": " + ex.getStatusText());
        } catch (ResourceAccessException ex) {
            BasicLogger.log(ex.getMessage());
        }
        return returnedLocation;
        // returnedLocation has the id that was assigned by the API when it was added to the datastore
    }

    public boolean update(Location updatedLocation) {
        // put method is passed an existing location modified by the user
        // , and returns a boolean value indicating if it was successful
        HttpEntity<Location> entity = makeEntity(updatedLocation);

        boolean success = false;
        try {
            // since RestTemplate.put() doesn't return anything, don't make an assignment statement
            restTemplate.put(API_BASE_URL + updatedLocation.getId(), entity);
            success = true;
        } catch (RestClientResponseException ex) {
            BasicLogger.log(ex.getRawStatusCode() + ": " + ex.getStatusText());
        } catch (ResourceAccessException ex) {
            BasicLogger.log(ex.getMessage());
        }
        return success;
    }

    public boolean delete(int id) {
        // send the id of the location to delete (not a complete Location object)
        restTemplate.delete(API_BASE_URL + id);
        return true;
    }

    public Location[] getAll() {
        Location[] locations = null;
        try {
            locations = restTemplate.getForObject(API_BASE_URL, Location[].class);
        } catch (RestClientResponseException e) {
            BasicLogger.log(e.getRawStatusCode() + " : " + e.getStatusText());
        } catch (ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
        }
        return locations;
    }

    public Location getOne(int id) {
        Location location = null;
        try {
            location = restTemplate.getForObject(API_BASE_URL + id, Location.class);
        } catch (RestClientResponseException e) {
            BasicLogger.log(e.getRawStatusCode() + " : " + e.getStatusText());
        } catch (ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
        }
        return location;
    }

    private HttpEntity<Location> makeEntity(Location location){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new HttpEntity<>(location, headers);
    }

}
