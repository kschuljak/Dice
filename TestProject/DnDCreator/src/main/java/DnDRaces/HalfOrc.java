package DnDRaces;

public class HalfOrc extends DnDRace{

    public HalfOrc() {
        super("Half-Orc", 14, 75, "medium", 30);
        setRaceAbilityScoreModifiers("Strength", 2);
        setRaceAbilityScoreModifiers("Constitution", 1);
        setRaceLanguages(new String[] {"Common", "Orc"});
        setRaceTraits(new String[] {"Darkvision", "Menacing", "Relentless Endurance", "Savage Attacks"});
    }
}
