package DnDRaces;

import java.util.*;

public class DnDRace {

    protected String dndRaceName;
    protected int ageOfAdulthood;
    protected int averageLifespan;
    protected String characterSize;
    protected int characterSpeed;
    protected List<String> raceLanguages = new ArrayList<>();
    protected List<String> dndSubraceOptions = new ArrayList<>();
    protected Map<String, Integer> raceAbilityScoreModifiers = new HashMap<>();
    protected List<String> raceTraits = new ArrayList<>();

    public String getDndRaceName() {
        return dndRaceName;
    }
    public void setDndRaceName(String dndRaceName) {
        this.dndRaceName = dndRaceName;
    }

    public int getAgeOfAdulthood() {
        return ageOfAdulthood;
    }
    public void setAgeOfAdulthood(int ageOfAdulthood) {
        this.ageOfAdulthood = ageOfAdulthood;
    }

    public int getAverageLifespan() {
        return averageLifespan;
    }
    public void setAverageLifespan(int averageLifespan) {
        this.averageLifespan = averageLifespan;
    }

    public String getCharacterSize() {
        return characterSize;
    }
    public void setCharacterSize(String characterSize) {
        this.characterSize = characterSize;
    }

    public int getCharacterSpeed() {
        return characterSpeed;
    }
    public void setCharacterSpeed(int characterSpeed) {
        this.characterSpeed = characterSpeed;
    }

    public String[] getRaceLanguages() {
        return raceLanguages.toArray(new String[0]);
    }
    public void setRaceLanguages(String[] raceLanguages) {
        List<String> raceLanguagesList = new ArrayList<>();
        Collections.addAll(raceLanguagesList, raceLanguages);
        this.raceLanguages = raceLanguagesList;
    }

    public String[] getDndSubraceOptions() {
        return dndSubraceOptions.toArray(new String[0]);
    }
    public void setDndSubraceOptions(String[] dndSubraceOptions) {
        List<String> dndSubraceOptionsList = new ArrayList<>();
        Collections.addAll(dndSubraceOptionsList, dndSubraceOptions);
        this.dndSubraceOptions = dndSubraceOptionsList;
    }

    public Map<String, Integer> getRaceAbilityScoreModifiers() {
        return raceAbilityScoreModifiers;
    }
    public void setRaceAbilityScoreModifiers(String ability, int abilityScoreModifier) {
        Map<String, Integer> raceAbilityScoreModifiersMap = getRaceAbilityScoreModifiers();
        raceAbilityScoreModifiersMap.put(ability, (Integer) abilityScoreModifier);
        this.raceAbilityScoreModifiers = raceAbilityScoreModifiersMap;
    }

    public String[] getRaceTraits() {
        return raceTraits.toArray(new String[0]);
    }
    public void setRaceTraits(String[] raceTraits) {
        List<String> raceTraitsList = new ArrayList<>();
        Collections.addAll(raceTraitsList, raceTraits);
        this.raceTraits = raceTraitsList;
    }
    public void addRaceTrait(String raceTrait) {
        String[] raceTraitsArray = this.getRaceTraits();
        List<String> raceTraitsList = Arrays.asList(raceTraitsArray);
        raceTraitsList.add(raceTrait);
        this.raceTraits = raceTraitsList;
    }

    public DnDRace(String dndRaceName, int ageOfAdulthood, int averageLifespan, String characterSize, int characterSpeed) {
        this.dndRaceName = dndRaceName;
        this.ageOfAdulthood = ageOfAdulthood;
        this.averageLifespan = averageLifespan;
        this.characterSize = characterSize;
        this.characterSpeed = characterSpeed;
    }
}
