package com.techelevator.services;

import org.springframework.stereotype.Component;

import com.techelevator.model.CatFact;
import org.springframework.web.client.RestTemplate;

@Component
public class RestCatFactService implements CatFactService {


	private static final String API_URL = "https://cat-data.netlify.app/api/facts/random";
	private final RestTemplate restTemplate = new RestTemplate();


	@Override
	public CatFact getFact() {
		CatFact response = restTemplate.getForObject(API_URL, CatFact.class);
		return response;
	}

}
