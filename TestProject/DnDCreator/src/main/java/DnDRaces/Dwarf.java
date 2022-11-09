package DnDRaces;

public class Dwarf extends DnDRace {

    public Dwarf() {
        super("Dwarf", 50, 350, "medium", 25);
        setDndSubraceOptions(new String[] {"Hill Dwarf", "Mountain Dwarf"});
        setRaceLanguages(new String[] {"Common", "Dwarvish"});
        setRaceTraits(new String[] {"Darkvision", "Dwarven Resilience", "Dwarven Combat Training", "Tool Proficiency", "Stonecunning"});
        setRaceAbilityScoreModifiers("Constitution", 2);
    }

    public Dwarf(String dndRaceName, int ageOfAdulthood, int averageLifespan, String characterSize, int characterSpeed) {
        super(dndRaceName, ageOfAdulthood, averageLifespan, characterSize, characterSpeed);
    }
}
