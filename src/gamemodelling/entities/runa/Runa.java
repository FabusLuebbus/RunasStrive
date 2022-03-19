package gamemodelling.entities.runa;


import UI.newUI;
import gamemodelling.abilities.Ability;
import gamemodelling.entities.Entity;

public class Runa extends Entity {
    private int maxFocusPoints;
    RunaClasses runaClass;

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

    public int getAvailableFocusPoints() {
        //returns AVAILABLE points
        return super.getFocusPoints() - 1;
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

    @Override
    protected String printAttempts() {
        return "";
    }
}
