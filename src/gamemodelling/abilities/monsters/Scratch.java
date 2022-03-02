package gamemodelling.abilities.monsters;

import gamemodelling.Ability;
import gamemodelling.Entity;
import gamemodelling.monsters.Monster;

public class Scratch extends MonsterAbility {
    public Scratch(int initLvl) {
        super(initLvl, 1);
    }

    @Override
    public void use(Monster monster, Entity target) {

    }
}
