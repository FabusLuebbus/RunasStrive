package gamemodelling.abilities.runa;

import UI.newUI;
import gamemodelling.entities.Entity;
import gamemodelling.abilities.PhysicalOffensive;
import gamemodelling.entities.runa.Runa;
import gamemodelling.abilities.DamageType;



public class Slash extends PhysicalOffensive {
    public Slash(int initLvl) {
        super(initLvl, 1, DamageType.ANTI_FOCUS);
    }

    @Override
    public void use(Entity user, Entity target, newUI newUI) {
        Runa runa = (Runa) user;
        int diceRoll = newUI.getDiceRoll(runa.getMaxFocusPoints());
        setBaseDamage(4 * getLevel() + diceRoll);
        dealDamage(target, this);
    }
}
