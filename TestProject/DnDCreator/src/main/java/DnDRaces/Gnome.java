package DnDRaces;

public class Gnome extends DnDRace {

    public Gnome() {
        super("Gnome", 40, 450, "small", 25);
        setRaceAbilityScoreModifiers("Intelligence", 2);
        setRaceLanguages(new String[]{"Common", "Gnomish"});
        setRaceTraits(new String[]{"Darkvision", "Gnome Cunning"});
        setDndSubraceOptions(new String[]{"Forest Gnome", "Rock Gnome"});
    }

    public Gnome(String dndRaceName, int ageOfAdulthood, int averageLifespan, String characterSize, int characterSpeed) {
        super(dndRaceName, ageOfAdulthood, averageLifespan, characterSize, characterSpeed);
    }
}
