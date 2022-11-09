package DnDRaces;

public class Drow extends Elf{

    public Drow() {
        super("Drow", 100, 750, "medium", 30);
        setRaceAbilityScoreModifiers("Charisma", 1);
        addRaceTrait("Superior Darkvision");
        addRaceTrait("Sunlight Sensitivity");
        addRaceTrait("Drow Magic");
        addRaceTrait("Drow Weapon Training");
    }
}
