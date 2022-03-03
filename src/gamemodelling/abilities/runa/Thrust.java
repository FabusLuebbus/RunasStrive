package gamemodelling.abilities.runa;

import gamemodelling.Ability;
import gamemodelling.Entity;
import gamemodelling.OffensiveAbility;
import gamemodelling.Runa;
import gamemodelling.abilities.DamageType;
import gamemodelling.monsters.Monster;

import java.util.Scanner;

import static game.GameUtil.attackMonster;

public class Thrust extends OffensiveAbility {
    public Thrust(int initLvl) {
        super(initLvl, 3, DamageType.BASIC_PHYSICAL);
    }

    @Override
    public boolean use(Entity user, Entity target) {
        Monster monster = (Monster) target;
        Runa runa = (Runa) user;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter dice roll [1--" + runa.getMaxFocusPoints() + "]:");
        int firstRoll = scanner.nextInt();
        setBaseDamage(6 * getLevel() + firstRoll);
        if (firstRoll > 5) {
            addBaseDamage(4 * getLevel());
        }
        return attackMonster(monster, this);
    }
}
