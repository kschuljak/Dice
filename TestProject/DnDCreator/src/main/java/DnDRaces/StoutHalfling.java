package DnDRaces;

public class StoutHalfling extends Halfling {

    public StoutHalfling() {
        super("Stout Halfling", 20, 150, "small", 25);
        setRaceAbilityScoreModifiers("Constitution", 1);
        addRaceTrait("Stout Resilience");
    }
}
