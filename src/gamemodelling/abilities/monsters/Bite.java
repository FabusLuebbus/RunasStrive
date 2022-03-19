package gamemodelling.abilities.monsters;

import UI.newUI;
import gamemodelling.entities.Entity;
import gamemodelling.abilities.PhysicalOffensive;
import gamemodelling.abilities.DamageType;


public class Bite extends PhysicalOffensive {
    public Bite(int initLvl) {
        super(initLvl, 4, DamageType.PHYSICAL);
    }

    @Override
    public void use(Entity user, Entity target, newUI newUI) {
        setBaseDamage(10 * getLevel());
        dealDamage(target, this);
    }
}
