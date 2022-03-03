package gamemodelling.monsters.level1;

import gamemodelling.abilities.Focus;
import gamemodelling.abilities.monsters.MonsterIce;
import gamemodelling.monsters.Monster;
import gamemodelling.monsters.Type;

import java.util.List;

public class Ghost extends Monster {
    public Ghost() {
        super(15, 2);
        abilityQueue.addAll(List.of(new Focus(1), new MonsterIce(1)));
        setType(Type.ICE);
    }
}
