package gamemodelling.abilities.monsters;

import gamemodelling.entities.Entity;
import gamemodelling.abilities.PhysicalOffensive;
import gamemodelling.abilities.DamageType;


public class Claw extends PhysicalOffensive {
    public Claw(int initLvl) {
        super(initLvl, 2, DamageType.ANTI_FOCUS);
    }

    @Override
    public void use(Entity user, Entity target) {
        setBaseDamage(6 * getLevel());
        dealDamage(target, this);
    }
}
