package gamemodelling;

import states.Stage;

public interface Playable {
    void play(Entity user, Entity target, Stage stage);

    boolean checkIfAllowed();
}
