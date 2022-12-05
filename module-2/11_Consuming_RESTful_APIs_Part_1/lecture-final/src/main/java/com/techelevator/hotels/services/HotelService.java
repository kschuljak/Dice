package com.techelevator.hotels.services;

import com.techelevator.hotels.model.City;
import com.techelevator.hotels.model.Hotel;
import com.techelevator.hotels.model.Review;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class HotelService {

    private static final String API_BASE_URL = "http://localhost:3000/";
    private final RestTemplate restTemplate = new RestTemplate();

    public Hotel[] listHotels() {

        //1. create url
        String url = API_BASE_URL + "hotels";

//        try
//        {
//                // getForEntity returns the entire Response (header and body)
//            ResponseEntity<Hotel[]> response = restTemplate.getForEntity(url, Hotel[].class);
//
//            if (response.getStatusCode() == HttpStatus.OK)
//            {
//                return response.getBody();
//            }
//        }
//        catch (Exception e)
//        {
//
//        }

        try
        {
            // getForObject returns the BODY only
            // url, template to deserialize to
            Hotel[] hotels = restTemplate.getForObject(url, Hotel[].class);
        }
        catch(Exception e)
        {

        }

        return new Hotel[0];
    }

    public Review[] listReviews() {

        // url
        String url = API_BASE_URL + "reviews";

        Review[] reviews = restTemplate.getForObject(url, Review[].class);

        return reviews;
    }

    public Hotel getHotelById(int id) {

        String url = API_BASE_URL + "hotels/" + id;

        Hotel hotel = restTemplate.getForObject(url, Hotel.class);

        return hotel;
    }

    public Review[] getReviewsByHotelId(int hotelID) {

        String url = API_BASE_URL + "hotels/" + hotelID + "/reviews";

        Review[] reviews = restTemplate.getForObject(url, Review[].class);

        return reviews;
    }

    public Hotel[] getHotelsByStarRating(int stars) {

        String url = API_BASE_URL + "hotels?stars=" + stars;

        Hotel[] hotels = restTemplate.getForObject(url, Hotel[].class);

        return hotels;
    }

    public City getWithCustomQuery(){

        String url = "https://api.teleport.org/api/cities/geonameid:1275339/";

        City city = restTemplate.getForObject(url, City.class);

        return city;
    }

}
