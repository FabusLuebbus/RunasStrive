package gamemodelling.abilities.runa;

import gamemodelling.entities.Entity;
import gamemodelling.abilities.MagicalOffensive;
import gamemodelling.entities.runa.Runa;
import gamemodelling.abilities.DamageType;



public class Lightning extends MagicalOffensive {
   public Lightning(int initLvl) {
        super(initLvl, 11, DamageType.LIGHTNING);
    }

    @Override
    public void use(Entity user, Entity target) {
        Runa runa = (Runa) user;
        setBaseDamage((2 * getLevel() + 5) * runa.getAvailableFocusPoints() + 2);
        runa.removeFocus(runa.getAvailableFocusPoints());
        dealDamage(runa, target, this);
    }
}
