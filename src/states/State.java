package states;

import UI.newUI;
import game.Game;

public abstract class State implements Statelike {
    Game game;
    newUI newUI;

    public State(Game context) {
        this.game = context;
        newUI = game.newUI;
    }

    @Override
    public void nextState(State s) {
        game.addState(s);
    }
}
