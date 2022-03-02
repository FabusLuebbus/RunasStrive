package gamemodelling.monsters.level1;

import gamemodelling.abilities.monsters.Deflect;
import gamemodelling.abilities.monsters.Scratch;
import gamemodelling.monsters.Monster;
import gamemodelling.monsters.Type;

import java.util.List;

public class Mushroomlin extends Monster {
    protected final Type type = Type.BASIC;

    protected final boolean boss = false;

    public Mushroomlin() {
        super(20, 8);
        abilityQueue.addAll(List.of(new Deflect(1), new Scratch(1)));
    }
}
