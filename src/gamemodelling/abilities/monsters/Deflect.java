package gamemodelling.abilities.monsters;

import gamemodelling.Ability;
import gamemodelling.Entity;
import gamemodelling.monsters.Monster;

public class Deflect extends MonsterAbility {
    public Deflect(int initLvl) {
        super(initLvl, 7);
    }

    @Override
    public void use(Monster monster, Entity target) {

    }
}
