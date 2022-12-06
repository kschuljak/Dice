package com.techelevator.auctions.services;

import com.techelevator.auctions.model.Auction;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.*;

public class AuctionServiceTest {

    private static final Auction[] expectedAuctions = {new Auction(1, "Zero", "Zero Auction", "User0", 0.0),
            new Auction(2, "One", "One Auction", "User1", 1.1)};

    private static ProcessBuilder processBuilder;
    private static Process process;

    private static AuctionService sut;

    @BeforeClass
    public static void setup() {

        processBuilder = new ProcessBuilder();
        // Windows: node server\\node_modules\\json-server\\lib\\cli\\bin.js server\\data-test.js --port=3001
        // Linux:   node server/node_modules/json-server/lib/cli/bin.js server/data-test.js --port=3001
        String command = "node";
        String cli = "server" + File.separator + "node_modules" + File.separator + "json-server" +
                File.separator + "lib" + File.separator + "cli" + File.separator + "bin.js";
        String data = "server" + File.separator + "data-test.js";
        String port = "--port=3001";
        processBuilder.command(command, cli, data, port);
        try {
            process = processBuilder.start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        AuctionService.API_BASE_URL = "http://localhost:3001/auctions/";
        sut = new AuctionService();

        if (!pingServer(AuctionService.API_BASE_URL, 5, 500)) { // time-out after ~2.5 seconds
            throw new RuntimeException("Unable to connect to server: " + AuctionService.API_BASE_URL + System.lineSeparator() + "Make sure you've run `npm install` in the `server` folder and can run json-server.");
        }
    }

    @AfterClass
    public static void teardown() {

        process.destroyForcibly();
    }

    @Test
    public void add_should_handle_success_and_comm_failure() {

        String apiBaseURLHold = AuctionService.API_BASE_URL;               // Hold onto preset API base url
        try {

            // Successful add() should return the new auction
            Auction newAuction = new Auction(0, "a", "b", "c", 99.99);
            Auction actualAuction = sut.add(newAuction);
            assertNotNull("New auction returned is null.", actualAuction);
            assertTrue("New auction id is still 0.", actualAuction.getId() > 0);

            // Add() experiencing communication failure (ResourceAccessException) should return null
            AuctionService.API_BASE_URL = "http://localhost:3002/auctions/";   // Set failing API base url
            actualAuction = sut.add(new Auction());
            assertNull("add() did not return null after experiencing ResourceAccessException.",actualAuction);
        } finally {
            AuctionService.API_BASE_URL = apiBaseURLHold;  // Reestablish correct API base url
        }
    }

    @Test
    public void update_should_handle_success_client_failure_and_comm_failure() {

        String apiBaseURLHold = AuctionService.API_BASE_URL;               // Hold onto preset API base url
        try {

            // Successful update() should return true
            Auction updateAuction = new Auction(1, "q", "w", "e", 11.11);
            boolean result = sut.update(updateAuction);
            assertTrue("update() did not return true after successfully updating auction.", result);

            // Update client query error (RestClientResponseException) should return false
            updateAuction = new Auction(9, "q", "w", "e", 11.11); // Auction 9 does not exist.
            result = sut.update(updateAuction);
            assertFalse("update() did not return false after experiencing RestClientResponseException.", result);

            // update() experiencing communication failure (ResourceAccessException) should return false
            AuctionService.API_BASE_URL = "http://localhost:3002/auctions/";   // Set failing API base url
            updateAuction = new Auction(1, "r", "x", "f", 12.12);
            result = sut.update(updateAuction);
            assertFalse("update() did not return false after experiencing ResourceAccessException.", result);
        } finally {
            AuctionService.API_BASE_URL = apiBaseURLHold;  // Reestablish correct API base url
        }
    }

    @Test
    public void delete_should_handle_success_client_failure_and_comm_failure() {

        String apiBaseURLHold = AuctionService.API_BASE_URL;               // Hold onto preset API base url
        try {

            // Successful delete() should return true
            boolean result = sut.delete(2);
            assertTrue("delete() did not return true after successfully deleting auction.", result);

            // delete() client query error (RestClientResponseException) should return false
            result = sut.delete(2); // Auction 2 was deleted above
            assertFalse("delete() did not return false after experiencing RestClientResponseException.", result);

            // delete() experiencing communication failure (ResourceAccessException) should return false
            AuctionService.API_BASE_URL = "http://localhost:3002/auctions/";   // Set failing API base url
            result = sut.delete(1);
            assertFalse("delete() did not return false after experiencing ResourceAccessException.", result);
        } finally {
            AuctionService.API_BASE_URL = apiBaseURLHold;  // Reestablish correct API base url
        }
    }

    private HttpEntity<Auction> makeEntityHelper(Auction auction) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new HttpEntity<>(auction, headers);
    }

    private static boolean pingServer(String baseApiUrl, int maxTries, long waitInterval) {

        RestTemplate restTemplate = new RestTemplate();

        int tryCount = 0;
        while (tryCount < maxTries) {
            try {
                tryCount++;
                try {
                    restTemplate.headForHeaders(baseApiUrl);
                    return true;
                } catch (RestClientException e) {
                    // Just eat the exception and try the request again.
                }
                Thread.sleep(waitInterval);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        return  false;
    }
}
