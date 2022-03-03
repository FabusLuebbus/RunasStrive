package gamemodelling.abilities.monsters;

import gamemodelling.Ability;
import gamemodelling.Entity;
import gamemodelling.monsters.Monster;

public class Block extends MonsterAbility {
    public Block(int initLvl) {
        super(initLvl, 7);
    }

    @Override
    public void use(Monster monster, Entity target) {

    }
}
