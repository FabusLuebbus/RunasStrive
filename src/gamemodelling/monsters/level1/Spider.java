package gamemodelling.monsters.level1;

import gamemodelling.abilities.monsters.Bite;
import gamemodelling.abilities.monsters.Block;
import gamemodelling.monsters.Monster;
import gamemodelling.monsters.Type;

import java.util.List;

public class Spider extends Monster {
    protected final Type type = Type.BASIC;

    protected final boolean boss = false;

    public Spider() {
        super(15, 5);
        abilityQueue.addAll(List.of(new Bite(1), new Block(1)));
    }
}
