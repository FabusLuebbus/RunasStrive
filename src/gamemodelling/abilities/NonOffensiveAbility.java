package gamemodelling.abilities;

import UI.newUI;
import gamemodelling.entities.Entity;
import states.Stage;

public abstract class NonOffensiveAbility extends Ability {

    public NonOffensiveAbility(int initLvl, int ip) {
        super(initLvl, ip);
        setNeedsFocus(false);
    }

    public abstract void use(Entity user);

    @Override
    public void play(Entity user, Entity target, newUI newUI) {
        play(user, newUI);
    }

    @Override
    public void play(Entity user, newUI newUI) {
        newUI.stateAbilityUsage(user, this);
        use(user);
    }
}
