package com.techelevator;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FindAndReplace {

    public static void main(String[] args) {
        replaceWord();
    }

    public static void replaceWord(){
        Scanner userInput = new Scanner(System.in);

        System.out.print("What is the search word? ");
        String searchWord = userInput.nextLine();

        System.out.println();
        System.out.print("What is the replacement word? ");
        String replacementWord = userInput.nextLine();

        System.out.println();
        System.out.print("What is the source file? ");
        String sourceFile = userInput.nextLine();

        System.out.println();
        System.out.print("What is the destination file? ");
        String destinationFile = userInput.nextLine();

        File readFrom = new File(sourceFile);
        File writeTo = new File(destinationFile);

        try (Scanner reader = new Scanner(readFrom);
             PrintWriter writer = new PrintWriter(writeTo)){

            while (reader.hasNextLine()) {
                String readLine = reader.nextLine();
                String writeLine = readLine.replaceAll(searchWord, replacementWord);
                writer.println(writeLine);
            }

        } catch (IOException ex) {
            System.out.println("Error- I/O Exception");
        }

    }

}
