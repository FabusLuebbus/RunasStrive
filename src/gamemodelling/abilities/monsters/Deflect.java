package gamemodelling.abilities.monsters;

import UI.newUI;
import gamemodelling.entities.Entity;
import gamemodelling.abilities.NonOffensiveAbility;

public class Deflect extends NonOffensiveAbility {
    public Deflect(int initLvl) {
        super(initLvl, 8);
    }

    @Override
    public void use(Entity user) {
        user.setMagicalBlock(11 * getLevel() + 2);
    }

    @Override
    public void play(Entity user, Entity target, newUI newUI) {

    }
}
