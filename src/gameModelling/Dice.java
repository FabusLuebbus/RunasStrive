package gameModelling;

public class Dice {
    private int upperBoundary;

    public Dice(int upperBoundary) {
        this.upperBoundary = upperBoundary;
    }

    public void setDice(int upperBoundary) {
        this.upperBoundary = upperBoundary;
    }

    public void upgrade() {
        if (upperBoundary + 2 > 12) {
            throw new IllegalArgumentException("No further dice upgrades possible.");
        }
        setDice(upperBoundary + 2);
    }
    public int roll() {
        return (int) Math.floor((Math.random() * upperBoundary) + 1);
    }
}
