package gamemodelling.abilities.monsters;

import gamemodelling.entities.Entity;
import gamemodelling.abilities.NonOffensiveAbility;

public class Block extends NonOffensiveAbility {
    public Block(int initLvl) {
        super(initLvl, 7);
    }

    @Override
    public void use(Entity user) {
        user.setPhysicalResistance(7 * getLevel());
    }
}
