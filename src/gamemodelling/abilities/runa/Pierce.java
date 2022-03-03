package gamemodelling.abilities.runa;

import gamemodelling.Ability;
import gamemodelling.Entity;
import gamemodelling.OffensiveAbility;
import gamemodelling.Runa;
import gamemodelling.abilities.DamageType;
import gamemodelling.monsters.Monster;

import java.util.Scanner;

import static game.GameUtil.attackMonster;

public class Pierce extends OffensiveAbility {
    public Pierce(int initLvl) {
        super(initLvl, 4, DamageType.BASIC_PHYSICAL);
    }

    @Override
    public void use(Entity user, Entity target) {
        Monster monster = (Monster) target;
        Runa runa = (Runa) user;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter dice roll [1--" + runa.getMaxFocusPoints() + "]:");
        int firstRoll = scanner.nextInt();
        setBaseDamage(7 * getLevel() + firstRoll);
        if (firstRoll > 5) {
            addBaseDamage(4 * getLevel());
        }
        attackMonster(monster, this);
    }
}
