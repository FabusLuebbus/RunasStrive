package states;

import game.Game;
import gamemodelling.entities.Entity;
import gamemodelling.entities.monsters.Monster;

import java.util.ArrayList;
import java.util.List;

public class Stage extends State {
    private List<Monster> monsters = new ArrayList<>();
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
                monsters.add(game.getNextMonster());
                numberOfMonsters = 1;
                break;
            case 2:
            case 3:
                monsters.addAll(List.of(game.getNextMonster(), game.getNextMonster()));
                numberOfMonsters = 2;
                break;
            case 4:
                monsters.add(game.getCurrentStageBoss());
                numberOfMonsters = 1;
                break;
            default:
                break;
        }
        nextState(new RunaTurn(game, this));
    }

    public List<Monster> getMonsters() {
        return monsters;
    }

    public void clearDeadMobs() {
        monsters.removeIf(monster -> monster.getHealthPoints() <= 0);
    }

    public int getNumberOfMonsters() {
        return numberOfMonsters;
    }
}
