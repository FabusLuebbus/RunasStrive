package states;

import game.Game;
import gamemodelling.Ability;
import gamemodelling.Entity;

import java.util.ArrayList;
import java.util.List;

public abstract class Stage extends State {
    List<Entity> fighters = new ArrayList<>();
    static final String segmentSeparator = "----------------------------------------";
    public Stage(Game context) {
        super(context);
    }

    @Override
    public void start() {

    }

    void addFighter(Entity fighter) {
        fighters.add(fighter);
    }

    void printFighters() {
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

    void printAbilities() {
        for (int i = 1; i <= game.getRuna().getAbilities().size(); i++) {
            Ability ability = game.getRuna().getAbilities().get(i - 1);
            System.out.println(i + ") " + ability.getName());
        }
    }
}
