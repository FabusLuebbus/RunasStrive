package gamemodelling.entities.monsters.level1;

import gamemodelling.abilities.monsters.Deflect;
import gamemodelling.abilities.monsters.Scratch;
import gamemodelling.entities.monsters.Monster;

import java.util.List;

public class Mushroomlin extends Monster {
    public Mushroomlin() {
        super(20, 8);
        abilityQueue.addAll(List.of(new Deflect(1), new Scratch(1)));
    }
}
