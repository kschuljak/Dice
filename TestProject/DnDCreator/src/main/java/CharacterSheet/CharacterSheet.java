package CharacterSheet;

import Backpack.Backpack;
import Backpack.Gear.Gear;
import DnDClasses.DnDClass;
import DnDRaces.DnDRace;

import java.util.*;

public abstract class CharacterSheet {

    // INSTANCE VARIABLES

    // character info - instance variables
    protected String characterName;
    protected int characterAge;
    protected DnDRace characterRace;
        // map (characterClass, classLevel)
    protected Map<DnDClass, Integer> characterClassAndLevel = new HashMap<>();
    protected String characterBackground = "";
    protected String characterAlignment = "";
    protected int characterExperiencePoints;
    protected List<String> characterPersonalityTraits = new ArrayList<>();
    protected List<String> characterIdeals = new ArrayList<>();
    protected List<String> characterBonds = new ArrayList<>();
    protected List<String> characterFlaws = new ArrayList<>();

    // ability scores - instance variables
    protected int strength;
    protected int strengthModifier;
    protected int dexterity;
    protected int dexterityModifier;
    protected int constitution;
    protected int constitutionModifier;
    protected int intelligence;
    protected int intelligenceModifier;
    protected int wisdom;
    protected int wisdomModifier;
    protected int charisma;
    protected int charismaModifier;

    // bonuses - instance variables
    protected boolean hasInspiration = false;
    protected int proficiencyBonus = 2;

    // saving throws - instance variables
        // map (ability, hasProficiency)
    protected Map<String, Boolean> savingThrowProficiencies = new HashMap<>();
    protected int strengthSavingThrow;
    protected int dexteritySavingThrow;
    protected int constitutionSavingThrow;
    protected int intelligenceSavingThrow;
    protected int wisdomSavingThrow;
    protected int charismaSavingThrow;

    // skills - instance variables
        // map (skill, hasProficiency)
    protected Map<String, Boolean> skillProficiencies = new HashMap<>();
        // strength
    protected int athletics;
        // dexterity
    protected int acrobatics;
    protected int sleightOfHand;
    protected int stealth;
        // constitution - none
        //intelligence
    protected int arcana;
    protected int history;
    protected int investigation;
    protected int nature;
    protected int religion;
        // wisdom
    protected int animalHandling;
    protected int insight;
    protected int medicine;
    protected int perception;
    protected int survival;
        // charisma
    protected int deception;
    protected int intimidation;
    protected int performance;
    protected int persuasion;
        // passive
    protected int passiveWisdomAkaPerception;

    // other proficiencies, skills, traits - instance variables
    protected List<String> languages = new ArrayList<>();
    protected List<String> featuresAndTraits = new ArrayList<>();
    protected List<String> weaponAndArmorProficiencies = new ArrayList<>();
    protected List<String> toolProficiencies = new ArrayList<>();
    protected List<String> miscProficiencies = new ArrayList<>();

    // combat stats- instance variables
    protected int armorClass;
    protected int initiative;
    protected int speed;
    protected int currentHitPoints;
    protected int temporaryHitPoints;
    protected int hitDice;
    protected boolean isRollingDeathSaves;
    protected int deathSaveSuccesses;
    protected int deathSaveFailures;
    protected String spellcastingAbility;
    protected int spellSaveDC;
    protected int spellAttackBonus;

    // combat actions and equipment - instance variables
        // map (spell name, spell description)
    protected Map<String, String> spellsPrepared = new HashMap<>();
        // map (weapon name, attack description)
    protected List<Gear> weaponsHeld = new ArrayList<>();
        // map (armor name, armor description)
    protected List<Gear> armorWorn = new ArrayList<>();

    // available items (backpack) - instance variables
        // money: (0.2 P) = (1 G) = (2 E) = (10 S) = (100 C)
    protected Backpack backpack = new Backpack();

    // magic known - instance variables
        // map (spell name, spell description)
    protected Map<String, String> cantripsKnown = new HashMap<>();
    protected Map<String, String> levelOneSpellsKnown = new HashMap<>();
    protected Map<String, String> levelTwoSpellsKnown = new HashMap<>();
    protected Map<String, String> levelThreeSpellsKnown = new HashMap<>();
    protected Map<String, String> levelFourSpellsKnown = new HashMap<>();
    protected Map<String, String> levelFiveSpellsKnown = new HashMap<>();
    protected Map<String, String> levelSixSpellsKnown = new HashMap<>();
    protected Map<String, String> levelSevenSpellsKnown = new HashMap<>();
    protected Map<String, String> levelEightSpellsKnown = new HashMap<>();
    protected Map<String, String> levelNineSpellsKnown = new HashMap<>();
    protected int levelOneSpellSlots;
    protected int levelOneSpellSlotsUsed;
    protected int levelTwoSpellSlots;
    protected int levelTwoSpellSlotsUsed;
    protected int levelThreeSpellSlots;
    protected int levelThreeSpellSlotsUsed;
    protected int levelFourSpellSlots;
    protected int levelFourSpellSlotsUsed;
    protected int levelFiveSpellSlots;
    protected int levelFiveSpellSlotsUsed;
    protected int levelSixSpellSlots;
    protected int levelSixSpellSlotsUsed;
    protected int levelSevenSpellSlots;
    protected int levelSevenSpellSlotsUsed;
    protected int levelEightSpellSlots;
    protected int levelEightSpellSlotsUsed;
    protected int levelNineSpellSlots;
    protected int levelNineSpellSlotsUsed;


    // constructor
    public CharacterSheet(String characterName) {
        this.characterName = characterName;
    }

    public CharacterSheet() {
    }


    // getters & setters

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    public int getCharacterAge() {
        return characterAge;
    }

    public void setCharacterAge(int characterAge) {
        this.characterAge = characterAge;
    }

    public DnDRace getCharacterRace() {
        return characterRace;
    }

    public void setCharacterRace(DnDRace characterRace) {
        this.characterRace = characterRace;
    }

    public Map<DnDClass, Integer> getCharacterClassAndLevel() {
        return characterClassAndLevel;
    }

    public void setCharacterClassAndLevel(Map<DnDClass, Integer> characterClassAndLevel) {
        this.characterClassAndLevel = characterClassAndLevel;
    }

    public String getCharacterBackground() {
        return characterBackground;
    }

    public void setCharacterBackground(String characterBackground) {
        this.characterBackground = characterBackground;
    }

    public String getCharacterAlignment() {
        return characterAlignment;
    }

    public void setCharacterAlignment(String characterAlignment) {
        this.characterAlignment = characterAlignment;
    }

    public int getCharacterExperiencePoints() {
        return characterExperiencePoints;
    }

    public void setCharacterExperiencePoints(int characterExperiencePoints) {
        this.characterExperiencePoints = characterExperiencePoints;
    }

    public List<String> getCharacterPersonalityTraits() {
        return characterPersonalityTraits;
    }

    public void setCharacterPersonalityTraits(List<String> characterPersonalityTraits) {
        this.characterPersonalityTraits = characterPersonalityTraits;
    }

    public List<String> getCharacterIdeals() {
        return characterIdeals;
    }

    public void setCharacterIdeals(List<String> characterIdeals) {
        this.characterIdeals = characterIdeals;
    }

    public List<String> getCharacterBonds() {
        return characterBonds;
    }

    public void setCharacterBonds(List<String> characterBonds) {
        this.characterBonds = characterBonds;
    }

    public List<String> getCharacterFlaws() {
        return characterFlaws;
    }

    public void setCharacterFlaws(List<String> characterFlaws) {
        this.characterFlaws = characterFlaws;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getStrengthModifier() {
        return strengthModifier;
    }

    public void setStrengthModifier(int strengthModifier) {
        this.strengthModifier = strengthModifier;
    }

    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public int getDexterityModifier() {
        return dexterityModifier;
    }

    public void setDexterityModifier(int dexterityModifier) {
        this.dexterityModifier = dexterityModifier;
    }

    public int getConstitution() {
        return constitution;
    }

    public void setConstitution(int constitution) {
        this.constitution = constitution;
    }

    public int getConstitutionModifier() {
        return constitutionModifier;
    }

    public void setConstitutionModifier(int constitutionModifier) {
        this.constitutionModifier = constitutionModifier;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getIntelligenceModifier() {
        return intelligenceModifier;
    }

    public void setIntelligenceModifier(int intelligenceModifier) {
        this.intelligenceModifier = intelligenceModifier;
    }

    public int getWisdom() {
        return wisdom;
    }

    public void setWisdom(int wisdom) {
        this.wisdom = wisdom;
    }

    public int getWisdomModifier() {
        return wisdomModifier;
    }

    public void setWisdomModifier(int wisdomModifier) {
        this.wisdomModifier = wisdomModifier;
    }

    public int getCharisma() {
        return charisma;
    }

    public void setCharisma(int charisma) {
        this.charisma = charisma;
    }

    public int getCharismaModifier() {
        return charismaModifier;
    }

    public void setCharismaModifier(int charismaModifier) {
        this.charismaModifier = charismaModifier;
    }

    public boolean isHasInspiration() {
        return hasInspiration;
    }

    public void setHasInspiration(boolean hasInspiration) {
        this.hasInspiration = hasInspiration;
    }

    public int getProficiencyBonus() {
        return proficiencyBonus;
    }

    public void setProficiencyBonus(int proficiencyBonus) {
        this.proficiencyBonus = proficiencyBonus;
    }

    public Map<String, Boolean> getSavingThrowProficiencies() {
        return savingThrowProficiencies;
    }

    public void setSavingThrowProficiencies(Map<String, Boolean> savingThrowProficiencies) {
        this.savingThrowProficiencies = savingThrowProficiencies;
    }

    public int getStrengthSavingThrow() {
        return strengthSavingThrow;
    }

    public void setStrengthSavingThrow(int strengthSavingThrow) {
        this.strengthSavingThrow = strengthSavingThrow;
    }

    public int getDexteritySavingThrow() {
        return dexteritySavingThrow;
    }

    public void setDexteritySavingThrow(int dexteritySavingThrow) {
        this.dexteritySavingThrow = dexteritySavingThrow;
    }

    public int getConstitutionSavingThrow() {
        return constitutionSavingThrow;
    }

    public void setConstitutionSavingThrow(int constitutionSavingThrow) {
        this.constitutionSavingThrow = constitutionSavingThrow;
    }

    public int getIntelligenceSavingThrow() {
        return intelligenceSavingThrow;
    }

    public void setIntelligenceSavingThrow(int intelligenceSavingThrow) {
        this.intelligenceSavingThrow = intelligenceSavingThrow;
    }

    public int getWisdomSavingThrow() {
        return wisdomSavingThrow;
    }

    public void setWisdomSavingThrow(int wisdomSavingThrow) {
        this.wisdomSavingThrow = wisdomSavingThrow;
    }

    public int getCharismaSavingThrow() {
        return charismaSavingThrow;
    }

    public void setCharismaSavingThrow(int charismaSavingThrow) {
        this.charismaSavingThrow = charismaSavingThrow;
    }

    public Map<String, Boolean> getSkillProficiencies() {
        return skillProficiencies;
    }

    public void setSkillProficiencies(Map<String, Boolean> skillProficiencies) {
        this.skillProficiencies = skillProficiencies;
    }

    public int getAthletics() {
        return athletics;
    }

    public void setAthletics(int athletics) {
        this.athletics = athletics;
    }

    public int getAcrobatics() {
        return acrobatics;
    }

    public void setAcrobatics(int acrobatics) {
        this.acrobatics = acrobatics;
    }

    public int getSleightOfHand() {
        return sleightOfHand;
    }

    public void setSleightOfHand(int sleightOfHand) {
        this.sleightOfHand = sleightOfHand;
    }

    public int getStealth() {
        return stealth;
    }

    public void setStealth(int stealth) {
        this.stealth = stealth;
    }

    public int getArcana() {
        return arcana;
    }

    public void setArcana(int arcana) {
        this.arcana = arcana;
    }

    public int getHistory() {
        return history;
    }

    public void setHistory(int history) {
        this.history = history;
    }

    public int getInvestigation() {
        return investigation;
    }

    public void setInvestigation(int investigation) {
        this.investigation = investigation;
    }

    public int getNature() {
        return nature;
    }

    public void setNature(int nature) {
        this.nature = nature;
    }

    public int getReligion() {
        return religion;
    }

    public void setReligion(int religion) {
        this.religion = religion;
    }

    public int getAnimalHandling() {
        return animalHandling;
    }

    public void setAnimalHandling(int animalHandling) {
        this.animalHandling = animalHandling;
    }

    public int getInsight() {
        return insight;
    }

    public void setInsight(int insight) {
        this.insight = insight;
    }

    public int getMedicine() {
        return medicine;
    }

    public void setMedicine(int medicine) {
        this.medicine = medicine;
    }

    public int getPerception() {
        return perception;
    }

    public void setPerception(int perception) {
        this.perception = perception;
    }

    public int getSurvival() {
        return survival;
    }

    public void setSurvival(int survival) {
        this.survival = survival;
    }

    public int getDeception() {
        return deception;
    }

    public void setDeception(int deception) {
        this.deception = deception;
    }

    public int getIntimidation() {
        return intimidation;
    }

    public void setIntimidation(int intimidation) {
        this.intimidation = intimidation;
    }

    public int getPerformance() {
        return performance;
    }

    public void setPerformance(int performance) {
        this.performance = performance;
    }

    public int getPersuasion() {
        return persuasion;
    }

    public void setPersuasion(int persuasion) {
        this.persuasion = persuasion;
    }

    public int getPassiveWisdomAkaPerception() {
        return passiveWisdomAkaPerception;
    }

    public void setPassiveWisdomAkaPerception(int passiveWisdomAkaPerception) {
        this.passiveWisdomAkaPerception = passiveWisdomAkaPerception;
    }

    public List<String> getLanguages() {
        return languages;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    public List<String> getFeaturesAndTraits() {
        return featuresAndTraits;
    }

    public void setFeaturesAndTraits(List<String> featuresAndTraits) {
        this.featuresAndTraits = featuresAndTraits;
    }

    public List<String> getWeaponAndArmorProficiencies() {
        return weaponAndArmorProficiencies;
    }

    public void setWeaponAndArmorProficiencies(List<String> weaponAndArmorProficiencies) {
        this.weaponAndArmorProficiencies = weaponAndArmorProficiencies;
    }

    public List<String> getToolProficiencies() {
        return toolProficiencies;
    }

    public void setToolProficiencies(List<String> toolProficiencies) {
        this.toolProficiencies = toolProficiencies;
    }

    public List<String> getMiscProficiencies() {
        return miscProficiencies;
    }

    public void setMiscProficiencies(List<String> miscProficiencies) {
        this.miscProficiencies = miscProficiencies;
    }

    public int getArmorClass() {
        return armorClass;
    }

    public void setArmorClass(int armorClass) {
        this.armorClass = armorClass;
    }

    public int getInitiative() {
        return initiative;
    }

    public void setInitiative(int initiative) {
        this.initiative = initiative;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getCurrentHitPoints() {
        return currentHitPoints;
    }

    public void setCurrentHitPoints(int currentHitPoints) {
        this.currentHitPoints = currentHitPoints;
    }

    public int getTemporaryHitPoints() {
        return temporaryHitPoints;
    }

    public void setTemporaryHitPoints(int temporaryHitPoints) {
        this.temporaryHitPoints = temporaryHitPoints;
    }

    public int getHitDice() {
        return hitDice;
    }

    public void setHitDice(int hitDice) {
        this.hitDice = hitDice;
    }

    public boolean isRollingDeathSaves() {
        return isRollingDeathSaves;
    }

    public void setRollingDeathSaves(boolean rollingDeathSaves) {
        isRollingDeathSaves = rollingDeathSaves;
    }

    public int getDeathSaveSuccesses() {
        return deathSaveSuccesses;
    }

    public void setDeathSaveSuccesses(int deathSaveSuccesses) {
        this.deathSaveSuccesses = deathSaveSuccesses;
    }

    public int getDeathSaveFailures() {
        return deathSaveFailures;
    }

    public void setDeathSaveFailures(int deathSaveFailures) {
        this.deathSaveFailures = deathSaveFailures;
    }

    public String getSpellcastingAbility() {
        return spellcastingAbility;
    }

    public void setSpellcastingAbility(String spellcastingAbility) {
        this.spellcastingAbility = spellcastingAbility;
    }

    public int getSpellSaveDC() {
        return spellSaveDC;
    }

    public void setSpellSaveDC(int spellSaveDC) {
        this.spellSaveDC = spellSaveDC;
    }

    public int getSpellAttackBonus() {
        return spellAttackBonus;
    }

    public void setSpellAttackBonus(int spellAttackBonus) {
        this.spellAttackBonus = spellAttackBonus;
    }

    public Map<String, String> getSpellsPrepared() {
        return spellsPrepared;
    }

    public void setSpellsPrepared(Map<String, String> spellsPrepared) {
        this.spellsPrepared = spellsPrepared;
    }

    public List<Gear> getWeaponsHeld() {
        return weaponsHeld;
    }

    public void setWeaponsHeld(List<Gear> weaponsHeld) {
        this.weaponsHeld = weaponsHeld;
    }

    public List<Gear> getArmorWorn() {
        return armorWorn;
    }

    public void setArmorWorn(List<Gear> armorWorn) {
        this.armorWorn = armorWorn;
    }

    public Backpack getBackpack() {
        return backpack;
    }

    public void setBackpack(Backpack backpack){
        this.backpack = backpack;
    }

    public Map<String, String> getCantripsKnown() {
        return cantripsKnown;
    }

    public void setCantripsKnown(Map<String, String> cantripsKnown) {
        this.cantripsKnown = cantripsKnown;
    }

    public Map<String, String> getLevelOneSpellsKnown() {
        return levelOneSpellsKnown;
    }

    public void setLevelOneSpellsKnown(Map<String, String> levelOneSpellsKnown) {
        this.levelOneSpellsKnown = levelOneSpellsKnown;
    }

    public Map<String, String> getLevelTwoSpellsKnown() {
        return levelTwoSpellsKnown;
    }

    public void setLevelTwoSpellsKnown(Map<String, String> levelTwoSpellsKnown) {
        this.levelTwoSpellsKnown = levelTwoSpellsKnown;
    }

    public Map<String, String> getLevelThreeSpellsKnown() {
        return levelThreeSpellsKnown;
    }

    public void setLevelThreeSpellsKnown(Map<String, String> levelThreeSpellsKnown) {
        this.levelThreeSpellsKnown = levelThreeSpellsKnown;
    }

    public Map<String, String> getLevelFourSpellsKnown() {
        return levelFourSpellsKnown;
    }

    public void setLevelFourSpellsKnown(Map<String, String> levelFourSpellsKnown) {
        this.levelFourSpellsKnown = levelFourSpellsKnown;
    }

    public Map<String, String> getLevelFiveSpellsKnown() {
        return levelFiveSpellsKnown;
    }

    public void setLevelFiveSpellsKnown(Map<String, String> levelFiveSpellsKnown) {
        this.levelFiveSpellsKnown = levelFiveSpellsKnown;
    }

    public Map<String, String> getLevelSixSpellsKnown() {
        return levelSixSpellsKnown;
    }

    public void setLevelSixSpellsKnown(Map<String, String> levelSixSpellsKnown) {
        this.levelSixSpellsKnown = levelSixSpellsKnown;
    }

    public Map<String, String> getLevelSevenSpellsKnown() {
        return levelSevenSpellsKnown;
    }

    public void setLevelSevenSpellsKnown(Map<String, String> levelSevenSpellsKnown) {
        this.levelSevenSpellsKnown = levelSevenSpellsKnown;
    }

    public Map<String, String> getLevelEightSpellsKnown() {
        return levelEightSpellsKnown;
    }

    public void setLevelEightSpellsKnown(Map<String, String> levelEightSpellsKnown) {
        this.levelEightSpellsKnown = levelEightSpellsKnown;
    }

    public Map<String, String> getLevelNineSpellsKnown() {
        return levelNineSpellsKnown;
    }

    public void setLevelNineSpellsKnown(Map<String, String> levelNineSpellsKnown) {
        this.levelNineSpellsKnown = levelNineSpellsKnown;
    }

    public int getLevelOneSpellSlots() {
        return levelOneSpellSlots;
    }

    public void setLevelOneSpellSlots(int levelOneSpellSlots) {
        this.levelOneSpellSlots = levelOneSpellSlots;
    }

    public int getLevelOneSpellSlotsUsed() {
        return levelOneSpellSlotsUsed;
    }

    public void setLevelOneSpellSlotsUsed(int levelOneSpellSlotsUsed) {
        this.levelOneSpellSlotsUsed = levelOneSpellSlotsUsed;
    }

    public int getLevelTwoSpellSlots() {
        return levelTwoSpellSlots;
    }

    public void setLevelTwoSpellSlots(int levelTwoSpellSlots) {
        this.levelTwoSpellSlots = levelTwoSpellSlots;
    }

    public int getLevelTwoSpellSlotsUsed() {
        return levelTwoSpellSlotsUsed;
    }

    public void setLevelTwoSpellSlotsUsed(int levelTwoSpellSlotsUsed) {
        this.levelTwoSpellSlotsUsed = levelTwoSpellSlotsUsed;
    }

    public int getLevelThreeSpellSlots() {
        return levelThreeSpellSlots;
    }

    public void setLevelThreeSpellSlots(int levelThreeSpellSlots) {
        this.levelThreeSpellSlots = levelThreeSpellSlots;
    }

    public int getLevelThreeSpellSlotsUsed() {
        return levelThreeSpellSlotsUsed;
    }

    public void setLevelThreeSpellSlotsUsed(int levelThreeSpellSlotsUsed) {
        this.levelThreeSpellSlotsUsed = levelThreeSpellSlotsUsed;
    }

    public int getLevelFourSpellSlots() {
        return levelFourSpellSlots;
    }

    public void setLevelFourSpellSlots(int levelFourSpellSlots) {
        this.levelFourSpellSlots = levelFourSpellSlots;
    }

    public int getLevelFourSpellSlotsUsed() {
        return levelFourSpellSlotsUsed;
    }

    public void setLevelFourSpellSlotsUsed(int levelFourSpellSlotsUsed) {
        this.levelFourSpellSlotsUsed = levelFourSpellSlotsUsed;
    }

    public int getLevelFiveSpellSlots() {
        return levelFiveSpellSlots;
    }

    public void setLevelFiveSpellSlots(int levelFiveSpellSlots) {
        this.levelFiveSpellSlots = levelFiveSpellSlots;
    }

    public int getLevelFiveSpellSlotsUsed() {
        return levelFiveSpellSlotsUsed;
    }

    public void setLevelFiveSpellSlotsUsed(int levelFiveSpellSlotsUsed) {
        this.levelFiveSpellSlotsUsed = levelFiveSpellSlotsUsed;
    }

    public int getLevelSixSpellSlots() {
        return levelSixSpellSlots;
    }

    public void setLevelSixSpellSlots(int levelSixSpellSlots) {
        this.levelSixSpellSlots = levelSixSpellSlots;
    }

    public int getLevelSixSpellSlotsUsed() {
        return levelSixSpellSlotsUsed;
    }

    public void setLevelSixSpellSlotsUsed(int levelSixSpellSlotsUsed) {
        this.levelSixSpellSlotsUsed = levelSixSpellSlotsUsed;
    }

    public int getLevelSevenSpellSlots() {
        return levelSevenSpellSlots;
    }

    public void setLevelSevenSpellSlots(int levelSevenSpellSlots) {
        this.levelSevenSpellSlots = levelSevenSpellSlots;
    }

    public int getLevelSevenSpellSlotsUsed() {
        return levelSevenSpellSlotsUsed;
    }

    public void setLevelSevenSpellSlotsUsed(int levelSevenSpellSlotsUsed) {
        this.levelSevenSpellSlotsUsed = levelSevenSpellSlotsUsed;
    }

    public int getLevelEightSpellSlots() {
        return levelEightSpellSlots;
    }

    public void setLevelEightSpellSlots(int levelEightSpellSlots) {
        this.levelEightSpellSlots = levelEightSpellSlots;
    }

    public int getLevelEightSpellSlotsUsed() {
        return levelEightSpellSlotsUsed;
    }

    public void setLevelEightSpellSlotsUsed(int levelEightSpellSlotsUsed) {
        this.levelEightSpellSlotsUsed = levelEightSpellSlotsUsed;
    }

    public int getLevelNineSpellSlots() {
        return levelNineSpellSlots;
    }

    public void setLevelNineSpellSlots(int levelNineSpellSlots) {
        this.levelNineSpellSlots = levelNineSpellSlots;
    }

    public int getLevelNineSpellSlotsUsed() {
        return levelNineSpellSlotsUsed;
    }

    public void setLevelNineSpellSlotsUsed(int levelNineSpellSlotsUsed) {
        this.levelNineSpellSlotsUsed = levelNineSpellSlotsUsed;
    }
}
