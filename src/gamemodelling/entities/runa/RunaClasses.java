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
    PALADIN(List.of(new Slash(1), new Reflect(1)), List.of(new Slash(2), new Reflect(2))),
    WARRIOR(List.of(new Thrust(1), new Parry(1)), List.of(new Thrust(2), new Parry(2))),
    MAGE(List.of(new Focus(1), new Water(1)), List.of(new Focus(2), new Water(2)));

    List<Ability> startingAbilities;
    List<Ability> upgradeAbilities;
    RunaClasses(List<Ability> startingAbilities, List<Ability> upgradeAbilities) {
        this.startingAbilities = startingAbilities;
        this.upgradeAbilities = upgradeAbilities;
    }

    public List<Ability> getStartingAbilities() {
        return startingAbilities;
    }

    public List<Ability> getAbilityUpgrade() {
        return upgradeAbilities;
    }
}
