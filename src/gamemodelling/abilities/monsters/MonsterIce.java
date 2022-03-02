package gamemodelling.abilities.monsters;

import gamemodelling.Ability;

public class MonsterIce extends Ability {
    public MonsterIce(int initLvl) {
        super(initLvl, 9);
    }

    @Override
    public void play() {

    }

    @Override
    public String getName() {
        return "Ice" + '(' + getLevel() + ')';
    }
}
