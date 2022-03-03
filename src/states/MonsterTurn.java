package states;

import game.Game;
import gamemodelling.Ability;
import gamemodelling.Entity;
import gamemodelling.NonOffensiveAbility;
import gamemodelling.Runa;
import gamemodelling.monsters.Monster;

import java.util.List;

public class MonsterTurn extends State {
    Stage stage;

    public MonsterTurn(Game context, Stage stage) {
        super(context);
        this.stage = stage;
    }

    @Override
    public void start() {
        for (int i = 1; i < stage.fighters.size(); i++) {
            Entity runa = stage.fighters.get(0);
            Monster monster = (Monster) stage.fighters.get(i);
            Ability nextAbility = monster.getNextAbility();
            if (nextAbility instanceof NonOffensiveAbility) {
                ((NonOffensiveAbility) nextAbility).play(monster);
            } else {
                nextAbility.play(monster, runa, stage);
            }
        }

    }
}
