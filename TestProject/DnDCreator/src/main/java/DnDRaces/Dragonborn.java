package DnDRaces;

public class Dragonborn extends DnDRace {

    public Dragonborn() {
        super("Dragonborn", 15, 80, "medium", 30);
        setRaceAbilityScoreModifiers("Strength", 2);
        setRaceAbilityScoreModifiers("Charisma", 1);
        setRaceLanguages(new String[]{"Common", "Draconic"});
        setRaceTraits(new String[]{"Draconic Ancestry", "Breath Weapon", "Damage Resistance"});
    }
}
