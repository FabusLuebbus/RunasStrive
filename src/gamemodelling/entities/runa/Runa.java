package gamemodelling.entities.runa;


import UI.newUI;
import gamemodelling.abilities.Ability;
import gamemodelling.entities.Entity;

public class Runa extends Entity {

    private RunaClasses runaClass;
    private int maxFocusPoints;

    public Runa(RunaClasses runaClass) {
        super(50);
        maxFocusPoints = 4;
        addFocus(1);
        this.runaClass = runaClass;
        addAbilities(this.runaClass.getStartingAbilities());
    }

    public void upgradeDie(newUI newUI) {
        maxFocusPoints += 2;
        newUI.stateDieUpgrade(this);
    }

    public int getMaxFocusPoints() {
        return maxFocusPoints;
    }

    public RunaClasses getRunaClass() {
        return runaClass;
    }

    @Override
    public void removeFocus(int amount) {
        super.removeFocus(amount);
        if (getFocusPoints() < 1) {
            addFocus(1);
        }
    }

    @Override
    public boolean removeHealth(int amount, String type) {
        if (super.removeHealth(amount, type)) {
            //TODO throw quit
        }
        return getHealthPoints() <= 0;
    }

    @Override
    public int getFocusPoints() {
        return super.getFocusPoints();
    }

    @Override
    public String getName() {
        return "Runa";
    }

    public void print() {
        System.out.println(getName() + " (" + getHealthPoints() + '/' + getMaxHealth() + "HP, "
                + getFocusPoints() + '/' + getMaxFocusPoints() + " FP)" + printAttempts());
    }

    @Override
    protected String printAttempts() {
        return "";
    }
}
