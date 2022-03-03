package gamemodelling.abilities.monsters;

import gamemodelling.Ability;
import gamemodelling.Entity;
import gamemodelling.monsters.Monster;

public class Deflect extends MonsterAbility {
    public Deflect(int initLvl) {
        super(initLvl, 8);
    }

    @Override
    public void use(Monster monster, Entity target) {

    }
}
