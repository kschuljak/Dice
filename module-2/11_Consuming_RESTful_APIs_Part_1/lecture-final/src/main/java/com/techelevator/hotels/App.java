package com.techelevator.hotels;

import com.techelevator.hotels.model.City;
import com.techelevator.hotels.model.Hotel;
import com.techelevator.hotels.model.Review;
import com.techelevator.hotels.services.ConsoleService;
import com.techelevator.hotels.services.HotelService;

public class App {

    private final ConsoleService consoleService = new ConsoleService();
    private final HotelService hotelService = new HotelService();

    public static void main(String[] args) {
        App app = new App();
        app.run();
    }

    private void run() {
        int menuSelection = -1;

        while (menuSelection != 0) {
            consoleService.printMainMenu();
            menuSelection = consoleService.promptForMenuSelection();
            if (menuSelection == 1)
            {
                Hotel[] hotels = hotelService.listHotels();
                consoleService.printHotels(hotels);
            }
            else if (menuSelection == 2)
            {
                Review[] reviews = hotelService.listReviews();
                consoleService.printReviews(reviews);
            }
            else if (menuSelection == 3)
            {
                Hotel hotel = hotelService.getHotelById(1);
                consoleService.printHotel(hotel);

            }
            else if (menuSelection == 4)
            {
                Review[] reviews = hotelService.getReviewsByHotelId(1);
                consoleService.printReviews(reviews);
            }
            else if (menuSelection == 5)
            {
                Hotel[] hotels = hotelService.getHotelsByStarRating(3);
                consoleService.printHotels(hotels);
            }
            else if (menuSelection == 6)
            {
                City city = hotelService.getWithCustomQuery();
                System.out.println(city);
            }
            else if (menuSelection == 0) {
                continue;
            } else {
                System.out.println("Invalid Selection");
            }
            consoleService.pause();
        }
    }

}
