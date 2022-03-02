package gamemodelling.monsters.level1;

import gamemodelling.abilities.monsters.MonsterFire;
import gamemodelling.abilities.monsters.MonsterFocus;
import gamemodelling.abilities.runa.Fire;
import gamemodelling.monsters.Monster;
import gamemodelling.monsters.Type;

import java.util.List;

public class Gorgon extends Monster {
    public Gorgon() {
        super(13, 3);
        abilityQueue.addAll(List.of(new MonsterFocus(1), new MonsterFire(1)));
        setType(Type.FIRE);
    }
}
