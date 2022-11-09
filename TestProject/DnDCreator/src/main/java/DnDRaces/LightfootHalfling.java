package DnDRaces;

public class LightfootHalfling extends Halfling{

    public LightfootHalfling() {
        super("Lightfoot Halfling", 20, 150, "small", 25);
        setRaceAbilityScoreModifiers("Charisma", 1);
        addRaceTrait("Naturally Stealthy");
    }
}
