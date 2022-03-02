package gamemodelling.monsters.level1;

import gamemodelling.abilities.monsters.MonsterFire;
import gamemodelling.abilities.monsters.MonsterFocus;
import gamemodelling.monsters.Monster;
import gamemodelling.monsters.Type;

import java.util.List;

public class Gorgon extends Monster {
    protected final Type type = Type.FIRE;

    protected final boolean boss = false;

    public Gorgon() {
        super(13, 3);
        abilityQueue.addAll(List.of(new MonsterFocus(1), new MonsterFire(1)));
    }
}
