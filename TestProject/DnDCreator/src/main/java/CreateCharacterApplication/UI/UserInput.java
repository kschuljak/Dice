package CreateCharacterApplication.UI;

import java.util.Scanner;

public class UserInput {

    private  Scanner scanner = new Scanner(System.in);

    public  String getInput() {
        String input = scanner.nextLine().strip();
        return input;
    }

}
