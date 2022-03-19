package states;

import game.Game;
import game.GameUtil;
import gamemodelling.entities.Entity;
import gamemodelling.entities.monsters.Monster;

public class FocusPointsMonsters extends State {
    Stage stage;

    public FocusPointsMonsters(Game context, Stage stage) {
        super(context);
        this.stage = stage;
    }

    @Override
    public void start() {
        //all monsters
        for (int i = 1; i < stage.fighters.size(); i++) {
            Entity entity = stage.fighters.get(i);
            entity.givePotentialFocus(newUI);
        }
        nextState(new MonsterTurn(game, stage));
    }
}
