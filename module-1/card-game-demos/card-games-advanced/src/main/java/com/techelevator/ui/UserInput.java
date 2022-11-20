package com.techelevator.ui;

import com.techelevator.ui.enumerations.BlackJackPlay;

import java.util.Scanner;

public class UserInput 
{
    private final static Scanner scanner = new Scanner(System.in);

    public static BlackJackPlay homeScreen()
    {
        UserOutput.clear();
        UserOutput.printHeader("Let's play some Black Jack!");
        while(true)
        {
            System.out.println();
            System.out.println("What do you want to do?");
            System.out.println("[P] Play");
            System.out.println("[Q] Quit");
            System.out.println();
            System.out.print("Select an option: ");

            String input = scanner.nextLine()
                                  .trim()
                                  .toLowerCase();

            if ("p".equals(input))
            {
                return BlackJackPlay.Play;
            }
            else if ("q".equals(input))
            {
                return BlackJackPlay.Quit;
            }
            else
            {
                System.out.println("You must select a valid option (P/Q)");
            }
        }
    }
    
    public static BlackJackPlay hitOrStay()
    {
        while(true)
        {
            System.out.println();
            System.out.println("What do you want to do?");
            System.out.println("[H] Hit");
            System.out.println("[S] Stay");
            System.out.println();
            System.out.print("Select an option: ");

            String input = scanner.nextLine()
                                  .trim()
                                  .toLowerCase();

            if ("h".equals(input))
            {
                return BlackJackPlay.Hit;
            }
            else if ("s".equals(input))
            {
                return BlackJackPlay.Stay;
            }
            else
            {
                System.out.println("You must select a valid option (H/S)");
            }
        }

    }

    public static int numberOfPlayers()
    {
        System.out.println();
        System.out.print("How many players? ");

        String input = scanner.nextLine().trim();
        return Integer.parseInt(input);
    }

	public static String getPlayerName()
	{
        System.out.println();
        System.out.print("Please enter your name: ");

        return scanner.nextLine();
	}

    public static void waitForInput()
    {
        System.out.print("Press ENTER to continue...");
        scanner.nextLine();
    }
}
