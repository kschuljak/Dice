package com.techelevator;

import com.techelevator.models.Card;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CardGameCli
{
    public static void main(String[] args)
    {
        printAllCards();
    }

    public static String askUserForFile()
    {
        Scanner userInput = new Scanner(System.in);
        System.out.print("What deck do you want to load (face or uno)? ");

        String deck = userInput.nextLine().trim() + ".txt";
        return deck;
    }

    public static void printAllCards()
    {
        List<Card> cards = new ArrayList<>();
        // get file path
        String input = askUserForFile();
        File file = new File(input);

        // open the file
        try (Scanner fileReader = new Scanner(file.getAbsoluteFile()))
        {
            // loop through the file
            fileReader.nextLine(); // skip the first line
            while(fileReader.hasNextLine())
            {
                // do something with the contents
                String line = fileReader.nextLine();

                // split on pipe | - regex "\\|"
                // split on one or more spaces - regex = "\\s+"
                String[] columns = line.split("\\|");

                // create variables from the split
                String name = columns[0].trim();
                String face = columns[1].trim();
                int value = Integer.parseInt(columns[2].trim());
                String suit = columns[3].trim();

                // create card from input
                Card card = new Card();
                card.setName(name);
                card.setFace(face);
                card.setValue(value);
                card.setSuit(suit);

                cards.add(card);

                System.out.println(card.toString());
            }
        }
        catch(FileNotFoundException e)
        {
            System.out.println(input + " does not exist.");
        }

    }
}
