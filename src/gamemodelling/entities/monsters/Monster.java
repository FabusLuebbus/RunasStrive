package gamemodelling.entities.monsters;

import gamemodelling.abilities.Ability;
import gamemodelling.entities.Entity;
import gamemodelling.entities.Type;

import java.util.LinkedList;
import java.util.Queue;

/**
 * abilities will be modelled as cards by themselves since they work exactly like that
 */
public class Monster extends Entity implements Comparable<Monster> {
    private int id;
    private final String name;
    private boolean boss;
    private int blockAmount = 0;
    private int deflectAmount = 0;
    protected Queue<Ability> abilityQueue = new LinkedList<>();

    public Monster(Monsters monsterValue) {
        super(monsterValue.maxHP);
        boss = monsterValue.boss;
        id = monsterValue.id;
        setType(monsterValue.type);
        abilityQueue.addAll(monsterValue.abilities);
        name = monsterValue.toString();
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
        return Integer.compare(this.id, monster.id);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    protected String printAttempts() {
        return ": attempts " + abilityQueue.peek().getName() + " next";
    }
}
