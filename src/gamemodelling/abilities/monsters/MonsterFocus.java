package gamemodelling.abilities.monsters;

import gamemodelling.Ability;

public class MonsterFocus extends Ability {
    public MonsterFocus(int initLvl) {
        super(initLvl, 5);
    }

    @Override
    public void play() {

    }

    @Override
    public String getName() {
        return "Focus" + '(' + getLevel() + ')';
    }
}
