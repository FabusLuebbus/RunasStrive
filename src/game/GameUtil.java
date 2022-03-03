package game;

import gamemodelling.Ability;
import gamemodelling.Entity;
import gamemodelling.OffensiveAbility;
import gamemodelling.abilities.DamageType;
import gamemodelling.monsters.Monster;
import gamemodelling.monsters.Type;

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

    public static void attackMonster(Monster monster, OffensiveAbility ability) {
        DamageType type = ability.getDmgType();
        int baseDamage = ability.getBaseDamage();
        int actualDamage = baseDamage;

        switch (type.getBasicType()) {
            case "physical":
                if (type == DamageType.ANTI_FOCUS) {
                    if (monster.isChanneling()) {
                        monster.setChanneling(false);
                    }
                }
                actualDamage -= monster.getBlockAmount();
                break;

            case "magical":

                if (monster.getType() == type.getEffective()) {
                    actualDamage += (2 * ability.getLevel());
                }
                actualDamage -= monster.getDeflectAmount();
                break;
        }
        if (actualDamage < 0) {
            actualDamage = 0;
        }
        monster.removeHealth(actualDamage);
        System.out.println(monster.getClass().getSimpleName() + " takes " + actualDamage + ability.getShortType());
    }

    /*public static void attackRuna(Ability ability) {
        DamageType type = ability.getDmgType();
    }
    
     */
}
