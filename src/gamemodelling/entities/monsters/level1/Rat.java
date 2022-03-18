package gamemodelling.entities.monsters.level1;

import gamemodelling.abilities.monsters.Block;
import gamemodelling.abilities.monsters.Claw;
import gamemodelling.entities.monsters.Monster;

import java.util.List;

public class Rat extends Monster {
    public Rat() {
        super(14, 7);
        abilityQueue.addAll(List.of(new Block(1), new Claw(1)));
    }
}
