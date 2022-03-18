package gamemodelling.abilities;

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
    public String getShortType() {
        return ' ' + dmgType.toString().substring(0, 3) + ". damage";
    }

    public abstract void use(Entity user, Entity target);


    public void play(Entity user, Entity target, Stage stage) {
        /* //TODO
        if (!checkIfAllowed()) {
            return;
        }

         */
        System.out.println(user.getName() + " uses " + this.getName());
        use(user, target);
    }
}
