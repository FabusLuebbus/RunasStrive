package states;

import game.Game;
import gamemodelling.abilities.Ability;
import gamemodelling.abilities.NonOffensiveAbility;

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
        nextAbility.play(stage.fighters.get(0), newUI);
        stage.clearDeadMobs();

        if (stage.fighters.size() == 1) {
            nextState(new postFight(game, stage.getNumberOfMonsters()));
        } else {
            nextState(new FocusPointsMonsters(game, stage));
        }
    }
}
