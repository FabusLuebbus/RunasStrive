package gamemodelling.abilities.runa;

import gamemodelling.entities.Entity;
import gamemodelling.abilities.MagicalOffensive;
import gamemodelling.entities.runa.Runa;
import gamemodelling.abilities.DamageType;



public class Water extends MagicalOffensive {
    public Water(int initLvl) {
        super(initLvl, 8, DamageType.WATER);
    }

    @Override
    public void use(Entity user, Entity target) {
        Runa runa = (Runa) user;
        setBaseDamage((2 * getLevel() + 4) * runa.getFocusPoints());
        runa.removeFocus(1);
        dealDamage(runa, target, this);
    }
}
