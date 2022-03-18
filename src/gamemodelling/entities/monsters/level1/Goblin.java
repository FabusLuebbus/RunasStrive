package gamemodelling.entities.monsters.level1;

import gamemodelling.abilities.monsters.Deflect;
import gamemodelling.abilities.monsters.Smash;
import gamemodelling.entities.monsters.Monster;

import java.util.List;

public class Goblin extends Monster {
    public Goblin() {
        super(12, 6);
        abilityQueue.addAll(List.of(new Smash(1), new Deflect(1)));
    }
}
