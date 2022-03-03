package gamemodelling.abilities.runa;

import gamemodelling.Ability;
import gamemodelling.Entity;
import gamemodelling.OffensiveAbility;
import gamemodelling.Runa;
import gamemodelling.abilities.DamageType;
import gamemodelling.monsters.Monster;

import static game.GameUtil.attackMonster;

public class Water extends OffensiveAbility {
    public Water(int initLvl) {
        super(initLvl, 8, DamageType.WATER);
    }

    @Override
    public void use(Entity user, Entity target) {
        Monster monster = (Monster) target;
        Runa runa = (Runa) user;
        setBaseDamage((2 * getLevel() + 4) * runa.getFocusPoints());
        attackMonster(monster, this);
    }
}
