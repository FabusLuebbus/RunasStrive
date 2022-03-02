package gamemodelling.abilities.monsters;

import gamemodelling.Ability;
import gamemodelling.Entity;
import gamemodelling.monsters.Monster;

public class MonsterFocus extends MonsterAbility {
    public MonsterFocus(int initLvl) {
        super(initLvl, 5);
    }

    @Override
    public String getName() {
        return "Focus" + '(' + getLevel() + ')';
    }

    @Override
    public void use(Monster monster, Entity target) {

    }
}
