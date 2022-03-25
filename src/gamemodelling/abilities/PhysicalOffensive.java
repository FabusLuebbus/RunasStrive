package gamemodelling.abilities;

import UI.newUI;
import gamemodelling.entities.Entity;

public abstract class PhysicalOffensive extends OffensiveAbility {
    private static final String PHY_DMG = "phy. damage";


    public PhysicalOffensive(int initLvl, int ip, DamageType dmgType) {
        super(initLvl, ip, dmgType);
        setNeedsFocus(false);
    }

    public void dealDamage(Entity target, OffensiveAbility ability) {
        int actualDamage = getBaseDamage();
        if (getDmgType() == DamageType.ANTI_FOCUS) {
            if (target.isChanneling()) {
                target.setChanneling(false);
            }
        }
        actualDamage -= target.getPhysicalResistance();
        if (actualDamage > 0) {
            target.removeHealth(actualDamage, PHY_DMG);
        }
    }

    @Override
    public void play(Entity user, Entity target, newUI newUI) {
        newUI.stateAbilityUsage(user, this);
        use(user, target, newUI);
    }

    public abstract void use(Entity user, Entity target, newUI newUI);

}
