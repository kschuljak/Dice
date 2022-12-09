package com.techelevator.swapi.services;

import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;


public class SwapiService {

    private static final String API_BASE_URL = "https://swapi.dev/api/";
    private final RestTemplate restTemplate = new RestTemplate();

    public List<Character> getAllCharacters()
    {
        List<Character> characters = new ArrayList<>();

        String url = API_BASE_URL + "people";

        CharacterResponse response = restTemplate.getForObject(url, CharacterResponse.class);

        characters = Arrays.asList(response.getResult());

        return characters;
    }

}
