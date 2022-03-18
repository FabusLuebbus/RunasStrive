package gamemodelling.abilities;

import gamemodelling.entities.Entity;

public abstract class PhysicalOffensive extends OffensiveAbility {
    private static final String PHY_DMG = "phy. damage";


    public PhysicalOffensive(int initLvl, int ip, DamageType dmgType) {
        super(initLvl, ip, dmgType);
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

}
