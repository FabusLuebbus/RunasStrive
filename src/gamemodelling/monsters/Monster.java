package gamemodelling.monsters;

import gamemodelling.Ability;
import gamemodelling.Entity;

import java.util.LinkedList;
import java.util.Queue;

/**
 * abilities will be modelled as cards by themselves since they work exactly like that
 */
public abstract class Monster extends Entity implements Comparable<Monster> {
    private int ip;
    protected Queue<Ability> abilityQueue = new LinkedList<>();

    public Monster(int initHP, int number) {
        super(initHP);
        ip = number;
    }

    @Override
    public int compareTo(Monster monster) {
        return Integer.compare(this.ip, monster.ip);
    }

    @Override
    protected String printAppendix() {
        return ": attempts " + abilityQueue.peek().getName() + " next";
    }
}
