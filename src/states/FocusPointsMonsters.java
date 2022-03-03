package states;

import game.Game;
import gamemodelling.monsters.Monster;

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
            Monster monster = (Monster) stage.fighters.get(i);
            if (monster.isChanneling()) {
                System.out.println(monster.getName() + " gains " + monster.getPotentialFocusGain() + " focus");
                monster.addFocus(monster.getPotentialFocusGain());
                monster.setChanneling(false);
            }
        }
        nextState(new MonsterTurn(game, stage));
    }
}
