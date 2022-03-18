package UI;

import gamemodelling.abilities.Ability;
import gamemodelling.entities.Entity;
import gamemodelling.entities.runa.Runa;

import java.util.List;

public interface UserInterface {

    Runa SetupAndGetInitialRuna();

    int[] getShuffleSeeds();

    void stateRoomEntering(int Stage, int level);

    Ability selectAbility();

    Entity selectTarget();

    int selectRewardOption();

    List<Ability> selectRewardAbilities();

    List<Ability> selectHealingDiscard();

    int getDiceRoll();

    void stateFocusGain();

    void stateDieUpgrade();
}
