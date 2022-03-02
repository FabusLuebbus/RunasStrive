package gamemodelling.abilities.monsters;

import gamemodelling.Ability;

public class MonsterFire extends Ability {
    public MonsterFire(int initLvl) {
        super(initLvl, 10);
    }

    @Override
    public void play() {

    }

    @Override
    public String getName() {
        return "Fire" + '(' + getLevel() + ')';
    }
}
