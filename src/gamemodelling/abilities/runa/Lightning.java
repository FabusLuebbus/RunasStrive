package gamemodelling.abilities.runa;

import gamemodelling.Ability;
import gamemodelling.Entity;
import gamemodelling.OffensiveAbility;
import gamemodelling.Runa;
import gamemodelling.abilities.DamageType;
import gamemodelling.monsters.Monster;

import static game.GameUtil.attackMonster;

public class Lightning extends OffensiveAbility {
   public Lightning(int initLvl) {
        super(initLvl, 11, DamageType.LIGHTNING);
    }

    @Override
    public void use(Entity user, Entity target) {
        Monster monster = (Monster) target;
        Runa runa = (Runa) user;
        setBaseDamage((2 * getLevel() + 5) * runa.getFocusPoints() + 2);
        attackMonster(monster, this);
    }
}
