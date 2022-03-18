package gamemodelling.abilities.runa;

import UI.UI;
import gamemodelling.entities.Entity;
import gamemodelling.abilities.PhysicalOffensive;
import gamemodelling.entities.runa.Runa;
import gamemodelling.abilities.DamageType;



public class Thrust extends PhysicalOffensive {
    public Thrust(int initLvl) {
        super(initLvl, 3, DamageType.PHYSICAL);
    }

    @Override
    public void use(Entity user, Entity target) {
        Runa runa = (Runa) user;
        int diceRoll = UI.getDiceRoll(runa.getMaxFocusPoints());
        setBaseDamage(6 * getLevel() + diceRoll);
        if (diceRoll > 5) {
            addBaseDamage(4 * getLevel());
        }
        dealDamage(target, this);
    }
}
