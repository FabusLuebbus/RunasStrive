package gamemodelling.abilities.monsters;

import gamemodelling.Ability;
import gamemodelling.Entity;
import gamemodelling.monsters.Monster;

public class MonsterLightning extends MonsterAbility {
    public MonsterLightning(int initLvl) {
        super(initLvl, 12);
    }

    @Override
    public String getName() {
        return "Lightning" + '(' + getLevel() + ')';
    }

    @Override
    public void use(Monster monster, Entity target) {

    }
}
