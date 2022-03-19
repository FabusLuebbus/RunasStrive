package UI;

import gamemodelling.abilities.Ability;
import gamemodelling.entities.Entity;
import gamemodelling.entities.runa.Runa;
import gamemodelling.entities.runa.RunaClasses;

import java.util.List;

public interface UserInterface {

    RunaClasses setupAndGetInitialRunaClass();

    List<Integer> getMultipleInputs(int amount, String request);

    int[] getShuffleSeeds();

    void stateRoomEntering();

    Ability selectAbilityToPlay();

    Entity selectTarget();

    int selectRewardOption();

    List<Ability> selectRewardAbilities();

    List<Ability> selectHealingDiscard();

    void stateFocusGain(Entity entity);

    void stateDieUpgrade(Runa runa);

    void stateAbilityUsage(Entity user, Ability ability);
}
