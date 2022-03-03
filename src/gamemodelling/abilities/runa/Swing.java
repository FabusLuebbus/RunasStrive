package gamemodelling.abilities.runa;

import gamemodelling.Ability;
import gamemodelling.Entity;
import gamemodelling.OffensiveAbility;
import gamemodelling.Runa;
import gamemodelling.abilities.DamageType;
import gamemodelling.monsters.Monster;

import java.util.Scanner;

import static game.GameUtil.attackMonster;

public class Swing extends OffensiveAbility {
    public Swing(int initLvl) {
        super(initLvl, 2, DamageType.ANTI_FOCUS);
    }

    @Override
    public boolean use(Entity user, Entity target) {
        Monster monster = (Monster) target;
        Runa runa = (Runa) user;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter dice roll [1--" + runa.getMaxFocusPoints() + "]:");
        setBaseDamage(5 * getLevel() + scanner.nextInt());
        return attackMonster(monster, this);
    }
}
