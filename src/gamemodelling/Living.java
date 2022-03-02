package gamemodelling;

public interface Living {
    void addHealth(int amount);

    boolean removeHealth(int amount);

    void addFocus(int amount);

    void removeFocus(int amount);
}
