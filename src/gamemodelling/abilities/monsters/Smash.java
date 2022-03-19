package gamemodelling.abilities.monsters;

import UI.newUI;
import gamemodelling.entities.Entity;
import gamemodelling.abilities.PhysicalOffensive;
import gamemodelling.abilities.DamageType;



public class Smash extends PhysicalOffensive {
    public Smash(int initLvl) {
        super(initLvl, 3, DamageType.PHYSICAL);
    }

    @Override
    public void use(Entity user, Entity target, newUI newUI) {
        setBaseDamage(8 * getLevel());
        dealDamage(target, this);
    }
}
