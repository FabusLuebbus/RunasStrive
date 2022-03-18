package gamemodelling.abilities;

import gamemodelling.entities.Entity;

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
