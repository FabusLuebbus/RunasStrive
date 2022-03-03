package gamemodelling;

import states.Stage;

public abstract class NonOffensiveAbility extends Ability {

    public NonOffensiveAbility(int initLvl, int ip) {
        super(initLvl, ip);
    }

    public abstract void use(Entity user);

    public void play(Entity user) {
        /*
        if (!checkIfAllowed()) {
            return;
        }

         */
        System.out.println(user.getName() + " uses " + this.getName());
        this.use(user);

    }

    @Override
    public void play(Entity user, Entity target, Stage stage) {
        throw new IllegalArgumentException("this ability has the user as target");
    }
}
