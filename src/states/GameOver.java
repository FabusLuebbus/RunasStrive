package states;

import game.Game;

public class GameOver extends State {
    public GameOver(Game context) {
        super(context);
    }

    @Override
    public void start() {
        throw new RuntimeException("not implemented yet");
    }
}
