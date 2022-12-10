package CreateCharacterApplication;

import CharacterSheet.CharacterSheet;
import CreateCharacterApplication.UI.UserInput;
import CreateCharacterApplication.UI.UserOutput;

public class CreateCharacterApplication {

    public void run(){

        CharacterSheet character = new CharacterSheet();
        UserOutput out = new UserOutput();
        UserInput in = new UserInput();

        while (character.getCharacterName() == null) {

            out.printGetName();
            String name = in.getInput();
            character.setCharacterName(name);


        }

        System.out.print("Character name set! = " + character.getCharacterName());

    }

}
