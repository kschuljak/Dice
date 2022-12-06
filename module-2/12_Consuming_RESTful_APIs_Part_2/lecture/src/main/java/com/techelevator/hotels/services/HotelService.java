package com.techelevator.hotels.services;

import com.techelevator.hotels.model.Hotel;
import com.techelevator.hotels.model.Reservation;
import com.techelevator.util.BasicLogger;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;


public class HotelService {

    private static final String API_BASE_URL = "http://localhost:3000/";
    // restTemplate is a serializer
    private final RestTemplate restTemplate = new RestTemplate();

    /**
     * Create a new reservation in the hotel reservation system
     */
    public Reservation addReservation(Reservation newReservation) {
        // specify content type
        // add headers and body
        // post

        // create header object in order to set content type to json
        // - in order to add ANY header info, we need an HttpHeaders object
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // create an entity with a body of type Reservation
        // pass in newReservation (body) and headers (header) information
        // HttpEntity<T> - specified data type used for us to verify we're passing the correct object type to serialize
        HttpEntity<Reservation> entity = new HttpEntity<>(newReservation, headers);

        String url = API_BASE_URL + "reservations";

        Reservation reservation = null;
        try {
            reservation = restTemplate.postForObject(url, entity, Reservation.class);
        } catch (RestClientResponseException ex) {
            // 400-599 range error
            BasicLogger.log("[addReservation] Rest Client Response Exception: " + ex.getRawStatusCode() + ": " + ex.getStatusText());
        } catch (ResourceAccessException ex) {
            // no server response
            BasicLogger.log("[addReservation] Resource Access Exception: " + ex.getMessage());
        } catch (Exception ex) {
            // generic error
            BasicLogger.log("[addReservation] Generic Exception: " + ex.getMessage());
        }
        return reservation;
    }

    /**
     * Updates an existing reservation by replacing the old one with a new
     * reservation
     */
    public boolean updateReservation(Reservation updatedReservation) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // entity - our request object
        HttpEntity<Reservation> entity = new HttpEntity<>(updatedReservation, headers);

        String url = API_BASE_URL + "reservations/" + updatedReservation.getId();

        boolean put_request_executed = false;
        try {
            // restTemplate.put does not return any data
            restTemplate.put(url, entity, Reservation.class);
            put_request_executed = true;
        } catch (RestClientResponseException ex) {
            // 400-599 range error
            BasicLogger.log("[updateReservation] Rest Client Response Exception: " + ex.getRawStatusCode() + ": " + ex.getStatusText());
        } catch (ResourceAccessException ex) {
            // no server response
            BasicLogger.log("[updateReservation] Resource Access Exception: " + ex.getMessage());
        } catch (Exception ex) {
            // generic error
            BasicLogger.log("[updateReservation] Generic Exception: " + ex.getMessage());
        }
        return put_request_executed;

    }

    /**
     * Delete an existing reservation
     */
    public boolean deleteReservation(int id) {

        String url = API_BASE_URL + "reservations/" + id;

        boolean delete_request_executed = false;
        try {
            restTemplate.delete(url);
            delete_request_executed = true;
        } catch (RestClientResponseException ex) {
            // 400-599 range error
            BasicLogger.log("[deleteReservation] Rest Client Response Exception: " + ex.getRawStatusCode() + ": " + ex.getStatusText());
        } catch (ResourceAccessException ex) {
            // no server response
            BasicLogger.log("[deleteReservation] Resource Access Exception: " + ex.getMessage());
        } catch (Exception ex) {
            // generic error
            BasicLogger.log("[deleteReservation] Generic Exception: " + ex.getMessage());
        }
        return delete_request_executed;
    }

    /* DON'T MODIFY ANY METHODS BELOW */

    /**
     * List all hotels in the system
     */
    public Hotel[] listHotels() {
        Hotel[] hotels = null;
        try {
            hotels = restTemplate.getForObject(API_BASE_URL + "hotels", Hotel[].class);
        } catch (RestClientResponseException e) {
            // handles exceptions thrown by rest template and contains status codes
            BasicLogger.log(e.getRawStatusCode() + " : " + e.getStatusText());
        } catch (ResourceAccessException e) {
            // i/o error, ex: the server isn't running
            BasicLogger.log(e.getMessage());
        }
        return hotels;
    }

    /**
     * List all reservations in the hotel reservation system
     */
    public Reservation[] listReservations() {
        Reservation[] reservations = null;
        try {
            reservations = restTemplate.getForObject(API_BASE_URL + "reservations", Reservation[].class);
        } catch (RestClientResponseException e) {
            BasicLogger.log(e.getRawStatusCode() + " : " + e.getStatusText());
        } catch (ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
        }
        return reservations;
    }

    /**
     * List all reservations by hotel id.
     */
    public Reservation[] listReservationsByHotel(int hotelId) {
        Reservation[] reservations = null;
        try {
            reservations = restTemplate.getForObject(API_BASE_URL + "hotels/" + hotelId + "/reservations", Reservation[].class);
        } catch (RestClientResponseException e) {
            BasicLogger.log(e.getRawStatusCode() + " : " + e.getStatusText());
        } catch (ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
        }
        return reservations;
    }

    /**
     * Find a single reservation by the reservationId
     */
    public Reservation getReservation(int reservationId) {
        Reservation reservation = null;
        try {
            reservation = restTemplate.getForObject(API_BASE_URL + "reservations/" + reservationId, Reservation.class);
        } catch (RestClientResponseException e) {
            BasicLogger.log(e.getRawStatusCode() + " : " + e.getStatusText());
        } catch (ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
        }
        return reservation;
    }

}
