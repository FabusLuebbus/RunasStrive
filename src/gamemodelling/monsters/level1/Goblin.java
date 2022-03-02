package gamemodelling.monsters.level1;

import gamemodelling.abilities.monsters.Deflect;
import gamemodelling.abilities.monsters.Smash;
import gamemodelling.monsters.Monster;
import gamemodelling.monsters.Type;

import java.util.List;

public class Goblin extends Monster {
    protected final Type type = Type.BASIC;

    protected final boolean boss = false;

    public Goblin() {
        super(12, 6);
        abilityQueue.addAll(List.of(new Smash(1), new Deflect(1)));
    }
}
