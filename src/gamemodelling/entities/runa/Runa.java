package gamemodelling.entities.runa;


import UI.UI;
import gamemodelling.abilities.Ability;
import gamemodelling.entities.Entity;

public class Runa extends Entity {
    private int maxFocusPoints;

    public Runa() {
        super(50);
        maxFocusPoints = 4;
        addFocus(1);
    }

    public void upgradeDie() {
        maxFocusPoints += 2;
        UI.stateDieUpgrade(this);
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
    protected String printAttempts() {
        return "";
    }

    public void printAbilities() {
        for (int i = 1; i <= getAbilities().size(); i++) {
            Ability ability = getAbilities().get(i - 1);
            System.out.println(i + ") " + ability.getName());
        }
    }


}
