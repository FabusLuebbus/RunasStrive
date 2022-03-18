package game;

import gamemodelling.abilities.Ability;
import gamemodelling.entities.Entity;
import gamemodelling.abilities.OffensiveAbility;
import gamemodelling.entities.runa.Runa;
import gamemodelling.abilities.DamageType;
import gamemodelling.entities.monsters.Monster;
import states.Stage;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class GameUtil {
    //TODO UI class


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
