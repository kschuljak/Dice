package com.techelevator;

import javax.sound.midi.Soundbank;
import java.util.Scanner;

public class Review {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the first word: ");
        String one = input.nextLine();
        System.out.print("Enter the second word: ");
        String two = input.nextLine();

        System.out.println("The words are equal: " + areEqual(one, two));

        char a = 'a';
        String b = "many letters";

    }

    public static boolean areEqual(String a, String b)
    {
        return a.equalsIgnoreCase(b);
    }
}
