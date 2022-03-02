package game;

import gameModelling.Card;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GameUtil {
    public static void moveCards(String key, Map<String, Card> from, Map<String, Card> to) {
        to.put(from.get(key).getName(), from.get(key));
        from.remove(key);
    }

    public static void moveCards(Set<String> cardsKeySet, Map<String, Card> from, Map<String, Card> to) {
        for (String key : cardsKeySet) {
            to.put(from.get(key).getName(), from.get(key));
            from.remove(key);
        }
    }
}
