package gamemodelling.abilities.runa;

import gamemodelling.Entity;
import gamemodelling.OffensiveAbility;
import gamemodelling.Runa;
import gamemodelling.abilities.DamageType;
import gamemodelling.monsters.Monster;
import gamemodelling.monsters.Type;

import static game.GameUtil.attackMonster;

public class Fire extends OffensiveAbility {


    public Fire(int initLvl) {
        super(initLvl, 10, DamageType.FIRE);
    }

    @Override
    public void use(Entity user, Entity target) {
        Monster monster = (Monster) target;
        Runa runa = (Runa) user;
        setBaseDamage((2 * getLevel() + 5) * runa.getFocusPoints());
        attackMonster(monster, this);
    }
}
