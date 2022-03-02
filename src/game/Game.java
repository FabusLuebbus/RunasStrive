package game;

import gameModelling.Card;
import gameModelling.Entity;
import gameModelling.Runa;
import states.Initialize;
import states.State;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.SortedMap;

public class Game {
    private Entity runa = new Runa();
    private Queue<State> states = new LinkedList<>();
    private Map<String, Card> abilities = new HashMap<>();
    private List<Card> abilityList = new ArrayList<>(abilities.values());

    public Game() {
        states.add(new Initialize(this));
        while (!states.isEmpty()) {
            nextAction();
        }
        //TODO close scanner at end
    }


    private void nextAction() {
        State currentState = states.poll();
        if (currentState == null) {
            //end game
        }
        currentState.start();
    }
    public void addAbilities(List<Card> abilities) {
        for (Card ability : abilities) {
            this.abilities.put(ability.getName(), ability);
        }
    }

    public Map<String, Card> getAbilities() {
        return abilities;
    }

    public Entity getRuna() {
        return runa;
    }

    public void addState(State state) {
        states.add(state);
    }

    public List<Card> getAbilityList() {
        return abilityList;
    }
    public void updateAbilityList(int level) {
        for (Card ability : abilities.values()) {
            if (ability.getLevel() == level) {
                abilityList.add(ability);
            }
        }
    }
}
