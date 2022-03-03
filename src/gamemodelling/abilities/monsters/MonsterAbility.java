package gamemodelling.abilities.monsters;

import gamemodelling.Ability;
import gamemodelling.Entity;
import gamemodelling.monsters.Monster;
import states.Stage;

public abstract class MonsterAbility extends Ability {
    public MonsterAbility(int initLvl, int orderingNumber) {
        super(initLvl, orderingNumber);
    }

    public abstract void use(Monster monster, Entity target);

    @Override
    public void play(Entity user, Entity target, Stage stage) {
        System.out.println("complete me");
        use((Monster) user, target);
    }
}
