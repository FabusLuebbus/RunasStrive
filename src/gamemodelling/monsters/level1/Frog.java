package gamemodelling.monsters.level1;

import gamemodelling.abilities.monsters.MonsterFocus;
import gamemodelling.abilities.monsters.MonsterWater;
import gamemodelling.monsters.Monster;
import gamemodelling.monsters.Type;

import java.util.List;

public class Frog extends Monster {
    protected final Type type = Type.WATER;

    protected final boolean boss = false;

    public Frog() {
        super(16, 1);
        abilityQueue.addAll(List.of(new MonsterFocus(1), new MonsterWater(1)));
    }
}
