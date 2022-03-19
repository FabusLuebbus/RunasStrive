package states;

import game.Game;
import gamemodelling.abilities.Ability;
import gamemodelling.entities.Entity;
import gamemodelling.abilities.NonOffensiveAbility;
import gamemodelling.entities.monsters.Monster;

public class MonsterTurn extends State {
    Stage stage;

    public MonsterTurn(Game context, Stage stage) {
        super(context);
        this.stage = stage;
    }

    @Override
    public void start() {
        Entity runa = stage.fighters.get(0);
        for (int i = 1; i < stage.fighters.size(); i++) {
            Monster monster = (Monster) stage.fighters.get(i);
            monster.resetResistances();
            Ability nextAbility = monster.getNextAbility();
            nextAbility.play(monster, newUI);
        }
        stage.clearDeadMobs();
        if (stage.fighters.size() == 1) {
            nextState(new postFight(game, stage.getNumberOfMonsters()));
        } else {
            nextState(new FocusPointsRuna(game, stage));
        }
    }
}
