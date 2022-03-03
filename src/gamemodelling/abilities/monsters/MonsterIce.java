package gamemodelling.abilities.monsters;

import gamemodelling.Ability;
import gamemodelling.Entity;
import gamemodelling.monsters.Monster;

public class MonsterIce extends MonsterAbility {
    public MonsterIce(int initLvl) {
        super(initLvl, 10);
    }

    @Override
    public String getName() {
        return "Ice" + '(' + getLevel() + ')';
    }

    @Override
    public void use(Monster monster, Entity target) {

    }
}
