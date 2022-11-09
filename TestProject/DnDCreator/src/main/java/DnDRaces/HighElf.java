package DnDRaces;

public class HighElf extends Elf {

    public HighElf() {
        super("High Elf", 100, 750, "medium", 30);
        setRaceAbilityScoreModifiers("Intelligence", 1);
        addRaceTrait("Elf Weapon Training");
        addRaceTrait("Cantrip");
        addRaceTrait("Extra Language");
    }
}
