package UI;

import gamemodelling.abilities.Ability;
import gamemodelling.entities.Entity;
import gamemodelling.entities.runa.Runa;
import gamemodelling.entities.runa.RunaClasses;

import java.util.List;

public interface UserInterface {

    RunaClasses setupAndGetInitialRunaClass();

    int[] getShuffleSeeds();

    void stateRoomEntering();

    Ability selectAbilityToPlay();

    Entity selectTarget();

    int selectRewardOption();

    List<Ability> selectRewardAbilities(int amount);

    List<Ability> selectHealingDiscard();

    void stateFocusGain(Entity entity);

    void stateDieUpgrade(Runa runa);

    void stateNewAbilities(List<Ability> abilities);

    void stateAbilityUsage(Entity user, Ability ability);
}
