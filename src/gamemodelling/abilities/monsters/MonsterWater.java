package gamemodelling.abilities.monsters;

import gamemodelling.entities.Entity;
import gamemodelling.abilities.MagicalOffensive;
import gamemodelling.abilities.DamageType;



public class MonsterWater extends MagicalOffensive {
    public MonsterWater(int initLvl) {
        super(initLvl, 9, DamageType.WATER);
    }

    @Override
    public String getName() {
        return "Water" + '(' + getLevel() + ')';
    }

    @Override
    public void use(Entity user, Entity target) {
        setBaseDamage(8 * getLevel() + 2);
        user.removeFocus(getLevel());
        dealDamage(user, target, this);
    }
}
