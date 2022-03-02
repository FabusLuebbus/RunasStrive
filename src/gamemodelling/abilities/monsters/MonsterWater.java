package gamemodelling.abilities.monsters;

import gamemodelling.Ability;
import gamemodelling.Entity;
import gamemodelling.monsters.Monster;

public class MonsterWater extends MonsterAbility {
    public MonsterWater(int initLvl) {
        super(initLvl, 8);
    }

    @Override
    public String getName() {
        return "Water" + '(' + getLevel() + ')';
    }

    @Override
    public void use(Monster monster, Entity target) {

    }
}
