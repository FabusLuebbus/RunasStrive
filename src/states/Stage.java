package states;

import game.Game;
import gamemodelling.entities.Entity;

import java.util.ArrayList;
import java.util.List;

public class Stage extends State {
    List<Entity> fighters = new ArrayList<>();
    private int numberOfMonsters;
    public Stage(Game context) {
        super(context);
        game.setCurrentStage(this);
    }

    @Override
    public void start() {
        newUI.stateRoomEntering();
        switch (game.getStageNumber()) {
            case 1:
                fighters.add(game.getRuna());
                fighters.add(game.getNextMonster());
                numberOfMonsters = 1;
                break;
            case 2:
            case 3:
                fighters.add(game.getRuna());
                fighters.addAll(List.of(game.getNextMonster(), game.getNextMonster()));
                numberOfMonsters = 2;
                break;
            case 4:
                fighters.add(game.getRuna());
                fighters.add(game.getCurrentStageBoss());
                numberOfMonsters = 1;
                break;
            default:
                break;
        }
        nextState(new RunaTurn(game, this));
    }

    public List<Entity> getFighters() {
        return fighters;
    }

    public void clearDeadMobs() {
        for (int i = 1; i < fighters.size(); i++) {
            Entity monster = fighters.get(i);
            if (monster.getHealthPoints() <= 0) {
                fighters.remove(monster);
            }
        }
    }

    public int getNumberOfMonsters() {
        return numberOfMonsters;
    }
}
