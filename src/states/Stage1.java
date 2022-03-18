package states;

import game.Game;

public class Stage1 extends Stage {
    public Stage1(Game context) {
        super(context, 1);
    }

    @Override
    public void start() {
        //TODO extract to UI
        System.out.println("Runa enters Stage 1 of Level " + game.getLevel());
        addFighter(game.getRuna());
        addFighter(game.getNextMonster());
        nextState(new RunaTurn(game, this));
    }
}
