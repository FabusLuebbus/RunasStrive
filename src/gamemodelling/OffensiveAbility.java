package gamemodelling;

import gamemodelling.abilities.DamageType;

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
    public String getShortType() {
        return ' ' + dmgType.getBasicType().substring(0, 3) + ". damage";
    }

    public abstract void use(Entity user, Entity target);

    @Override
    public void play(Entity user, Entity target) {
        /*
        if (!checkIfAllowed()) {
            return;
        }

         */
        System.out.println(user.getClass().getSimpleName() + " uses " + this.getName());
        this.use(user, target);
    }
}
