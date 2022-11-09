package DnDRaces;

public class Halfling extends DnDRace {

    public Halfling() {
        super("Halfling", 20, 150, "small", 25);
        setRaceAbilityScoreModifiers("Dexterity", 2);
        setRaceLanguages(new String[]{"Common", "Halfling"});
        setRaceTraits(new String[]{"Lucky", "Brave", "Halfling Nimbleness"});
        setDndSubraceOptions(new String[]{"Stout Halfling", "Lightfoot Halfling"});
    }

    public Halfling(String dndRaceName, int ageOfAdulthood, int averageLifespan, String characterSize, int characterSpeed) {
        super(dndRaceName, ageOfAdulthood, averageLifespan, characterSize, characterSpeed);
    }
}
