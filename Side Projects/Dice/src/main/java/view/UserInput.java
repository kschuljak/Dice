package view;

import java.util.Scanner;

public class UserInput {

    private static Scanner scanner = new Scanner(System.in);

    public static String getInput() {
        String input = scanner.nextLine().strip();
        return input;
    }
}
