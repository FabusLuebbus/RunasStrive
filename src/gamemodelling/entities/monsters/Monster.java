package gamemodelling.entities.monsters;

import gamemodelling.abilities.Ability;
import gamemodelling.entities.Entity;
import gamemodelling.entities.Type;

import java.util.LinkedList;
import java.util.Queue;

/**
 * abilities will be modelled as cards by themselves since they work exactly like that
 */
public abstract class Monster extends Entity implements Comparable<Monster> {
    private int ip;

    private boolean boss = false;
    private int blockAmount = 0;
    private int deflectAmount = 0;
    protected Queue<Ability> abilityQueue = new LinkedList<>();

    public Monster(int initHP, int number) {
        super(initHP);
        ip = number;
    }



    public boolean isBoss() {
        return boss;
    }

    public void setBoss(boolean boss) {
        this.boss = boss;
    }

    public void setBlockAmount(int blockAmount) {
        this.blockAmount = blockAmount;
    }

    public int getBlockAmount() {
        return blockAmount;
    }

    public void setDeflectAmount(int deflectAmount) {
        this.deflectAmount = deflectAmount;
    }

    public int getDeflectAmount() {
        return deflectAmount;
    }

    public Ability getNextAbility() {
        abilityQueue.add(abilityQueue.peek());
        return abilityQueue.poll();
    }

    @Override
    public int compareTo(Monster monster) {
        return Integer.compare(this.ip, monster.ip);
    }

    @Override
    protected String printAttempts() {
        return ": attempts " + abilityQueue.peek().getName() + " next";
    }
}
