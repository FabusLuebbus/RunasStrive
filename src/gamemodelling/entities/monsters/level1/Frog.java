package gamemodelling.entities.monsters.level1;

import gamemodelling.abilities.Focus;
import gamemodelling.abilities.monsters.MonsterWater;
import gamemodelling.entities.monsters.Monster;
import gamemodelling.entities.Type;

import java.util.List;

public class Frog extends Monster {
    public Frog() {
        super(16, 1);
        abilityQueue.addAll(List.of(new Focus(1), new MonsterWater(1)));
        setType(Type.WATER);
    }
}
