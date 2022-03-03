package gamemodelling.abilities.runa;

import gamemodelling.Ability;
import gamemodelling.Entity;
import gamemodelling.Runa;
import gamemodelling.abilities.DamageType;
import gamemodelling.monsters.Monster;

public abstract class RunaAbility extends Ability {
    public RunaAbility(int initLvl, int orderingNumber) {
        super(initLvl, orderingNumber);
    }

    public RunaAbility(int initLvl, int orderingNumber, DamageType dmgType) {
        super(initLvl, orderingNumber, dmgType);
    }

    public abstract void use(Runa runa, Entity target);

    @Override
    public void play(Entity user, Entity target) {
        /*
        if (!checkIfAllowed()) {
            return;
        }
        
         */
        System.out.println("Runa uses " + this.getName());
        this.use((Runa) user, target);
    }
}
