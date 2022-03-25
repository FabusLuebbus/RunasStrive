package gamemodelling.abilities.monsters;

import UI.newUI;
import gamemodelling.entities.Entity;
import gamemodelling.abilities.PhysicalOffensive;
import gamemodelling.abilities.DamageType;
import gamemodelling.entities.monsters.Monster;



public class Scratch extends PhysicalOffensive {
    public Scratch(int initLvl) {
        super(initLvl, 1, DamageType.ANTI_FOCUS);
    }

    @Override
    public void use(Entity user, Entity target, newUI newUI) {
        setBaseDamage(5 * getLevel());
        dealDamage(target, this);
    }
}
