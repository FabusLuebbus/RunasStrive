package gamemodelling.abilities.monsters;

import gamemodelling.Ability;

public class MonsterWater extends Ability {
    public MonsterWater(int initLvl) {
        super(initLvl, 8);
    }

    @Override
    public void play() {

    }

    @Override
    public String getName() {
        return "Water" + '(' + getLevel() + ')';
    }
}
