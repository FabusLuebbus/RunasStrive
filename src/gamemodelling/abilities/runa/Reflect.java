package gamemodelling.abilities.runa;

import gamemodelling.entities.Entity;
import gamemodelling.abilities.NonOffensiveAbility;
import gamemodelling.entities.runa.Runa;

public class Reflect extends NonOffensiveAbility {
    public Reflect(int initLvl) {
        super(initLvl, 7);
    }

    @Override
    public void use(Entity user) {
        Runa runa = (Runa) user;
        runa.setMagicalReflect(10 * getLevel());
    }
}
