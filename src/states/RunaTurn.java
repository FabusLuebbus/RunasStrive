package states;

import game.Game;
import UI.UI;
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
        stage.printFighters();
        game.getRuna().resetResistances();
        Ability nextAbility = UI.selectCard(game.getRuna());
        if (nextAbility instanceof NonOffensiveAbility) {
            ((NonOffensiveAbility) nextAbility).play(stage.fighters.get(0));
        } else {
            nextAbility.play(stage.fighters.get(0), UI.selectTarget(stage), stage);
        }
        stage.clearDeadMobs();

        if (stage.fighters.size() == 1) {
            nextState(new postFight(game, stage.getNumberOfMonsters()));
        } else {
            nextState(new FocusPointsMonsters(game, stage));
        }
    }
}
