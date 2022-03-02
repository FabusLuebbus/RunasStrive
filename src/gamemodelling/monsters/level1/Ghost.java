package gamemodelling.monsters.level1;

import gamemodelling.abilities.monsters.MonsterFocus;
import gamemodelling.abilities.monsters.MonsterIce;
import gamemodelling.monsters.Monster;
import gamemodelling.monsters.Type;

import java.util.List;

public class Ghost extends Monster {
    protected final Type type = Type.ICE;

    protected final boolean boss = false;

    public Ghost() {
        super(15, 2);
        abilityQueue.addAll(List.of(new MonsterFocus(1), new MonsterIce(1)));
    }
}
