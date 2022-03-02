package gamemodelling.monsters.level1;

import gamemodelling.abilities.monsters.Bite;
import gamemodelling.abilities.monsters.Block;
import gamemodelling.abilities.monsters.MonsterFocus;
import gamemodelling.abilities.monsters.MonsterLightning;
import gamemodelling.monsters.Monster;
import gamemodelling.monsters.Type;

import java.util.List;

public class SpiderKing extends Monster {
    protected final Type type = Type.LIGHTNING;

    protected final boolean boss = true;

    public SpiderKing() {
        super(50, 0); //TODO magic numbers
        abilityQueue.addAll(List.of(new Bite(1), new Block(1), new MonsterFocus(1), new MonsterLightning(1)));
    }
}
