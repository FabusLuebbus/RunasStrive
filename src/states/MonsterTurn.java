package states;

import game.Game;
import gamemodelling.abilities.Ability;
import gamemodelling.entities.Entity;
import gamemodelling.entities.monsters.Monster;
import gamemodelling.entities.runa.Runa;

public class MonsterTurn extends State {
    Stage stage;

    public MonsterTurn(Game context, Stage stage) {
        super(context);
        this.stage = stage;
    }

    @Override
    public void start() {
        Runa runa = game.getRuna();
        for (Monster monster: stage.getMonsters()) {
            monster.resetResistances();
            Ability nextAbility;
            do {
                nextAbility = monster.getNextAbility();
            } while (nextAbility.needsFocus() && monster.getFocusPoints() == 0);
            nextAbility.play(monster, runa, newUI);
        }
        stage.clearDeadMobs();
        if (runa.getHealthPoints() <= 0) {
            nextState(new GameOver(game));
        } else if (stage.getMonsters().isEmpty()) {
            nextState(new postFight(game, stage.getNumberOfMonsters()));
        } else {
            nextState(new FocusPointsRuna(game, stage));
        }
    }
}
