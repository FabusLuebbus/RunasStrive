package gamemodelling.monsters.level1;

import gamemodelling.abilities.monsters.Block;
import gamemodelling.abilities.monsters.Claw;
import gamemodelling.monsters.Monster;
import gamemodelling.monsters.Type;

import java.util.List;

public class Rat extends Monster {
    public Rat() {
        super(14, 7);
        abilityQueue.addAll(List.of(new Block(1), new Claw(1)));
    }
}
