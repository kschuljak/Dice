package DnDRaces;

public class ForestGnome extends Gnome {

    public ForestGnome() {
        super("Forest Gnome", 40, 450, "small", 25);
        setRaceAbilityScoreModifiers("Dexterity", 1);
        addRaceTrait("Natural Illusionist");
        addRaceTrait("Speak with Small Beasts");
    }
}
