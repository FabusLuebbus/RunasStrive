package gamemodelling;


import java.util.HashMap;
import java.util.Map;

public class Runa extends Entity {
    private int maxFocusPoints;
    private int parryAmount = 0;
    private int reflectAmount = 0;

    public Runa() {
        super(50);
        maxFocusPoints = 6;
    }

    public void upgradeDie() {
        if (maxFocusPoints + 2 > 12) {
            throw new IllegalArgumentException("No further dice upgrades possible.");
        }
        maxFocusPoints += 2;
    }

    public int getMaxFocusPoints() {
        return maxFocusPoints;
    }

    public int getParryAmount() {
        return parryAmount;
    }

    public void setParryAmount(int parryAmount) {
        this.parryAmount = parryAmount;
    }

    public int getReflectAmount() {
        return reflectAmount;
    }

    public void setReflectAmount(int reflectAmount) {
        this.reflectAmount = reflectAmount;
    }


    public int getAvailableFocusPoints() {
        //returns AVAILABLE points
        return super.getFocusPoints() - 1;
    }

    @Override
    public int getFocusPoints() {
        return super.getFocusPoints();
    }

    @Override
    protected String printAppendix() {
        return "";
    }
    
}
