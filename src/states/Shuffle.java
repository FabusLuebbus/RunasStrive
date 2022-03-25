package states;

import game.Game;
import gamemodelling.abilities.Ability;

import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Shuffle extends State {

    public Shuffle(Game context) {
        super(context);
    }

    @Override
    public void start() {
        int[] seeds = newUI.getShuffleSeeds();
        if (game.isAbort()) {
            return;
        }
        Collections.shuffle(game.getAbilityList(), new Random(seeds[0]));
        Collections.shuffle(game.getMonsterList(), new Random(seeds[1]));
        game.addMonstersToQueue(game.getMonsterList());
        nextState(new Stage(game));
    }
}
