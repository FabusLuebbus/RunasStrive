package gamemodelling.abilities.runa;

import gamemodelling.Ability;
import gamemodelling.Entity;
import gamemodelling.Runa;
import gamemodelling.monsters.Monster;
import gamemodelling.monsters.Type;

public class Fire extends RunaAbility {
    public Fire(int initLvl) {
        super(initLvl, 10);
    }

    @Override
    public void use(Runa runa, Entity target) {
        Monster monster = (Monster) target;
        int damage = (2 * getLevel() + 5) * runa.getFocusPoints();
        if (monster.getType().equals(Type.ICE)) {
            damage += 2 * getLevel();
        }
        monster.removeHealth(damage);//TODO change to attack method
    }
}
