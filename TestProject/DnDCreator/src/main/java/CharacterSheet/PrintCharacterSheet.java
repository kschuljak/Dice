package CharacterSheet;

import java.util.Map;

public class PrintCharacterSheet {

    public void printCharacter(CharacterSheet character){

        /*

        NAME (AGE) RACE (ALIGNMENT) BACKGROUND
        [CLASS, LEVEL] [CLASS, LEVEL] ("EXP": EXP)
        "-----------------------------------------------------------------"
        "INSPIRATION: " [ ]     "PROFICIENCY BONUS: " (PROF.MOD)
        "SPEED:" SPEED          "INITIATIVE" MOD
        "-----------------------------------------------------------------"
        [ARMOR CLASS: AC]  [HIT DICE: HD]  [HIT POINTS: HP]  [TEMP HIT POINTS: HP]
        "-----------------------------------------------------------------"
        [SPELLCASTING: ABILITY]   [SPELL SAVE DC: MOD]   [SPELL ATTACK: MOD]
        "-----------------------------------------------------------------"
        [ROLLING DEATH SAVES( )]   [SUCCESS( )( )( )]   [FAIL( )( )( )]
        "-----------------------------------------------------------------"
        [ ] "     STRENGTH: " STR  (STR.MOD)    "SAVING THROW: " (STR.SAVE)
        [ ] "    DEXTERITY: " DEX  (DEX.MOD)    "SAVING THROW: " (DEX.SAVE)
        [X] " CONSTITUTION: " CON  (CON.MOD)    "SAVING THROW: " (CON.SAVE)
        [ ] " INTELLIGENCE: " INT  (INT.MOD)    "SAVING THROW: " (INT.SAVE)
        [ ] "       WISDOM: " WIS  (WIS.MOD)    "SAVING THROW: " (WIS.SAVE)
        [X] "     CHARISMA: " CHR  (CHR.MOD)    "SAVING THROW: " (CHR.SAVE)
        "-----------------------------------------------------------------"
        (STR) [ ] "      ATHLETICS:"  MOD
        (DEX) [ ] "     ACROBATICS:"  MOD
        (DEX) [ ] "SLEIGHT-OF-HAND:"  MOD
        (DEX) [ ] "        STEALTH:"  MOD
        (INT) [ ] "         ARCANA:"  MOD
        (INT) [ ] "        HISTORY:"  MOD
        (INT) [ ] "  INVESTIGATION:"  MOD
        (INT) [ ] "         NATURE:"  MOD
        (INT) [ ] "       RELIGION:"  MOD
        (WIS) [ ] "ANIMAL-HANDLING:"  MOD
        (WIS) [ ] "        INSIGHT:"  MOD
        (WIS) [ ] "       MEDICINE:"  MOD
        (WIS) [ ] "     PERCEPTION:"  MOD
        (WIS) [ ] "       SURVIVAL:"  MOD
        (CHR) [ ] "      DECEPTION:"  MOD
        (CHR) [ ] "   INTIMIDATION:"  MOD
        (CHR) [ ] "    PERFORMANCE:"  MOD
        (CHR) [ ] "     PERSUASION:"  MOD
        "-----------------------------------------------------------------"
        "TRAITS:" TRAIT, TRAIT, TRAIT
        "-----------------------------------------------------------------"
        "IDEALS:" IDEAL, IDEAL, IDEAL
        "-----------------------------------------------------------------"
        "BONDS:" BOND, BOND, BOND
        "-----------------------------------------------------------------"
        "FLAWS:" FLAW, FLAW, FLAW
        "-----------------------------------------------------------------"

         */


//        NAME (AGE) RACE (ALIGNMENT) BACKGROUND
        String line1 = character.getCharacterName()
                        + "  (" + character.getCharacterAge() + ")  "
                        + character.getCharacterRace()
                        + "  (" + character.getCharacterAlignment() + ")  "
                        + character.getCharacterBackground();
        System.out.println(line1);



//        [CLASS, LEVEL] [CLASS, LEVEL] ("EXP": EXP)
        Map<String, Integer> charLevel = character.getCharacterClassAndLevel();
        String line2 = "";
        for(Map.Entry<String, Integer> level : charLevel.entrySet()){
            line2 += "[" + level.getKey() + ", " + level.getValue() + "]  ";
        }
        line2 += "(EXP: " + character.getCharacterExperiencePoints();
        System.out.println(line2);


//        "-----------------------------------------------------------------"
        System.out.println("-----------------------------------------------------------------");


//        "INSPIRATION: " [ ]     "PROFICIENCY BONUS: " (PROF.MOD)
        String hasInspiration = "[";
        if (character.isHasInspiration()) hasInspiration += "X]";
        else hasInspiration += " ]";
        int proficiencyBonus = character.getProficiencyBonus();
        String line3 = "INSPIRATION: " + hasInspiration + "     PROFICIENCY BONUS: " + proficiencyBonus;
        System.out.println(line3);


//        "SPEED:" SPEED          "INITIATIVE" MOD
        int speed = character.getSpeed();
        int initiative = character.getInitiative();
        String line4 = "SPEED: " + speed + "     INITIATIVE: " + initiative;


//        "-----------------------------------------------------------------"
        System.out.println("-----------------------------------------------------------------");


//        [ARMOR CLASS: AC]  [HIT DICE: HD]  [HIT POINTS: HP]  [TEMP HIT POINTS: HP]
        int ac = character.getArmorClass();
        int hd = character.getHitDice();
        int hp = character.getCurrentHitPoints();
        int thp = character.getTemporaryHitPoints();
        String line5 = "[ARMOR CLASS: " + ac + "]   [HIT DICE: " + hd + "]   [HIT POINTS: " + hp + "]   [TEMP HIT POINTS: " + thp + "]";
        System.out.println(line5);
//
//
//        "-----------------------------------------------------------------"
        System.out.println("-----------------------------------------------------------------");
//
//
//        [SPELLCASTING: ABILITY]   [SPELL SAVE DC: MOD]   [SPELL ATTACK: MOD]
        String spellAbility = character.getSpellcastingAbility();
        int spellDC = character.getSpellSaveDC();
        int spellAttackBonus = character.getSpellAttackBonus();
        String line6 = "[SPELL-CASTING ABILITY: " + spellAbility + "]   [SPELL SAVE DC: " + spellDC + "]   [SPELL ATTACK BONUS: " + spellAttackBonus + "]";
//
//
//        "-----------------------------------------------------------------"
        System.out.println("-----------------------------------------------------------------");
//
//
//        [ROLLING DEATH SAVES( )]   [SUCCESS( )( )( )]   [FAIL( )( )( )]
        String isYes = "(X)";
        String isNo = "( )";
        String line7 = "";
        if (!character.isRollingDeathSaves()) line7 += "[ROLLING DEATH SAVES ( )]   [SUCCESS ( )( )( )]   [FAIL ( )( )( )]";
        else {
            line7 += "[ROLLING DEATH SAVES (X)]   [SUCCESS ";
            int success = character.getDeathSaveSuccesses();
            for (int i = 3; i > 0; i--) {
                if (success != 0) {
                    line7 += isYes;
                    success--;
                } else line7 += isNo;
            }
            line7 += "]   [FAIL ";
            int fail = character.getDeathSaveFailures();
            for (int i = 3; i > 0; i--){
                if (fail != 0) {
                    line7 += isYes;
                    fail--;
                } else line7 += isNo;
            }
            line7 += "]";
        }
        System.out.println(line7);

//
//
//        "-----------------------------------------------------------------"
        System.out.println("-----------------------------------------------------------------");

        String check = "[X]";
        String noCheck = "[ ]";
        Map<String, Boolean> saveProf = character.getSavingThrowProficiencies();
//
//
//        [ ] "     STRENGTH: " STR  (STR.MOD)    "SAVING THROW: " (STR.SAVE)
        int str = character.getStrength();
        int strMod = character.getStrengthModifier();
        int strSave = character.getStrengthSavingThrow();
        boolean strProf = saveProf.get("strength");
        String line8 = (strProf) ? check : noCheck;
        line8 += "     STRENGTH: " + str + "   (" + strMod + ")   SAVING THROW: " + strSave;

        System.out.println(line8);



//        [ ] "    DEXTERITY: " DEX  (DEX.MOD)    "SAVING THROW: " (DEX.SAVE)
        int dex = character.getDexterity();
        int dexMod = character.getDexterityModifier();
        int dexSave = character.getDexteritySavingThrow();
        boolean dexProf = saveProf.get("dexterity");
        String line9= (dexProf) ? check : noCheck;
        line9 += "    DEXTERITY: " + dex + "   (" + dexMod + ")   SAVING THROW: " + dexSave;

        System.out.println(line9);



//        [X] " CONSTITUTION: " CON  (CON.MOD)    "SAVING THROW: " (CON.SAVE)
        int con = character.getConstitution();
        int conMod = character.getConstitutionModifier();
        int conSave = character.getConstitutionSavingThrow();
        boolean conProf = saveProf.get("constitution");
        String line10 = (conProf) ? check : noCheck;
        line10 += " CONSTITUTION: " + con + "   (" + conMod + ")   SAVING THROW: " + conSave;

        System.out.println(line10);


//        [ ] " INTELLIGENCE: " INT  (INT.MOD)    "SAVING THROW: " (INT.SAVE)
        int inT = character.getIntelligence();
        int intMod = character.getIntelligenceModifier();
        int intSave = character.getIntelligenceSavingThrow();
        boolean intProf = saveProf.get("intelligence");
        String line11 = (intProf) ? check : noCheck;
        line11 += " INTELLIGENCE: " + inT + "   (" + intMod + ")   SAVING THROW: " + intSave;

        System.out.println(line11);


//        [ ] "       WISDOM: " WIS  (WIS.MOD)    "SAVING THROW: " (WIS.SAVE)
        int wis = character.getWisdom();
        int wisMod = character.getWisdomModifier();
        int wisSave = character.getWisdomSavingThrow();
        boolean wisProf = saveProf.get("wisdom");
        String line12 = (wisProf) ? check : noCheck;
        line12 += "       WISDOM: " + wis + "   (" + wisMod + ")   SAVING THROW: " + wisSave;

        System.out.println(line12);


//        [X] "     CHARISMA: " CHR  (CHR.MOD)    "SAVING THROW: " (CHR.SAVE)
        int chr = character.getCharisma();
        int chrMod = character.getCharismaModifier();
        int chrSave = character.getCharismaSavingThrow();
        boolean chrProf = saveProf.get("charisma");
        String line13 = (chrProf) ? check : noCheck;
        line13 += "     CHARISMA: " + chr + "   (" + chrMod + ")   SAVING THROW: " + chrSave;

        System.out.println(line13);


//        "-----------------------------------------------------------------"
        System.out.println("-----------------------------------------------------------------");


        Map<String, Boolean> skillProf = character.getSavingThrowProficiencies();

//        (STR) [ ] "      ATHLETICS: "  MOD
        boolean athProf = skillProf.get("athletics");
        String line14 = "(STR) ";
        line14 += (athProf) ? check : noCheck;
        line14 += "      ATHLETICS: ";



//        (DEX) [ ] "     ACROBATICS: "  MOD



//        (DEX) [ ] "SLEIGHT-OF-HAND: "  MOD



//        (DEX) [ ] "        STEALTH: "  MOD



//        (INT) [ ] "         ARCANA: "  MOD
//
//
//        (INT) [ ] "        HISTORY: "  MOD
//
//
//        (INT) [ ] "  INVESTIGATION: "  MOD
//
//
//        (INT) [ ] "         NATURE: "  MOD
//
//
//        (INT) [ ] "       RELIGION: "  MOD
//
//
//        (WIS) [ ] "ANIMAL-HANDLING: "  MOD
//
//
//        (WIS) [ ] "        INSIGHT: "  MOD
//
//
//        (WIS) [ ] "       MEDICINE: "  MOD
//
//
//        (WIS) [ ] "     PERCEPTION: "  MOD
//
//
//        (WIS) [ ] "       SURVIVAL: "  MOD
//
//
//        (CHR) [ ] "      DECEPTION: "  MOD
//
//
//        (CHR) [ ] "   INTIMIDATION: "  MOD
//
//
//        (CHR) [ ] "    PERFORMANCE: "  MOD
//
//
//        (CHR) [ ] "     PERSUASION: "  MOD
//
//
//        "-----------------------------------------------------------------"
        System.out.println("-----------------------------------------------------------------");
//
//
//        "TRAITS:" TRAIT, TRAIT, TRAIT
//
//
//        "-----------------------------------------------------------------"
        System.out.println("-----------------------------------------------------------------");
//
//
//        "IDEALS:" IDEAL, IDEAL, IDEAL
//
//
//        "-----------------------------------------------------------------"
        System.out.println("-----------------------------------------------------------------");
//
//
//        "BONDS:" BOND, BOND, BOND
//
//
//        "-----------------------------------------------------------------"
        System.out.println("-----------------------------------------------------------------");
//
//
//        "FLAWS:" FLAW, FLAW, FLAW
//
//
//        "-----------------------------------------------------------------"
        System.out.println("-----------------------------------------------------------------");




    }

}
