package DnDRaces;

public class MountainDwarf extends Dwarf {

    public MountainDwarf() {
        super("Mountain Dwarf", 50, 350, "medium", 25);
        addRaceTrait("Dwarven Armor Training");
        setRaceAbilityScoreModifiers("Strength", 2);
    }

}
