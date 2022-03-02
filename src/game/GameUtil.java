package game;

import gamemodelling.Ability;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class GameUtil {
    public static void moveCards(String key, Map<String, Ability> from, Map<String, Ability> to) {
        to.put(from.get(key).getName(), from.get(key));
        from.remove(key);
    }

    public static void moveCards(Set<String> cardsKeySet, Map<String, Ability> from, List<Ability> to) {
        for (String key : cardsKeySet) {
            to.add(from.get(key));
            from.remove(key);
        }
    }
}
