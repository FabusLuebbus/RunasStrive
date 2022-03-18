package gamemodelling.entities.monsters.level1;

import gamemodelling.abilities.monsters.Bite;
import gamemodelling.abilities.monsters.Block;
import gamemodelling.entities.monsters.Monster;

import java.util.List;

public class Spider extends Monster {
    public Spider() {
        super(15, 5);
        abilityQueue.addAll(List.of(new Bite(1), new Block(1)));
    }
}
