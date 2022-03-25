package gamemodelling.abilities;

import UI.newUI;
import gamemodelling.entities.Entity;

public abstract class MagicalOffensive extends OffensiveAbility {
    private static final String MAG_DMG = "mag. damage";
    private int reflectDamage = 0;

    public MagicalOffensive(int initLvl, int ip, DamageType dmgType) {
        super(initLvl, ip, dmgType);
        setNeedsFocus(true);
    }

    @Override
    public void play(Entity user, Entity target, newUI newUI) {
        newUI.stateAbilityUsage(user, this);
        use(user, target);
    }

    public abstract void use(Entity user, Entity target);

    /**
     * decided to make it possible for every entity to have magical block and reflect since both effects already exist
     * reflect is based on base damage, so if a future user were to add reflect damage for mobs this can be modified by
     * changing from getBaseDamage() to actualDamage in reflect if statement
     * also effective bonus mechanic is technically available to every entity
     *
     *
     * @param user
     * @param target
     * @param ability
     */
    public void dealDamage(Entity user, Entity target, OffensiveAbility ability) {
        int actualDamage = getBaseDamage();
        if (ability.getDmgType().getEffective() != null  &&  ability.getDmgType().getEffective() == target.getType()) {
            actualDamage += 2 * getLevel();
        }
        if (target.getMagicalBlock() > 0) {
            actualDamage -= target.getMagicalBlock();
        }
        if (target.getMagicalReflect() > 0) {
            reflectDamage = Math.min(target.getMagicalReflect(), getBaseDamage());
            actualDamage -= target.getMagicalReflect();
        }
        if (actualDamage > 0) {
            target.removeHealth(actualDamage, MAG_DMG);
        }
        if (reflectDamage > 0) {
            user.removeHealth(reflectDamage, MAG_DMG);
        }
    }
}
