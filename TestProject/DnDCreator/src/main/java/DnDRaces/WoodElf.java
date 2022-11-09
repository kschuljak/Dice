package DnDRaces;

public class WoodElf extends Elf{

    public WoodElf() {
        super("Wood Elf", 100, 750, "medium", 35);
        setRaceAbilityScoreModifiers("Wisdom", 1);
        addRaceTrait("Elf Weapon Training");
        addRaceTrait("Fleet of Foot");
        addRaceTrait("Mask of the Wild");
    }
}
