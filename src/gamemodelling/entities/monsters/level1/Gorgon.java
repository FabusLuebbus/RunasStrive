package gamemodelling.entities.monsters.level1;

import gamemodelling.abilities.Focus;
import gamemodelling.abilities.monsters.MonsterFire;
import gamemodelling.entities.monsters.Monster;
import gamemodelling.entities.Type;

import java.util.List;

public class Gorgon extends Monster {
    public Gorgon() {
        super(13, 3);
        abilityQueue.addAll(List.of(new Focus(1), new MonsterFire(1)));
        setType(Type.FIRE);
    }
}
