package states;

import game.Game;
import gamemodelling.abilities.Focus;
import gamemodelling.abilities.runa.Fire;
import gamemodelling.abilities.runa.Ice;
import gamemodelling.abilities.runa.Lightning;
import gamemodelling.abilities.runa.Parry;
import gamemodelling.abilities.runa.Pierce;
import gamemodelling.abilities.runa.Reflect;
import gamemodelling.abilities.runa.Slash;
import gamemodelling.abilities.runa.Swing;
import gamemodelling.abilities.runa.Thrust;
import gamemodelling.abilities.runa.Water;
import gamemodelling.entities.monsters.Monster;
import gamemodelling.entities.monsters.Monsters;
import gamemodelling.entities.runa.Runa;

import java.util.Collections;
import java.util.List;

public class Initialize extends State {

    public Initialize(Game game) {
        super(game);
    }

    @Override
    public void start() {
        game.setLevel(1);
        game.setStageNumber(1);
        game.setCurrentStageBoss(new Monster(Monsters.SPIDER_KING));
        game.addAbilities(List.of(new Slash(1), new Swing(1), new Thrust(1), new Pierce(1), new Parry(1),
                new Focus(1), new Reflect(1), new Water(1), new Ice(1), new Fire(1), new Lightning(1)));

        game.addMonsters(List.of(new Monster(Monsters.FROG), new Monster(Monsters.GHOST), new Monster(Monsters.GORGON),
                new Monster(Monsters.SKELETON), new Monster(Monsters.SPIDER), new Monster(Monsters.GOBLIN),
                new Monster(Monsters.RAT), new Monster(Monsters.MUSHROOMLIN)));

        game.setRuna(new Runa(newUI.setupAndGetInitialRunaClass()));
        Runa runa = game.getRuna();
        game.getAbilityList().removeAll(runa.getAbilities());
        Collections.sort(runa.getAbilities());
        nextState(new Shuffle(game));
    }
}
