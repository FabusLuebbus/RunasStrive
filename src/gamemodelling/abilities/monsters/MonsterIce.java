package gamemodelling.abilities.monsters;

import gamemodelling.entities.Entity;
import gamemodelling.abilities.MagicalOffensive;
import gamemodelling.abilities.DamageType;



public class MonsterIce extends MagicalOffensive {
    public MonsterIce(int initLvl) {
        super(initLvl, 10, DamageType.ICE);
    }

    @Override
    public String getName() {
        return "Ice" + '(' + getLevel() + ')';
    }

    @Override
    public void use(Entity user, Entity target) {
        setBaseDamage(10 * getLevel() + 2);
        user.removeFocus(getLevel());
        dealDamage(user, target, this);
    }
}
