package gamemodelling;

import gamemodelling.abilities.DamageType;

public abstract class Ability implements Playable, Comparable<Ability> {
    private int level;
    private int ip;


    public Ability(int initLvl, int ip) {
        level = initLvl;
        this.ip = ip;
    }

    public void setLvl(int lvl) {
        level = lvl;
    }

    @Override
    public abstract void play(Entity user, Entity target);

    @Override
    public boolean checkIfAllowed() {
        return false;
    }

    public String getName() {
        return this.getClass().getSimpleName() + '(' + level + ')';
    }

    public int getLevel() {
        return level;
    }

    public void setIp(int ip) {
        this.ip = ip;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "(" + level + ")";
    }

    @Override
    public int compareTo(Ability ability) {
        return Integer.compare(this.ip, ability.ip);
    }
}
