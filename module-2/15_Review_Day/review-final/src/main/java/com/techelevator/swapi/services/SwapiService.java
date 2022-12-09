package com.techelevator.swapi.services;

import com.techelevator.swapi.model.Character;
import com.techelevator.swapi.model.CharacterResponse;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class SwapiService {

    private static final String API_BASE_URL = "https://swapi.dev/api/";
    private final RestTemplate restTemplate = new RestTemplate();

    public List<Character> getAllCharacters()
    {
        List<Character> characters = new ArrayList<>();

        String url = API_BASE_URL + "people";

        while(url != null)
        {
            CharacterResponse response = restTemplate.getForObject(url, CharacterResponse.class);

            var people = Arrays.asList(response.getResults());
            characters.addAll(people);

            url = response.getNext();
        }


        return characters;
    }

}
