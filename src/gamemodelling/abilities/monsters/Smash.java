package gamemodelling.abilities.monsters;

import gamemodelling.Ability;
import gamemodelling.Entity;
import gamemodelling.monsters.Monster;

public class Smash extends MonsterAbility {
    public Smash(int initLvl) {
        super(initLvl, 3);
    }

    @Override
    public void use(Monster monster, Entity target) {

    }
}
