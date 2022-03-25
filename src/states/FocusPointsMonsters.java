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
        for (int i = 0; i < stage.getMonsters().size(); i++) {
            Entity entity = stage.getMonsters().get(i);
            entity.givePotentialFocus(newUI);
        }
        nextState(new MonsterTurn(game, stage));
    }
}
