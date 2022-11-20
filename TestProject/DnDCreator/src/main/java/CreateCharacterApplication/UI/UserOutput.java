package CreateCharacterApplication.UI;

import java.lang.invoke.SwitchPoint;

public class UserOutput {

    public void printGetName(){
        System.out.println("Please enter a character name: ");
    }

    public void printGetAge(String name){
        System.out.println("How old is " + name + "?");
    }

    public void printRaceOptions(){
        System.out.println("  1) Dragonborn");
        System.out.println("  2) Dwarf");
        System.out.println("  3) Elf");
        System.out.println("  4) Gnome");
        System.out.println("  5) Halfling");
        System.out.println("  6) Human");
        System.out.println("  7) Orc");
        System.out.println("  8) Tiefling");
    }

    public void printSubRaceOptions(int option){

        switch (option){
            case 1:
                return;
            case 2:
                printDwarfOptions();
            case 3:
                printElfOptions();
            case 4:
                printGnomeOptions();
            case 5:
                printHalflingOptions();
            case 6:
                return;
            case 7:
                printOrcOptions();
            case 8:
                return;
            default:
                printRaceOptions();
        }

    }

    public void printDwarfOptions(){
        System.out.println("  0) GO BACK");
        System.out.println();
        System.out.println("  1) Hill Dwarf");
        System.out.println("  2) Mountain Dwarf");
    }

    public void printElfOptions(){
        System.out.println("  0) GO BACK");
        System.out.println();
        System.out.println("  1) Drow");
        System.out.println("  2) Half-Elf");
        System.out.println("  3) High Elf");
        System.out.println("  4) Wood Elf");
    }

    public void printGnomeOptions(){
        System.out.println("  0) GO BACK");
        System.out.println();
        System.out.println("  1) Forest Gnome");
        System.out.println("  2) Rock Gnome");
    }

    public void printHalflingOptions(){
        System.out.println("  0) GO BACK");
        System.out.println();
        System.out.println("  1) Lightfoot Halfling");
        System.out.println("  2) Stout Halfling");
    }

    public void printOrcOptions(){
        System.out.println("  0) GO BACK");
        System.out.println();
        System.out.println("  1) Half-Orc");
    }

    public void printClassOptions(){
        System.out.println("  0) GO BACK");
        System.out.println();
        System.out.println("  1) Barbarian");
        System.out.println("  2) Bard");
        System.out.println("  3) Cleric");
        System.out.println("  4) Druid");
        System.out.println("  5) Fighter");
        System.out.println("  6) Monk");
        System.out.println("  7) Paladin");
        System.out.println("  8) Ranger");
        System.out.println("  9) Rogue");
        System.out.println(" 10) Sorcerer");
        System.out.println(" 11) Warlock");
        System.out.println(" 12) Wizard");
    }

    public void printSwordDivider(){
        System.out.println("        {{0}}");
        System.out.println("  ,,,,,,||O||******************************************************\\");
        System.out.println(" '~~~~~~||O||%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%/");
        System.out.println("        {{O}}");
    }

    public void printSwordDividerReversed(){
        System.out.println("                                                        {{0}}");
        System.out.println("  /*****************************************************||O||.......");
        System.out.println("  \\&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&||O||~~~~~~~'");
        System.out.println("                                                        {{O}}");
    }

    public void printBowDivider(){
        System.out.println("           ,.**@@@**.,_                                 _,.**@@@**.,");
        System.out.println("         {{{*       ''**@@@*.,                   ,.*@@@**''       *}}}");
        System.out.println("      ,))'              ''**@@@*.#############.*@@@**''              '((,");
        System.out.println(" .<<//'_________________________________________________________________'\\\\>>. ");
    }

    public void printLineDividerOne(){
        System.out.println("  <*<<*<<<*>>>*>>*>*<*<<*<<<*>>>*>>*>*<*<<*<<<*>>>*>>*>");
    }





}
