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
            } while (monster.getFocusPoints() < nextAbility.getLevel() && nextAbility.needsFocus());
            nextAbility.play(monster, runa, newUI);
            if (runa.getHealthPoints() <= 0) {
                nextState(new GameOver(game));
                return;
            }
        }
        stage.clearDeadMobs();
        if (stage.getMonsters().isEmpty()) {
            nextState(new postFight(game, stage.getNumberOfMonsters()));
        } else {
            nextState(new FocusPointsRuna(game, stage));
        }
    }
}
