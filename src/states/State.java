package states;

import game.Game;

public abstract class State implements Statelike {
    protected boolean running;
    protected Game game;
    public State(Game context) {
        this.game = context;
    }

    @Override
    public void nextState(State s) {
        game.addState(s);
    }
}
