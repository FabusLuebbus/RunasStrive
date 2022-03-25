package states;

import game.Game;
import gamemodelling.abilities.Ability;

public class RunaTurn extends State {
    Stage stage;
    public RunaTurn(Game context, Stage stage) {
        super(context);
        this.stage = stage;
    }

    @Override
    public void start() {
        newUI.printStageFighters(stage);
        game.getRuna().resetResistances();
        Ability nextAbility = newUI.selectAbilityToPlay();
        if (game.isAbort()) {
            return;
        }
        nextAbility.play(game.getRuna(), newUI);
        stage.clearDeadMobs();

        if (stage.getMonsters().isEmpty()) {
            nextState(new postFight(game, stage.getNumberOfMonsters()));
        } else {
            nextState(new FocusPointsMonsters(game, stage));
        }
    }
}
