package DnDMonsters;

import java.util.Map;
import java.util.HashMap;

public class Monster {

    public static void main(String[] args) {

        Map<String, Integer> hitDiceBySize = new HashMap<>();
        // key = size, value = die type (D4 - D20)
        hitDiceBySize.put("tiny", 4);
        hitDiceBySize.put("small", 6);
        hitDiceBySize.put("medium", 8);
        hitDiceBySize.put("large", 10);
        hitDiceBySize.put("huge", 12);
        hitDiceBySize.put("gargantuan", 20);

    }

}
