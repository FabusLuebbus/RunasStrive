package gamemodelling;


import java.util.HashMap;
import java.util.Map;

public class Runa extends Entity {
    private int maxFocusPoints;

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

    @Override
    protected String printAppendix() {
        return "";
    }
}
