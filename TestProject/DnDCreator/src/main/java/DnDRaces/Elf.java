package DnDRaces;

public class Elf extends DnDRace{

    public Elf() {
        super("Elf", 100, 750, "medium", 30);
        setRaceLanguages(new String[] {"Common", "Elvish"});
        setDndSubraceOptions(new String[] {"High Elf", "Wood Elf", "Drow"});
        setRaceAbilityScoreModifiers("Dexterity", 2);
        setRaceTraits(new String[] {"Darkvision", "Keen Senses", "Fey Ancestry", "Trance"});
    }

    public Elf(String dndRaceName, int ageOfAdulthood, int averageLifespan, String characterSize, int characterSpeed) {
        super(dndRaceName, ageOfAdulthood, averageLifespan, characterSize, characterSpeed);
    }
}
