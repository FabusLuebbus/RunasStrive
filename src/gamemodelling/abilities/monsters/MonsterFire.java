package gamemodelling.abilities.monsters;

import gamemodelling.Ability;
import gamemodelling.Entity;
import gamemodelling.monsters.Monster;

public class MonsterFire extends MonsterAbility {
    public MonsterFire(int initLvl) {
        super(initLvl, 11);
    }

    @Override
    public String getName() {
        return "Fire" + '(' + getLevel() + ')';
    }

    @Override
    public void use(Monster monster, Entity target) {

    }
}
