package CharacterSheet;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class CreateCharacterFile {

    public static void CreateNewFile(String fileName) {

        String filePath = "PrintedCharacterSheets/" + fileName + ".txt";
        File file = new File(filePath);

        if (file.exists()) System.out.print("File already exists.");

        else try(PrintWriter writer = new PrintWriter(file)) {

        } catch (IOException ex) {
            System.out.print("I/O ERROR - Please Try Again.");
        }
    }
}
