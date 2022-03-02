package gamemodelling.abilities.monsters;

import gamemodelling.Ability;
import gamemodelling.Entity;
import gamemodelling.monsters.Monster;

public class Claw extends MonsterAbility {
    public Claw(int initLvl) {
        super(initLvl, 2);
    }

    @Override
    public void use(Monster monster, Entity target) {

    }
}
