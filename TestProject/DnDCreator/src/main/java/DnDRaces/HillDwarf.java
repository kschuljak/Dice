package DnDRaces;

public class HillDwarf extends Dwarf {

    public HillDwarf() {
        super("Hill Dwarf", 50, 350, "medium", 25);
        addRaceTrait("Dwarven Toughness");
        setRaceAbilityScoreModifiers("Wisdom", 1);
    }
}
