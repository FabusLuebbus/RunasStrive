package gamemodelling;

public interface Playable {
    void play(Entity user, Entity target);

    boolean checkIfAllowed();
}
