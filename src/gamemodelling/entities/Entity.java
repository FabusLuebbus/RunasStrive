package gamemodelling.entities;

import UI.newUI;
import gamemodelling.abilities.Ability;

import java.util.ArrayList;
import java.util.List;

public abstract class Entity implements Living {
    private int healthPoints;
    private int maxHealth;
    private Type type = Type.BASIC;
    private int physicalResistance = 0;
    private int magicalBlock = 0;
    private int magicalReflect = 0;
    private int focusPoints = 0;
    private boolean channeling = false;
    private int potentialFocusGain = 0;
    private List<Ability> abilities = new ArrayList<>();

    public Entity(int initHP) {
        healthPoints = initHP;
        maxHealth = initHP;
    }

    @Override
    public void addHealth(int amount) {
        System.out.println(getName() + " gains " + amount + " health");
        healthPoints += amount;
    }

    @Override
    public boolean removeHealth(int amount, String type) {
        System.out.println(getName() + " takes " + amount + ' ' + type);
        healthPoints -= amount;
        if (healthPoints <= 0) {
            System.out.println(getName() + " dies");
            return true;
        }
        return false;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
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

    public int getPotentialFocusGain() {
        return potentialFocusGain;
    }

    public void setPotentialFocusGain(int potentialFocusGain) {
        this.potentialFocusGain = potentialFocusGain;
    }

    public void givePotentialFocus(newUI newUI) {
        if (isChanneling()) {
            int focusGain = getPotentialFocusGain();
            if (focusGain > 0) {
                newUI.stateFocusGain(this);
                addFocus(getPotentialFocusGain());
            }
            setChanneling(false);
        }
    }

    public void resetResistances() {
        physicalResistance = 0;
        magicalBlock = 0;
        magicalReflect = 0;
    }

    public abstract String getName();

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

    public void addAbility(Ability newAbility) {
        abilities.add(newAbility);
    }

    public void addAbilities(List<Ability> abilities) {
        for (Ability ability : abilities) {
            addAbility(ability);
        }
    }



    protected abstract String printAttempts();

    public int getMagicalBlock() {
        return magicalBlock;
    }

    public void setMagicalBlock(int magicalBlock) {
        this.magicalBlock = magicalBlock;
    }

    public int getPhysicalResistance() {
        return physicalResistance;
    }

    public void setPhysicalResistance(int physicalResistance) {
        this.physicalResistance = physicalResistance;
    }

    public int getMagicalReflect() {
        return magicalReflect;
    }

    public void setMagicalReflect(int magicalReflect) {
        this.magicalReflect = magicalReflect;
    }
}
