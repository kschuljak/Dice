package com.techelevator;

import java.util.Scanner;

public class Loops {
    public static void main(String[] args) {

        int counter = 0;

        // DANGER!!!! INFINITE LOOP
        // while (counter < 20) {   System.out.println(counter);   }
        // will output infinite 0's
        // there is no increment for counter so statement will always evaluate as true


        // ***** WHILE *****
        // while loop - outputs 0 through 19
        // useful if you don't know how many times the loop will need to execute
        while (counter < 20) {
            System.out.println(counter);
            counter++;
        }


        // ***** FOR *****
        // for loop - outputs 0 through 19
        for (int i = 0; i < 20; i++) System.out.println(i);


        // ***** DO - WHILE *****
        // do-while loops guarantee that the code will execute at least once
        // (don't forget 'DO' statement, otherwise you will get an infinite loop of nothing!)
        Scanner input = new Scanner(System.in);
        String goAgain;
        do {
            System.out.println("Do you want to go again?");
            goAgain = input.nextLine();
        } while (goAgain.equalsIgnoreCase("Y"));

    }
}
