package gamemodelling.abilities.monsters;

import gamemodelling.entities.Entity;
import gamemodelling.abilities.MagicalOffensive;
import gamemodelling.abilities.DamageType;



public class MonsterFire extends MagicalOffensive {
    public MonsterFire(int initLvl) {
        super(initLvl, 11, DamageType.FIRE);
    }

    @Override
    public String getName() {
        return "Fire" + '(' + getLevel() + ')';
    }

    @Override
    public void use(Entity user, Entity target) {
        setBaseDamage(12 * getLevel() + 2);
        user.removeFocus(getLevel());
        dealDamage(user, target, this);
    }
}
