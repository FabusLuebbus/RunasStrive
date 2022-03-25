package states;

import game.Game;
import gamemodelling.abilities.Ability;
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
import gamemodelling.entities.runa.RunaClasses;

import java.util.Collections;
import java.util.List;

public class InitializeLevel extends State {

    public InitializeLevel(Game game) {
        super(game);
    }

    @Override
    public void start() {
        game.setStageNumber(1);
        switch (game.getLevel()) {
            case 1:
                RunaClasses runaClass = newUI.setupAndGetInitialRunaClass();
                if (game.isAbort()) {
                    return;
                }
                game.setRuna(new Runa(runaClass));
                game.setCurrentStageBoss(new Monster(Monsters.SPIDER_KING));
                game.addAbilities(List.of(new Slash(1), new Swing(1), new Thrust(1), new Pierce(1), new Parry(1),
                        new Focus(1), new Reflect(1), new Water(1), new Ice(1), new Fire(1), new Lightning(1)));

                game.addMonsters(List.of(new Monster(Monsters.FROG), new Monster(Monsters.GHOST),
                        new Monster(Monsters.GORGON), new Monster(Monsters.SKELETON), new Monster(Monsters.SPIDER),
                        new Monster(Monsters.GOBLIN), new Monster(Monsters.RAT), new Monster(Monsters.MUSHROOMLIN)));

                game.getAbilityList().removeAll(game.getRuna().getAbilities());
                Collections.sort(game.getRuna().getAbilities());
                break;
            case 2:
                game.getMonsterList().clear();
                game.getAbilityList().clear();
                game.clearMonsterQueue();
                game.setCurrentStageBoss(new Monster(Monsters.MEGA_SAURUS));
                game.addAbilities(List.of(new Slash(2), new Swing(2), new Thrust(2), new Pierce(2), new Parry(2),
                        new Focus(2), new Reflect(2), new Water(2), new Ice(2), new Fire(2), new Lightning(2)));
                game.addMonsters(List.of(new Monster(Monsters.SNAKE), new Monster(Monsters.DARK_ELF),
                        new Monster(Monsters.SHADOW_BLADE), new Monster(Monsters.HORNET),
                        new Monster(Monsters.TARANTULA), new Monster(Monsters.BEAR),
                        new Monster(Monsters.MUSHROOMLON), new Monster(Monsters.WILD_BOAR)));
                game.getAbilityList().removeAll(game.getRuna().getRunaClass().getAbilityUpgrade());
                break;
            default:
                break;
        }
        Collections.sort(game.getMonsterList());
        nextState(new Shuffle(game));
    }
}
