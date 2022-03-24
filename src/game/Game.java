package game;

import UI.newUI;
import gamemodelling.abilities.Ability;
import gamemodelling.entities.runa.Runa;
import gamemodelling.entities.monsters.Monster;
import states.Initialize;
import states.Stage;
import states.State;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Game {
    //TODO check methods for unneeded return types
    //TODO remove runa cast in abilities
    private int level;
    private int stageNumber;
    private Runa runa;
    private Queue<State> states = new LinkedList<>();
    private List<Ability> abilityList = new LinkedList<>();
    private List<Monster> monsterList = new ArrayList<>();
    private Queue<Monster> monsterQueue = new LinkedList<>();
    private Stage currentStage;
    private Monster currentStageBoss;
    public newUI newUI = new newUI(this);
    private boolean abort = false;

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

    public void endFight() {

    }

    public void addAbilities(List<Ability> abilities) {
        abilityList.addAll(abilities);
    }

    public void addAbilitiesToList(List<Ability> abilities) {
        abilityList.addAll(abilities);
    }

    public void removeAbilitiesFromList(List<Ability> abilities) {
        abilityList.removeAll(abilities);
    }

    public void addMonsters(List<Monster> monsters) {
        monsterList.addAll(monsters);
    }

    public void addMonstersToQueue(List<Monster> monsters) {
        monsterQueue.addAll(monsters);
    }

    public List<Ability> getAbilityList() {
        return abilityList;
    }

    public void setRuna(Runa runa) {
        this.runa = runa;
    }

    public Runa getRuna() {
        return runa;
    }

    public void addState(State state) {
        states.add(state);
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

    public boolean isAbort() {
        return abort;
    }

    public void setAbort(boolean abort) {
        this.abort = abort;
    }

    public int getStageNumber() {
        return stageNumber;
    }

    public void setStageNumber(int stageNumber) {
        this.stageNumber = stageNumber;
    }

    public Monster getCurrentStageBoss() {
        return currentStageBoss;
    }

    public void setCurrentStageBoss(Monster currentStageBoss) {
        this.currentStageBoss = currentStageBoss;
    }

    public Stage getCurrentStage() {
        return currentStage;
    }

    public void setCurrentStage(Stage currentStage) {
        this.currentStage = currentStage;
    }
}
