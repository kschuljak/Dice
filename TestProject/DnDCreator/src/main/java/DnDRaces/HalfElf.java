package DnDRaces;

public class HalfElf extends DnDRace {

    public HalfElf() {
        super("Half-Elf", 20, 180, "medium", 30);
        setRaceAbilityScoreModifiers("Charisma", 2);
        setRaceLanguages(new String[]{"Common", "Elvish"});
        setRaceTraits(new String[]{"Darkvision", "Fey Ancestry", "Skill Versatility", "Extra Language", "2x Ability Score + 1"});
    }
}
