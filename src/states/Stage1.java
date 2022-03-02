package states;

import game.Game;
import gamemodelling.Entity;

import java.util.ArrayList;
import java.util.List;

public class Stage1 extends Stage {
    public Stage1(Game context) {
        super(context);
    }

    @Override
    public void start() {
        System.out.println("Runa enters Stage 1 of Level " + game.getLevel() + "\n" + segmentSeparator);
        addFighter(game.getRuna());
        addFighter(game.getNextMonster());
        nextState(new RunaTurn(game, this));
    }
}
