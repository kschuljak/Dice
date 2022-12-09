package com.techelevator.swapi.controller;

import com.techelevator.swapi.services.SwapiService;
import com.techelevator.swapi.views.HomePage;

public class App {

    HomePage home = new HomePage();
    SwapiService service = new SwapiService();

    public void run()
    {
        while(true)
        {
            home.display();

        }
    }

    public void displayAllCharacters(){
        var characters = service.getAllCharacters();
    }

}
