package gamemodelling.abilities.runa;

import gamemodelling.Ability;

public abstract class RunaAbility extends Ability {


    public RunaAbility(int initLvl, int orderingNumber) {
        super(initLvl, orderingNumber);
    }

    @Override
    public void play() {
        if (!checkIfAllowed()) {
            return;
        }
        System.out.println("Runa uses" + this.getName());
    }
}
