package game;

import gamemodelling.Ability;
import gamemodelling.Entity;
import gamemodelling.Runa;
import gamemodelling.monsters.Monster;
import states.Initialize;
import states.State;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Game {
    private int level;
    private Runa runa = new Runa();
    private Queue<State> states = new LinkedList<>();
    private Map<String, Ability> abilities = new HashMap<>();
    private Queue<Ability> abilityQueue = new LinkedList<>();
    private List<Monster> monsterList = new ArrayList<>();
    private Queue<Monster> monsterQueue = new LinkedList<>();

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

    public void addAbilities(List<Ability> abilities) {
        for (Ability ability : abilities) {
            this.abilities.put(ability.getName(), ability);
        }
    }

    public void addAbilitiesToQueue(List<Ability> abilities) {
        abilityQueue.addAll(abilities);
    }

    public void addMonsters(List<Monster> monsters) {
        monsterList.addAll(monsters);
    }

    public void addMonstersToQueue(List<Monster> monsters) {
        monsterQueue.addAll(monsters);
    }

    public Map<String, Ability> getAbilities() {
        return abilities;
    }

    public Entity getRuna() {
        return runa;
    }

    public void addState(State state) {
        states.add(state);
    }

    public List<Ability> getAbilityList() {
        List<Ability> output = new ArrayList<>(abilities.values());
        Collections.sort(output);
        return output;
    }

    public List<Monster> getMonsterList() {
        return monsterList;
    }

    public Monster getNextMonster() {
        return monsterQueue.poll();
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }
}
