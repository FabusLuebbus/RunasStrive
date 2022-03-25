package gamemodelling.abilities.runa;

import UI.newUI;
import gamemodelling.entities.Entity;
import gamemodelling.abilities.PhysicalOffensive;
import gamemodelling.entities.runa.Runa;
import gamemodelling.abilities.DamageType;



public class Swing extends PhysicalOffensive {
    public Swing(int initLvl) {
        super(initLvl, 2, DamageType.ANTI_FOCUS);
    }

    @Override
    public void use(Entity user, Entity target, newUI newUI) {
        Runa runa = (Runa) user;
        int diceRoll = newUI.getDiceRoll(runa.getMaxFocusPoints());
        //todo quitint
        if (diceRoll == -1) {
            return;
        }
        setBaseDamage(5 * getLevel() + diceRoll);
        dealDamage(target, this);
    }
}
