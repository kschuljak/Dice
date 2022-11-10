package DnDMonsters;

import java.util.HashMap;
import java.util.Map;

public abstract class Monster {

    public static void main(String[] args) {

        Map<String, Integer> monsterHitDiceBySize = new HashMap<>();
        // key = size, value = die type (D4 - D20)
        monsterHitDiceBySize.put("tiny", 4);
        monsterHitDiceBySize.put("small", 6);
        monsterHitDiceBySize.put("medium", 8);
        monsterHitDiceBySize.put("large", 10);
        monsterHitDiceBySize.put("huge", 12);
        monsterHitDiceBySize.put("gargantuan", 20);

    }

}
