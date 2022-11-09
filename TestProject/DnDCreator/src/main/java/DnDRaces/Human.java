package DnDRaces;

public class Human extends DnDRace {

    public Human() {
        super("Human", 18, 80, "medium", 30);
        setRaceAbilityScoreModifiers("Strength", 1);
        setRaceAbilityScoreModifiers("Dexterity", 1);
        setRaceAbilityScoreModifiers("Constitution", 1);
        setRaceAbilityScoreModifiers("Charisma", 1);
        setRaceAbilityScoreModifiers("Intelligence", 1);
        setRaceAbilityScoreModifiers("Wisdom", 1);
        setRaceLanguages(new String[]{"Common"});
        setRaceTraits(new String[]{"Extra Language"});

    }
}
