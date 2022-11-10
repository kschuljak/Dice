package CharacterSheet;

public class AbilityScoreModifiers {

    public int getAbilityScoreModifier(int score) {
        if (score == 30) return 10;
        if (score >= 28) return 9;
        if (score >= 26) return 8;
        if (score >= 24) return 7;
        if (score >= 22) return 6;
        if (score >= 20) return 5;
        if (score >= 18) return 4;
        if (score >= 16) return 3;
        if (score >= 14) return 2;
        if (score >= 12) return 1;
        if (score >= 10) return 0;
        if (score >= 8) return -1;
        if (score >= 6) return -2;
        if (score >= 4) return -3;
        if (score >= 2) return -4;
        if (score == 1) return -5;
        return 0;
    }

    public int getProficiencyBonus(int level) {
        if (level >= 17) return 6;
        if (level >= 13) return 5;
        if (level >= 9) return 4;
        if (level >= 5) return 3;
        return 2;
    }

}
