package gamemodelling.abilities.runa;

import gamemodelling.Ability;
import gamemodelling.Entity;
import gamemodelling.NonOffensiveAbility;
import gamemodelling.Runa;

public class Parry extends NonOffensiveAbility {
    public Parry(int initLvl) {
        super(initLvl, 5);
    }

    @Override
    public void use(Runa runa, Entity target) {

    }
}
