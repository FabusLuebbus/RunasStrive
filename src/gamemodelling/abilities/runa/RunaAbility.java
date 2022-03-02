package gamemodelling.abilities.runa;

import gamemodelling.Ability;
import gamemodelling.Entity;
import gamemodelling.Runa;
import gamemodelling.monsters.Monster;

public abstract class RunaAbility extends Ability {


    public RunaAbility(int initLvl, int orderingNumber) {
        super(initLvl, orderingNumber);
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
