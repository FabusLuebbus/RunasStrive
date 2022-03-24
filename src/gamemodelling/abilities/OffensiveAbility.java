package gamemodelling.abilities;

import UI.newUI;
import gamemodelling.entities.Entity;
import states.Stage;

public abstract class OffensiveAbility extends Ability {
    private DamageType dmgType;
    private int baseDamage = 0;


    public OffensiveAbility(int initLvl, int ip, DamageType dmgType) {
        super(initLvl, ip);
        this.dmgType = dmgType;
    }

    public void setBaseDamage(int baseDamage) {
        this.baseDamage = baseDamage;
    }

    public int getBaseDamage() {
        return baseDamage;
    }

    public void addBaseDamage(int additionalDamage) {
        baseDamage += additionalDamage;
    }

    public DamageType getDmgType() {
        return dmgType;
    }

    @Override
    public void play(Entity user, newUI newUI) {
        newUI.stateAbilityUsage(user, this);
        play(user, newUI.selectTarget(), newUI);
    }
}
