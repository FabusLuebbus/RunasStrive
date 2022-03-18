package gamemodelling.abilities.monsters;

import gamemodelling.entities.Entity;
import gamemodelling.abilities.MagicalOffensive;
import gamemodelling.abilities.DamageType;



public class MonsterLightning extends MagicalOffensive {
    public MonsterLightning(int initLvl) {
        super(initLvl, 12, DamageType.LIGHTNING);
    }

    @Override
    public String getName() {
        return "Lightning" + '(' + getLevel() + ')';
    }

    @Override
    public void use(Entity user, Entity target) {
        setBaseDamage(14 * getLevel() + 2);
        user.removeFocus(getLevel());
        dealDamage(user, target, this);
    }
}
