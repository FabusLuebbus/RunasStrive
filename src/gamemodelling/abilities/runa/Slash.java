package gamemodelling.abilities.runa;

import gamemodelling.Ability;
import gamemodelling.Entity;
import gamemodelling.Runa;

import java.util.Scanner;

public class Slash extends RunaAbility {
    public Slash(int initLvl) {
        super(initLvl, 1);
    }

    @Override
    public void use(Runa runa, Entity target) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter dice roll [1--" + runa.getMaxFocusPoints() + "]:");
        int damage = 4 * getLevel() + scanner.nextInt();
        //TODO change to attack
        target.removeHealth(damage);
    }
}
