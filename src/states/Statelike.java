package states;

public interface Statelike {
    void start();

    void nextState(State s);
}
