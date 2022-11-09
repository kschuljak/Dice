package DnDRaces;

public class Tiefling extends DnDRace {

    public Tiefling() {
        super("Tiefling", 18, 100, "medium", 30);
        setRaceLanguages(new String[]{"Common", "Infernal"});
        setRaceAbilityScoreModifiers("Intelligence", 1);
        setRaceAbilityScoreModifiers("Charisma", 2);
        setRaceTraits(new String[]{"Darkvision", "Hellish Resistance", "Infernal Legacy"});
    }
}
