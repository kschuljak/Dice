package com.techelevator.auctions.services;

import com.techelevator.util.BasicLogger;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import com.techelevator.auctions.model.Auction;

public class AuctionService {

    public static String API_BASE_URL = "http://localhost:3000/auctions/";
    private RestTemplate restTemplate = new RestTemplate();


    public Auction add(Auction newAuction) {

        HttpEntity<Auction> entity = makeEntity(newAuction);

        Auction auction = null;
        try {
            auction = restTemplate.postForObject(API_BASE_URL, entity, Auction.class);
        } catch (RestClientResponseException ex) {
            BasicLogger.log("[add] Rest Client Response Exception: " + ex.getRawStatusCode() + ": " + ex.getStatusText());
        } catch (ResourceAccessException ex) {
            BasicLogger.log("[add] Resource Access Exception: " + ex.getMessage());
        } catch (Exception ex) {
            BasicLogger.log("[add] Generic Exception: " + ex.getMessage());
        }
        return auction;
    }


    public boolean update(Auction updatedAuction) {

        HttpEntity<Auction> entity = makeEntity(updatedAuction);

        String url = API_BASE_URL + updatedAuction.getId();

        boolean isUpdated = false;
        try {
            restTemplate.put(url, entity, Auction.class);
            isUpdated = true;
        } catch (RestClientResponseException ex) {
            BasicLogger.log("[update] Rest Client Response Exception: " + ex.getRawStatusCode() + ": " + ex.getStatusText());
        } catch (ResourceAccessException ex) {
            BasicLogger.log("[update] Resource Access Exception: " + ex.getMessage());
        } catch (Exception ex) {
            BasicLogger.log("[update] Generic Exception: " + ex.getMessage());
        }
        return isUpdated;
    }

    public boolean delete(int auctionId) {

        String url = API_BASE_URL + auctionId;

        boolean isDeleted = false;
        try {
            restTemplate.delete(url);
            isDeleted = true;
        } catch (RestClientResponseException ex) {
            BasicLogger.log("[delete] Rest Client Response Exception: " + ex.getRawStatusCode() + ": " + ex.getStatusText());
        } catch (ResourceAccessException ex) {
            BasicLogger.log("[delete] Resource Access Exception: " + ex.getMessage());
        } catch (Exception ex) {
            BasicLogger.log("[delete] Generic Exception: " + ex.getMessage());
        }
        return isDeleted;
    }

    public Auction[] getAllAuctions() {
        Auction[] auctions = null;
        try {
            auctions = restTemplate.getForObject(API_BASE_URL, Auction[].class);
        } catch (RestClientResponseException e) {
            BasicLogger.log(e.getRawStatusCode() + " : " + e.getStatusText());
        } catch (ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
        }
        return auctions;
    }

    public Auction getAuction(int id) {
        Auction auction = null;
        try {
            auction = restTemplate.getForObject(API_BASE_URL + id, Auction.class);
        } catch (RestClientResponseException e) {
            BasicLogger.log(e.getRawStatusCode() + " : " + e.getStatusText());
        } catch (ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
        }
        return auction;
    }

    public Auction[] getAuctionsMatchingTitle(String title) {
        Auction[] auctions = null;
        try {
            auctions = restTemplate.getForObject(API_BASE_URL + "?title_like=" + title, Auction[].class);
        } catch (RestClientResponseException e) {
            BasicLogger.log(e.getRawStatusCode() + " : " + e.getStatusText());
        } catch (ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
        }
        return auctions;
    }

    public Auction[] getAuctionsAtOrBelowPrice(double price) {
        Auction[] auctions = null;
        try {
            auctions = restTemplate.getForObject(API_BASE_URL + "?currentBid_lte=" + price, Auction[].class);
        } catch (RestClientResponseException e) {
            BasicLogger.log(e.getRawStatusCode() + " : " + e.getStatusText());
        } catch (ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
        }
        return auctions;
    }

    private HttpEntity<Auction> makeEntity(Auction auction) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new HttpEntity<>(auction, headers);
    }

}
