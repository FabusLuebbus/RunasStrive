package states;

import game.Game;

public class FocusPointsRuna extends State {
    Stage stage;

    public FocusPointsRuna(Game context, Stage stage) {
        super(context);
        this.stage = stage;
    }

    @Override
    public void start() {
        //all monsters
        game.getRuna().givePotentialFocus(newUI);
        nextState(new RunaTurn(game, stage));
    }
}