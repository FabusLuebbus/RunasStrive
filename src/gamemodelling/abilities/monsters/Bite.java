package gamemodelling.abilities.monsters;

import gamemodelling.Ability;
import gamemodelling.Entity;
import gamemodelling.monsters.Monster;

public class Bite extends MonsterAbility {
    public Bite(int initLvl) {
        super(initLvl, 4);
    }

    @Override
    public void use(Monster monster, Entity target) {

    }
}
