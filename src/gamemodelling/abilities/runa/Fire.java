package gamemodelling.abilities.runa;

import gamemodelling.entities.Entity;
import gamemodelling.abilities.MagicalOffensive;
import gamemodelling.entities.runa.Runa;
import gamemodelling.abilities.DamageType;



public class Fire extends MagicalOffensive {


    public Fire(int initLvl) {
        super(initLvl, 10, DamageType.FIRE);
    }

    @Override
    public void use(Entity user, Entity target) {
        Runa runa = (Runa) user;
        setBaseDamage((2 * getLevel() + 5) * runa.getFocusPoints());
        runa.removeFocus(1);
        dealDamage(runa, target, this);
    }
}
