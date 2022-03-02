package gameModelling;

public abstract class Card implements Playable, Comparable<Card>{
    protected int level;
    protected int number;

    public Card(int initLvl, int orderingNumber) {
        level = initLvl;
        number = orderingNumber;
    }

    public void setLvl(int lvl) {
        level = lvl;
    }

    @Override
    public abstract void play();

    @Override
    public boolean checkIfAllowed() {
        return false;
    }

    public String getName() {
        return this.getClass().getSimpleName();
    }

    public int getLevel() {
        return level;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "(" + level + ")";
    }

    @Override
    public int compareTo(Card card) {
        return Integer.compare(this.number, card.number);
    }
}
