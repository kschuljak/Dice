package com.techelevator;

import java.util.Scanner;

public class Loops {

    public static void main(String[] args) {
            Scanner input = new Scanner(System.in);
            String goAgain = "y";

//            do {
//                    System.out.print("Do you want to go again? ");
//                    goAgain= input.nextLine();
//
//            } while (goAgain.equalsIgnoreCase("Y"));

            while (goAgain.equalsIgnoreCase("Y")) {
                System.out.print("Do you want to go again? ");
                goAgain= input.nextLine();
            }

            System.out.println("Goodbye!!!");

    }
}
