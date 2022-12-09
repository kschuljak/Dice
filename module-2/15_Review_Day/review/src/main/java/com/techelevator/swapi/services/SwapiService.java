package com.techelevator.swapi.services;

import org.springframework.web.client.RestTemplate;


public class SwapiService {

    private static final String API_BASE_URL = "https://swapi.dev/api/";
    private final RestTemplate restTemplate = new RestTemplate();

}
