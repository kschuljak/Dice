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

public class Enna extends CharacterSheet {

    public Enna() {

        super("Enna Xiloscient");

        this.characterAge = 137;
        this.characterRace = new HighElf();
        this.characterClassAndLevel = new HashMap<>();
        characterClassAndLevel.put(new Wizard(), 5);
        this.characterBackground = "sage";
        this.characterAlignment = "chaotic good";
        this.characterExperiencePoints = 4;

        this.characterPersonalityTraits = new ArrayList<>();
        characterPersonalityTraits.add("avid reader and knowledge hoarder");
        this.characterIdeals = new ArrayList<>();
        characterIdeals.add("knowledge itself is not good or evil, moral judgements only apply to how you use it");
        this.characterBonds = new ArrayList<>();
        characterBonds.add("research librarian and archivist");
        this.characterFlaws = new ArrayList<>();
        characterFlaws.add("more likely to stop and study a monster than run from it");

        this.strength = 13;
        this.strengthModifier = -1;
        this.dexterity = 15;
        this.dexterityModifier = 2;
        this.constitution = 14;
        this.constitutionModifier = 2;
        this.intelligence = 20;
        this.intelligenceModifier = 5;
        this.wisdom = 11;
        this.wisdomModifier = 0;
        this.charisma = 12;
        this.charismaModifier = 1;

        this.hasInspiration = false;
        this.proficiencyBonus = 3;

        this.savingThrowProficiencies = new HashMap<>();
        savingThrowProficiencies.put("strength", false);
        savingThrowProficiencies.put("dexterity", false);
        savingThrowProficiencies.put("constitution", false);
        savingThrowProficiencies.put("intelligence", true);
        savingThrowProficiencies.put("wisdom", true);
        savingThrowProficiencies.put("charisma", false);

        this.strengthSavingThrow = 1;
        this.dexteritySavingThrow = 2;
        this.constitutionSavingThrow = 2;
        this.intelligenceSavingThrow = 7;
        this.wisdomSavingThrow = 2;
        this.charismaSavingThrow = 1;

        this.skillProficiencies = new HashMap<>();
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

        athletics = 2;
        animalHandling = 0;
        arcana = 7;
        athletics = -1;
        deception = 1;
        history = 6;
        insight = 0;
        intimidation = 1;
        investigation = 5;
        medicine = 0;
        nature = 5;
        perception = 2;
        performance = 1;
        persuasion = 1;
        religion = 5;
        sleightOfHand = 2;
        stealth = 2;
        survival = 0;

        passiveWisdomAkaPerception = 15;

        languages = new ArrayList<>();
        languages.add("common");
        languages.add("elvish");
        languages.add("dwarvish");
        languages.add("draconic");
        languages.add("primordial");
        languages.add("undercommon");
        languages.add("goblin");
        languages.add("sylvan");

        featuresAndTraits = new ArrayList<>();
        featuresAndTraits.add("darkvision");
        featuresAndTraits.add("fey ancestry");
        featuresAndTraits.add("observant");
        featuresAndTraits.add("linguist");
        featuresAndTraits.add("arcane tradition: necromancy");
        featuresAndTraits.add("necromancy: necromancy savant");
        featuresAndTraits.add("necromancy: grim harvest");
        featuresAndTraits.add("defender of caer moray");

        weaponAndArmorProficiencies = new ArrayList<>();
        weaponAndArmorProficiencies.add("longsword");
        weaponAndArmorProficiencies.add("shortsword");
        weaponAndArmorProficiencies.add("longbow");
        weaponAndArmorProficiencies.add("shortbow");

        toolProficiencies = new ArrayList<>();
        miscProficiencies = new ArrayList<>();

        armorClass = 12;
        initiative = 2;
        speed = 30;
        currentHitPoints = 32;
        temporaryHitPoints = 0;
        hitDice = 6;
        isRollingDeathSaves = false;
        deathSaveSuccesses = 0;
        deathSaveFailures = 0;
        spellcastingAbility = "intelligence";
        spellSaveDC = 16;
        spellAttackBonus = 8;

        spellsPrepared = new HashMap<>();
        spellsPrepared.put("false life", "self, 1d4 + 4");
        spellsPrepared.put("find familiar", "10 ft");
        spellsPrepared.put("featherfall", "reaction, 60ft");
        spellsPrepared.put("ray of sickness", "60ft, 2d8");
        spellsPrepared.put("shield", "reaction, self, +5 AC one turn");

        weaponsHeld = new ArrayList<>();
        weaponsHeld.add(new Shortsword());
        weaponsHeld.add(new Quarterstaff());

        armorWorn = new ArrayList<>();
        armorWorn.add(new Gear("helm of comprehending languages", "", 0));

        backpack = new Backpack(false);

        cantripsKnown = new HashMap<>();
        cantripsKnown.put("mage hand", "30ft");
        cantripsKnown.put("prestidigitation", "10ft");
        cantripsKnown.put("message", "120ft");
        cantripsKnown.put("firebolt", "120ft, 1d10");
        cantripsKnown.put("chill touch", "120ft, 1d8");
        cantripsKnown.put("poison spray", "10ft");

        levelOneSpellsKnown = new HashMap<>();
        levelOneSpellsKnown.put("comprehend languages", "self");
        levelOneSpellsKnown.put("tenser's floating disk", "30ft");
        levelOneSpellsKnown.put("false life", "self, 1d4 + 4");
        levelOneSpellsKnown.put("find familiar", "10 ft");
        levelOneSpellsKnown.put("featherfall", "reaction, 60ft");
        levelOneSpellsKnown.put("ray of sickness", "60ft, 2d8");
        levelOneSpellsKnown.put("shield", "reaction, self, +5 AC one turn");

        levelTwoSpellsKnown = new HashMap<>();
        levelTwoSpellsKnown.put("alter self", "c, 1hr");
        levelTwoSpellsKnown.put("shatter", "60ft");
        levelTwoSpellsKnown.put("ropetrick", "30ft");
        levelTwoSpellsKnown.put("enlarge/reduce", "");

        levelOneSpellSlots = 4;
        levelOneSpellSlotsUsed = 0;

        levelTwoSpellSlots = 3;
        levelTwoSpellSlotsUsed = 0;


    }



}
