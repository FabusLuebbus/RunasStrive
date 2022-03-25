package gamemodelling.abilities.runa;

import gamemodelling.entities.Entity;
import gamemodelling.abilities.MagicalOffensive;
import gamemodelling.entities.runa.Runa;
import gamemodelling.abilities.DamageType;



public class Ice extends MagicalOffensive {
    public Ice(int initLvl) {
        super(initLvl, 9, DamageType.ICE);
    }

    @Override
    public void use(Entity user, Entity target) {
        Runa runa = (Runa) user;
        setBaseDamage((2 * getLevel() + 4) * runa.getFocusPoints() + 2);
        runa.removeFocus(1);
        dealDamage(runa, target, this);
    }
}
