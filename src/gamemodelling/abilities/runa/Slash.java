package gamemodelling.abilities.runa;

import gamemodelling.Ability;
import gamemodelling.Entity;
import gamemodelling.OffensiveAbility;
import gamemodelling.Runa;
import gamemodelling.abilities.DamageType;
import gamemodelling.monsters.Monster;
import static game.GameUtil.attackMonster;

import java.util.Scanner;

public class Slash extends OffensiveAbility {
    public Slash(int initLvl) {
        super(initLvl, 1, DamageType.ANTI_FOCUS);
    }

    @Override
    public boolean use(Entity user, Entity target) {
        Monster monster = (Monster) target;
        Runa runa = (Runa) user;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter dice roll [1--" + runa.getMaxFocusPoints() + "]:");
        setBaseDamage(4 * getLevel() + scanner.nextInt());
        return attackMonster(monster, this);
    }
}
