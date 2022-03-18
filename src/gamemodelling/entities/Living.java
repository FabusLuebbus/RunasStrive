package gamemodelling.entities;

public interface Living {
    void addHealth(int amount);

    boolean removeHealth(int amount, String type);

    void addFocus(int amount);

    void removeFocus(int amount);
}
