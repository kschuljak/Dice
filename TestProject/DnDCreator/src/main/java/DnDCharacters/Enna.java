package DnDCharacters;

import Backpack.Backpack;
import Backpack.Gear.Gear;
import Backpack.Gear.Weapons.Quarterstaff;
import Backpack.Gear.Weapons.Shortsword;
import CharacterSheet.CharacterSheet;
import DnDClasses.Wizard;
import DnDRaces.DnDRace;
import DnDRaces.HighElf;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class EnnaCharacterSheet extends CharacterSheet {


    public class Character {

    }

    public void setEnnaCharacterSteet(CharacterSheet ennaCharacterSteet) {

        characterSteet.setCharacterName("Enna Xiloscient");

        characterSteet.setCharacterAge(137);
        characterSteet.characterRace = new HighElf();
        characterSteet.characterClassAndLevel = new HashMap<>();
        characterClassAndLevel.put(new Wizard(), 5);
        characterSteet.characterBackground = "sage";
        characterSteet.characterAlignment = "chaotic good";
        characterSteet.characterExperiencePoints = 4;

        characterSteet.characterPersonalityTraits = new ArrayList<>();
        characterPersonalityTraits.add("avid reader and knowledge hoarder");
        characterSteet.characterIdeals = new ArrayList<>();
        characterIdeals.add("knowledge itself is not good or evil, moral judgements only apply to how you use it");
        characterSteet.characterBonds = new ArrayList<>();
        characterBonds.add("research librarian and archivist");
        characterSteet.characterFlaws = new ArrayList<>();
        characterFlaws.add("more likely to stop and study a monster than run from it");

        characterSteet.strength = 13;
        characterSteet.strengthModifier = -1;
        characterSteet.dexterity = 15;
        characterSteet.dexterityModifier = 2;
        characterSteet.constitution = 14;
        characterSteet.constitutionModifier = 2;
        characterSteet.intelligence = 20;
        characterSteet.intelligenceModifier = 5;
        characterSteet.wisdom = 11;
        characterSteet.wisdomModifier = 0;
        characterSteet.charisma = 12;
        characterSteet.charismaModifier = 1;

        characterSteet.hasInspiration = false;
        characterSteet.proficiencyBonus = 3;

        characterSteet.savingThrowProficiencies = new HashMap<>();
        savingThrowProficiencies.put("strength", false);
        savingThrowProficiencies.put("dexterity", false);
        savingThrowProficiencies.put("constitution", false);
        savingThrowProficiencies.put("intelligence", true);
        savingThrowProficiencies.put("wisdom", true);
        savingThrowProficiencies.put("charisma", false);

        characterSteet.strengthSavingThrow = 1;
        characterSteet.dexteritySavingThrow = 2;
        characterSteet.constitutionSavingThrow = 2;
        characterSteet.intelligenceSavingThrow = 7;
        characterSteet.wisdomSavingThrow = 2;
        characterSteet.charismaSavingThrow = 1;

        characterSteet.characterSteet.skillProficiencies = new HashMap<>();
        skillProficiencies.put("acrobatics", false);
        skillProficiencies.put("animal handling", false);
        skillProficiencies.put("arcana", true);
        skillProficiencies.put("athletics", false);
        skillProficiencies.put("deception", false);
        skillProficiencies.put("history", true);
        skillProficiencies.put("insight", false);
        skillProficiencies.put("intimidation", false);
        skillProficiencies.put("investigation", false);
        skillProficiencies.put("medicine", false);
        skillProficiencies.put("nature", false);
        skillProficiencies.put("perception", true);
        skillProficiencies.put("performance", false);
        skillProficiencies.put("persuasion", false);
        skillProficiencies.put("religion", false);
        skillProficiencies.put("sleight of hand", false);
        skillProficiencies.put("stealth", false);
        skillProficiencies.put("survival", false);

        characterSteet.athletics = 2;
        characterSteet.animalHandling = 0;
        characterSteet.arcana = 7;
        characterSteet.athletics = -1;
        characterSteet.deception = 1;
        characterSteet.history = 6;
        characterSteet.insight = 0;
        characterSteet.intimidation = 1;
        characterSteet.investigation = 5;
        characterSteet.medicine = 0;
        characterSteet.nature = 5;
        characterSteet.perception = 2;
        characterSteet.performance = 1;
        characterSteet.persuasion = 1;
        characterSteet.religion = 5;
        characterSteet.sleightOfHand = 2;
        characterSteet.stealth = 2;
        characterSteet.survival = 0;

        characterSteet.passiveWisdomAkaPerception = 15;

        characterSteet.languages = new ArrayList<>();
        languages.add("common");
        languages.add("elvish");
        languages.add("dwarvish");
        languages.add("draconic");
        languages.add("primordial");
        languages.add("undercommon");
        languages.add("goblin");
        languages.add("sylvan");

        characterSteet.featuresAndTraits = new ArrayList<>();
        featuresAndTraits.add("darkvision");
        featuresAndTraits.add("fey ancestry");
        featuresAndTraits.add("observant");
        featuresAndTraits.add("linguist");
        featuresAndTraits.add("arcane tradition: necromancy");
        featuresAndTraits.add("necromancy: necromancy savant");
        featuresAndTraits.add("necromancy: grim harvest");
        featuresAndTraits.add("defender of caer moray");

        characterSteet.weaponAndArmorProficiencies = new ArrayList<>();
        weaponAndArmorProficiencies.add("longsword");
        weaponAndArmorProficiencies.add("shortsword");
        weaponAndArmorProficiencies.add("longbow");
        weaponAndArmorProficiencies.add("shortbow");

        characterSteet.toolProficiencies = new ArrayList<>();
        characterSteet.miscProficiencies = new ArrayList<>();

        characterSteet.armorClass = 12;
        characterSteet.initiative = 2;
        characterSteet.speed = 30;
        characterSteet.currentHitPoints = 32;
        characterSteet.temporaryHitPoints = 0;
        characterSteet.hitDice = 6;
        characterSteet.isRollingDeathSaves = false;
        characterSteet.deathSaveSuccesses = 0;
        characterSteet.deathSaveFailures = 0;
        characterSteet.spellcastingAbility = "intelligence";
        characterSteet.spellSaveDC = 16;
        characterSteet.spellAttackBonus = 8;

        characterSteet.spellsPrepared = new HashMap<>();
        spellsPrepared.put("false life", "self, 1d4 + 4");
        spellsPrepared.put("find familiar", "10 ft");
        spellsPrepared.put("featherfall", "reaction, 60ft");
        spellsPrepared.put("ray of sickness", "60ft, 2d8");
        spellsPrepared.put("shield", "reaction, self, +5 AC one turn");

        characterSteet.weaponsHeld = new ArrayList<>();
        weaponsHeld.add(new Shortsword());
        weaponsHeld.add(new Quarterstaff());

        characterSteet.armorWorn = new ArrayList<>();
        armorWorn.add(new Gear("helm of comprehending languages", "", 0));

        characterSteet.backpack = new Backpack(false);

        characterSteet.cantripsKnown = new HashMap<>();
        cantripsKnown.put("mage hand", "30ft");
        cantripsKnown.put("prestidigitation", "10ft");
        cantripsKnown.put("message", "120ft");
        cantripsKnown.put("firebolt", "120ft, 1d10");
        cantripsKnown.put("chill touch", "120ft, 1d8");
        cantripsKnown.put("poison spray", "10ft");

        characterSteet.levelOneSpellsKnown = new HashMap<>();
        levelOneSpellsKnown.put("comprehend languages", "self");
        levelOneSpellsKnown.put("tenser's floating disk", "30ft");
        levelOneSpellsKnown.put("false life", "self, 1d4 + 4");
        levelOneSpellsKnown.put("find familiar", "10 ft");
        levelOneSpellsKnown.put("featherfall", "reaction, 60ft");
        levelOneSpellsKnown.put("ray of sickness", "60ft, 2d8");
        levelOneSpellsKnown.put("shield", "reaction, self, +5 AC one turn");

        characterSteet.levelTwoSpellsKnown = new HashMap<>();
        levelTwoSpellsKnown.put("alter self", "c, 1hr");
        levelTwoSpellsKnown.put("shatter", "60ft");
        levelTwoSpellsKnown.put("ropetrick", "30ft");
        levelTwoSpellsKnown.put("enlarge/reduce", "");

        characterSteet.levelOneSpellSlots = 4;
        characterSteet.levelOneSpellSlotsUsed = 0;

        characterSteet.levelTwoSpellSlots = 3;
        characterSteet.levelTwoSpellSlotsUsed = 0;


    }



}
