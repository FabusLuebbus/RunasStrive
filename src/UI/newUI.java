package UI;

import game.Game;
import gamemodelling.abilities.Ability;
import gamemodelling.entities.Entity;

import java.util.List;

public class newUI implements UserInterface {
    Game game;

    public newUI(Game game) {
        this.game = game;
    }

    @Override
    public void setup() {

    }

    @Override
    public int[] getShuffleSeeds() {
        return new int[0];
    }

    @Override
    public void stateRoomEntering(int stage, int level) {

    }

    @Override
    public Ability selectAbility() {
        return null;
    }

    @Override
    public Entity selectTarget() {
        return null;
    }

    @Override
    public int selectRewardOption() {
        return 0;
    }

    @Override
    public List<Ability> selectRewardAbilities() {
        return null;
    }

    @Override
    public List<Ability> selectHealingDiscard() {
        return null;
    }


}
