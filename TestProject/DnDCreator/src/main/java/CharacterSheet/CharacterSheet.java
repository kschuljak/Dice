package CharacterSheet;

import java.util.*;

public abstract class CharacterSheet {

    // INSTANCE VARIABLES

    // character info - instance variables
    String characterName;
    int characterAge;
    String characterRace = "";
        // map (characterClass, classLevel)
    Map<String, Integer> characterClassAndLevel = new HashMap<>();
    String characterBackground = "";
    String characterAlignment = "";
    int characterExperiencePoints;
    List<String> characterPersonalityTraits = new ArrayList<>();
    List<String> characterIdeals = new ArrayList<>();
    List<String> characterBonds = new ArrayList<>();
    List<String> characterFlaws = new ArrayList<>();

    // ability scores - instance variables
    int strength;
    int strengthModifier;
    int dexterity;
    int dexterityModifier;
    int constitution;
    int constitutionModifier;
    int intelligence;
    int intelligenceModifier;
    int wisdom;
    int wisdomModifier;
    int charisma;
    int charismaModifier;

    // bonuses - instance variables
    boolean hasInspiration = false;
    int proficiencyBonus = 2;

    // saving throws - instance variables
        // map (ability, hasProficiency)
    Map<String, Boolean> savingThrowProficiencies = new HashMap<>();
    int strengthSavingThrow;
    int dexteritySavingThrow;
    int constitutionSavingThrow;
    int intelligenceSavingThrow;
    int wisdomSavingThrow;
    int charismaSavingThrow;

    // skills - instance variables
        // map (skill, hasProficiency)
    Map<String, Boolean> skillProficiencies = new HashMap<>();
        // strength
    int athletics;
        // dexterity
    int acrobatics;
    int sleightOfHand;
    int stealth;
        // constitution - none
        //intelligence
    int arcana;
    int history;
    int investigation;
    int nature;
    int religion;
        // wisdom
    int animalHandling;
    int insight;
    int medicine;
    int perception;
    int survival;
        // charisma
    int deception;
    int intimidation;
    int performance;
    int persuasion;
        // passive
    int passiveWisdomAkaPerception;

    // other proficiencies, skills, traits - instance variables
    List<String> languages = new ArrayList<>();
    List<String> featuresAndTraits = new ArrayList<>();
    List<String> weaponAndArmorProficiencies = new ArrayList<>();
    List<String> toolProficiencies = new ArrayList<>();
    List<String> miscProficiencies = new ArrayList<>();

    // combat stats- instance variables
    int armorClass;
    int initiative;
    int speed;
    int currentHitPoints;
    int temporaryHitPoints;
    int hitDice;
    boolean isRollingDeathSaves;
    int deathSaveSuccesses;
    int deathSaveFailures;
    int spellcastingAbility;
    int spellSaveDC;
    int spellAttackBonus;

    // combat actions and equipment - instance variables
        // map (spell name, spell description)
    Map<String, String> spellsPrepared = new HashMap<>();
        // map (weapon name, attack description)
    Map<String, String> weaponsHeld = new HashMap<>();
        // map (armor name, armor description)
    Map<String, String> armorWorn = new HashMap<>();

    // available items (backpack) - instance variables
        // money: (0.2 P) = (1 G) = (2 E) = (10 S) = (100 C)
    int totalMoneyValue;
    int numberPlatinumPieces;
    int numberGoldPieces;
    int numberSilverPieces;
    int numberElectrumPieces;
    int numberCopperPieces;
    List<String> itemsInBackpack = new ArrayList<>();

    // magic known - instance variables
        // map (spell name, spell description)
    Map<String, String> cantripsKnown = new HashMap<>();
    Map<String, String> levelOneSpellsKnown = new HashMap<>();
    Map<String, String> levelTwoSpellsKnown = new HashMap<>();
    Map<String, String> levelThreeSpellsKnown = new HashMap<>();
    Map<String, String> levelFourSpellsKnown = new HashMap<>();
    Map<String, String> levelFiveSpellsKnown = new HashMap<>();
    Map<String, String> levelSixSpellsKnown = new HashMap<>();
    Map<String, String> levelSevenSpellsKnown = new HashMap<>();
    Map<String, String> levelEightSpellsKnown = new HashMap<>();
    Map<String, String> levelNineSpellsKnown = new HashMap<>();
    int levelOneSpellSlots;
    int levelOneSpellSlotsUsed;
    int levelTwoSpellSlots;
    int levelTwoSpellSlotsUsed;
    int levelThreeSpellSlots;
    int levelThreeSpellSlotsUsed;
    int levelFourSpellSlots;
    int levelFourSpellSlotsUsed;
    int levelFiveSpellSlots;
    int levelFiveSpellSlotsUsed;
    int levelSixSpellSlots;
    int levelSixSpellSlotsUsed;
    int levelSevenSpellSlots;
    int levelSevenSpellSlotsUsed;
    int levelEightSpellSlots;
    int levelEightSpellSlotsUsed;
    int levelNineSpellSlots;
    int levelNineSpellSlotsUsed;


}
