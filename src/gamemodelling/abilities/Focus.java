package gamemodelling.abilities;

import gamemodelling.Ability;
import gamemodelling.Entity;
import gamemodelling.NonOffensiveAbility;
import gamemodelling.Runa;

public class Focus extends NonOffensiveAbility {
    public Focus(int initLvl) {
        super(initLvl, 6);
    }

    @Override
    public void use(Entity user) {
        user.setChanneling(true);
        user.setPotentialFocusGain(getLevel());
    }
}
