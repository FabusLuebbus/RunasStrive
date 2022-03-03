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
    private Type type = Type.BASIC;
    private boolean boss = false;
    private int blockAmount = 0;
    private int deflectAmount = 0;
    protected Queue<Ability> abilityQueue = new LinkedList<>();

    public Monster(int initHP, int number) {
        super(initHP);
        ip = number;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
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

    @Override
    public int compareTo(Monster monster) {
        return Integer.compare(this.ip, monster.ip);
    }

    @Override
    protected String printAppendix() {
        return ": attempts " + abilityQueue.peek().getName() + " next";
    }
}
