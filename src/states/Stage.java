package states;

import game.Game;
import gamemodelling.entities.Entity;

import java.util.ArrayList;
import java.util.List;

public abstract class Stage extends State {
    List<Entity> fighters = new ArrayList<>();
    private int numberOfMonsters;
    static final String segmentSeparator = "----------------------------------------";
    public Stage(Game context, int numberOfMonsters) {
        super(context);
        this.numberOfMonsters = numberOfMonsters;
    }

    @Override
    public void start() {

    }

    void addFighter(Entity fighter) {
        fighters.add(fighter);
    }

    void printFighters() {
        System.out.println(segmentSeparator);
        fighters.get(0).print();
        System.out.println("vs.");
        for (int i = 1; i < fighters.size(); i++) {
            fighters.get(i).print();
        }
        System.out.println(segmentSeparator);
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
