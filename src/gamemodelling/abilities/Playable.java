package gamemodelling.abilities;

import UI.newUI;
import gamemodelling.entities.Entity;
import states.Stage;

public interface Playable {
    void play(Entity user, newUI newUI);

    boolean checkIfAllowed();
}
