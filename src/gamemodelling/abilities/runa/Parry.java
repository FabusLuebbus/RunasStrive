package gamemodelling.abilities.runa;

import gamemodelling.entities.Entity;
import gamemodelling.abilities.NonOffensiveAbility;
import gamemodelling.entities.runa.Runa;

public class Parry extends NonOffensiveAbility {
    public Parry(int initLvl) {
        super(initLvl, 5);
    }

    @Override
    public void use(Entity user) {
        Runa runa = (Runa) user;
        runa.setPhysicalResistance(7 * getLevel());
    }
}
