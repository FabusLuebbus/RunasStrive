package states;

import game.Game;

public class GameOver extends State {
    public GameOver(Game context) {
        super(context);
    }

    @Override
    public void start() {
        if (game.getRuna().getHealthPoints() > 0) {
            newUI.stateWin();
        }
    }
}
