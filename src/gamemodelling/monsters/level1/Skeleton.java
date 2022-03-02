package gamemodelling.monsters.level1;

import gamemodelling.abilities.monsters.MonsterFocus;
import gamemodelling.abilities.monsters.MonsterLightning;
import gamemodelling.monsters.Monster;
import gamemodelling.monsters.Type;

import java.util.List;

public class Skeleton extends Monster {
    protected final Type type = Type.LIGHTNING;

    protected final boolean boss = false;

    public Skeleton() {
        super(14, 4);
        abilityQueue.addAll(List.of(new MonsterFocus(1), new MonsterLightning(1)));
    }
}
