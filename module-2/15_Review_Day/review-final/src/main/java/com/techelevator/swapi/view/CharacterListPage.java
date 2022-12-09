package com.techelevator.swapi.view;

import com.techelevator.swapi.model.Character;

import java.util.List;

public class CharacterListPage extends ViewBase<String>
{
    private List<Character> characters;

    public void setCharacters(List<Character> characters)
    {
        this.characters = characters;
    }

    @Override
    public void display()
    {
        displayHeader("Characters");

        // loop through all characters
        for (Character character : characters)
        {
            System.out.println(character.getId() + ") " + character.getName());
        }
    }
}
