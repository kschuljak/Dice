package com.techelevator;

import java.util.Scanner;

public class Tutorial {

    public static void main(String[] args) {

        // ***********  Step 1: Use the *new* operator to create Strings on the Heap  *************

        // create a new string from an array of characters (char array)
        char[] helloChars = new char[] {'h', 'e', 'l', 'l', 'o', '!'};
        String greeting = new String(helloChars);
        System.out.println("Greeting: " + greeting);

        // create a string by passing in a literal value (string literal)
        String salutation = new String("Welcome, my friend.");
        System.out.println("Salutation: " + salutation);

        // assign a string literal to a variable, skipping the 'new' operator
        // this is the most common method of creating a new string in Java
        String toast = "May the compiler rise up to meet you.";
        System.out.println("Toast: " + toast);


        // ***********  Step 2: Try out some String methods  *************


        // prompt the user to enter a sentence
        System.out.print("Please type a sentence: ");
        Scanner scanner = new Scanner(System.in);
        String sentence = scanner.nextLine();

        // print the sentence back to the user
        System.out.println(sentence);

        // print the sentence in all upper-case
        String uppercaseSentence = sentence.toUpperCase();
        System.out.println(uppercaseSentence);

        // print the sentence in all lower case
        System.out.println(sentence.toLowerCase());

        // find the first space character (" ")
        int firstSpace = sentence.indexOf(" ");

        // print the length of the first word (or -1 if string not found)
        if (firstSpace == -1) {
            System.out.println("The first word is " + sentence.length() + " characters long.");
        } else {
            System.out.println("The first word is " + firstSpace + " characters long.");
        }

        // replace "the" with "the one and only"
        System.out.println(sentence.replace("the", "the one and only"));

        // create an array of strings using .split(" ")
        String[] words = sentence.split(" ");
        System.out.println("The words in this sentence: ");
        for (int i = 0; i < words.length; i++){
            System.out.println(words[i]);
        }

        // join string array back into a string, using a new delimiter
        String dashSentence = String.join("-->", words);
        System.out.println(dashSentence);

        // print original sentence
        System.out.println(sentence);


        // ***********  Step 3: Compare Strings  *************


        String secretWord = "Secret!";
        System.out.print("Enter the secret word (hint: it's '" + secretWord + "') ");
        String userSecretWord = scanner.nextLine();

        // use == to compare strings
        boolean matchEqualityOperator = secretWord == userSecretWord;
        System.out.println("Using '==': " + matchEqualityOperator);

        // use .equals() to compare strings
        boolean matchEquals = secretWord.equals(userSecretWord);
        System.out.println("Using '.equals(): " + matchEquals);

        // use .equalsIgnoreCase() to compare strings
        boolean matchEqualsIgnoreCase = secretWord.equalsIgnoreCase(userSecretWord);
        System.out.println("Using '.equalsIgnoreCase(): " + matchEqualsIgnoreCase);

    }
}
