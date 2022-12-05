package com.techelevator.hotels.services;

import com.techelevator.hotels.model.City;
import com.techelevator.hotels.model.Hotel;
import com.techelevator.hotels.model.Review;
import org.springframework.web.client.RestTemplate;

// dao that knows how to use RestTemplate
public class HotelService {

    // RestTemplate requires base url
    private static final String API_BASE_URL = "http://localhost:3000/";

    // similar to JdbcTemplate
    private final RestTemplate restTemplate = new RestTemplate();

    public Hotel[] listHotels() {

        // step 1. create url
        String url = API_BASE_URL+"hotels";

        // getForObject = requesting an object back that is an array of hotels
        // requires 1 - URL & 2 - template
        // Hotel[].class = template of the object requested to deserialize to
        Hotel[] hotels = restTemplate.getForObject(url, Hotel[].class);

        return hotels;
    }

    public Review[] listReviews() {
        return null;
    }

    public Hotel getHotelById(int id) {
        return null;
    }

    public Review[] getReviewsByHotelId(int hotelID) {
        return null;
    }

    public Hotel[] getHotelsByStarRating(int stars) {
        return null;
    }

    public City getWithCustomQuery(){
        return null;
    }

}
