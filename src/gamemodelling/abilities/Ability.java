package gamemodelling.abilities;

import UI.newUI;
import gamemodelling.entities.Entity;
import states.Stage;

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

    public abstract void play(Entity user, newUI newUI);

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

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (!(o instanceof Ability)) {
            return false;
        }

        Ability other = (Ability) o;
        return getName().equals(other.getName());
    }

    @Override
    public int hashCode() {
        return 42;
    }
}
