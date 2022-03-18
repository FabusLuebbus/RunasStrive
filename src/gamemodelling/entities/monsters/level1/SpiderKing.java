package gamemodelling.entities.monsters.level1;

import gamemodelling.abilities.Focus;
import gamemodelling.abilities.monsters.Bite;
import gamemodelling.abilities.monsters.Block;
import gamemodelling.abilities.monsters.MonsterLightning;
import gamemodelling.entities.monsters.Monster;
import gamemodelling.entities.Type;

import java.util.List;

public class SpiderKing extends Monster {
    protected final Type type = Type.LIGHTNING;



    public SpiderKing() {
        super(50, 0); //TODO magic numbers
        abilityQueue.addAll(List.of(new Bite(1), new Block(1), new Focus(1), new MonsterLightning(1)));
        setType(Type.LIGHTNING);
        setBoss(true);
    }
}
