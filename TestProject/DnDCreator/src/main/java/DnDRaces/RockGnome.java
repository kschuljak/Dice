package DnDRaces;

public class RockGnome extends Gnome {

    public RockGnome() {
        super("Rock Gnome", 40, 450, "small", 25);
        setRaceAbilityScoreModifiers("Constitution", 1);
        addRaceTrait("Artificer's Lore");
        addRaceTrait("Tinker");
    }
}
