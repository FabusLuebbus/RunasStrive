package gamemodelling.abilities.monsters;

import gamemodelling.Ability;

public class MonsterLightning extends Ability {
    public MonsterLightning(int initLvl) {
        super(initLvl, 11);
    }

    @Override
    public void play() {

    }

    @Override
    public String getName() {
        return "Lightning" + '(' + getLevel() + ')';
    }
}
