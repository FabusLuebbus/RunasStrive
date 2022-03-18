package gamemodelling.abilities;

import gamemodelling.entities.Entity;
import states.Stage;

public interface Playable {
    void play(Entity user, Entity target, Stage stage);

    boolean checkIfAllowed();
}
