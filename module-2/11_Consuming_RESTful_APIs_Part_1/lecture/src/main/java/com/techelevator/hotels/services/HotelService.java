package com.techelevator.hotels.services;

import com.techelevator.hotels.model.City;
import com.techelevator.hotels.model.Hotel;
import com.techelevator.hotels.model.Review;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

// dao that knows how to use RestTemplate
public class HotelService {

    // RestTemplate requires base url
    private static final String API_BASE_URL = "http://localhost:3000/";

    // similar to JdbcTemplate
    private final RestTemplate restTemplate = new RestTemplate();

    public Hotel[] listHotels() {

        // step 1. create url
        String url = API_BASE_URL+"hotels";


//        getForObject returns the body of the response
//        getForEntity returns the entire response (header & body)

//        try {
//            // getForEntity = gets the entire response back (head + body)
//            ResponseEntity<Hotel[]> response = restTemplate.getForEntity(url, Hotel[].class);
//
//            // if status = 200 OK, then return the body of the response
//            if (response.getStatusCode() == HttpStatus.OK) {
//                return response.getBody();
//            }
//
//        } catch (Exception e) {
//
//        };

        // getForObject = requesting an object back that is an array of hotels
        // requires 1 - URL & 2 - template
        // Hotel[].class = template of the object requested to deserialize to
        Hotel[] hotels = restTemplate.getForObject(url, Hotel[].class);
        return hotels;

    }

    public Review[] listReviews() {

        // address & binding = url
        String url = API_BASE_URL+"reviews";

        // contract = Review[]
        Review[] reviews = restTemplate.getForObject(url, Review[].class);
        return reviews;
    }

    public Hotel getHotelById(int id) {

        String url = API_BASE_URL+"hotels/"+id;

        Hotel hotel = restTemplate.getForObject(url, Hotel.class);
        return hotel;
    }

    public Review[] getReviewsByHotelId(int hotelID) {

        String url = API_BASE_URL+"reviews?hotelID="+hotelID;

        Review[] reviews = restTemplate.getForObject(url, Review[].class);
        return reviews;
    }

    public Hotel[] getHotelsByStarRating(int stars) {

        String url = API_BASE_URL+"hotels?stars="+stars;

        Hotel[] hotels = restTemplate.getForObject(url, Hotel[].class);
        return hotels;

    }

    public City getWithCustomQuery(){
        return null;
    }

}
