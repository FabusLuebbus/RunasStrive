package gamemodelling.entities.runa;

import gamemodelling.abilities.Ability;
import gamemodelling.abilities.Focus;
import gamemodelling.abilities.runa.Parry;
import gamemodelling.abilities.runa.Reflect;
import gamemodelling.abilities.runa.Slash;
import gamemodelling.abilities.runa.Thrust;
import gamemodelling.abilities.runa.Water;

import java.util.List;
import java.util.Set;

public enum RunaClasses {
    PALADIN(List.of(new Slash(1), new Reflect(1))),
    WARRIOR(List.of(new Thrust(1), new Parry(1))),
    MAGE(List.of(new Focus(1), new Water(1)));

    List<Ability> startingAbilities;
    RunaClasses(List<Ability> startingAbilities) {
        this.startingAbilities = startingAbilities;
    }

    public List<Ability> getStartingAbilities() {
        return startingAbilities;
    }
}
