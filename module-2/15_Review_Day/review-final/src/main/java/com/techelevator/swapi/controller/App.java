package com.techelevator.swapi.controller;

import com.techelevator.swapi.services.SwapiService;
import com.techelevator.swapi.view.CharacterListPage;
import com.techelevator.swapi.view.HomePage;

public class App {

    SwapiService service = new SwapiService();
    HomePage home = new HomePage();

    public void run()
    {
        while(true)
        {
            home.display();
            var selection = home.getValue();

            switch (selection)
            {
                case 1:
                    // display sw characters
                    displayAllCharacters();
                    break;
                case 2:
                    // display sw planets
                    break;
                case 0:
                    // say goodbye
                    return;
            }

        }
    }

    public void displayAllCharacters()
    {
        CharacterListPage page = new CharacterListPage();

        var characters = service.getAllCharacters();
        page.setCharacters(characters);
        page.display();
    }

}
