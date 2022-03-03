package gamemodelling;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Entity implements Living {
    private int healthPoints = 0;
    private int maxHealth = 0;
    private int focusPoints = 0;
    private boolean channeling = false;
    private List<Ability> abilities = new ArrayList<>();

    public Entity(int initHP) {
        healthPoints = initHP;
        maxHealth = initHP;
    }
    
    @Override
    public void addHealth(int amount) {
        healthPoints += amount;
    }

    @Override
    public boolean removeHealth(int amount) {
        healthPoints -= amount;
        return healthPoints <= 0;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getFocusPoints() {
        return focusPoints;
    }

    public void setChanneling(boolean channeling) {
        this.channeling = channeling;
    }

    public boolean isChanneling() {
        return channeling;
    }

    @Override
    public void addFocus(int amount) {
        focusPoints += amount;
    }

    @Override
    public void removeFocus(int amount) {
        focusPoints -= amount;
        if (focusPoints <= 0) {
            focusPoints = 0;
        }
    }

    public List<Ability> getAbilities() {
        return abilities;
    }

    public void print() {
        System.out.println(getClass().getSimpleName() + " (" + getHealthPoints() + '/' + getMaxHealth() + "HP, "
                + getFocusPoints() + "FP)" + printAppendix());
    }

    protected abstract String printAppendix();
}
