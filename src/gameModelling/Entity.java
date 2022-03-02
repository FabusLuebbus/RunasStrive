package gameModelling;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public abstract class Entity implements Living{
    protected int healthPoints = 0;
    protected int focusPoints = 0;
    protected Map<String, Card> abilities = new HashMap<>();

    public Entity(int initHP) {
        healthPoints = initHP;
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

    public Map<String, Card> getAbilities() {
        return abilities;
    }

}
