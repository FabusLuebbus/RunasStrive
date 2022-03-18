package states;

import game.Game;
import UI.UI;
import game.GameUtil;
import gamemodelling.entities.Entity;
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
import gamemodelling.entities.monsters.level1.Frog;
import gamemodelling.entities.monsters.level1.Ghost;
import gamemodelling.entities.monsters.level1.Goblin;
import gamemodelling.entities.monsters.level1.Gorgon;
import gamemodelling.entities.monsters.level1.Mushroomlin;
import gamemodelling.entities.monsters.level1.Rat;
import gamemodelling.entities.monsters.level1.Skeleton;
import gamemodelling.entities.monsters.level1.Spider;

import java.util.Collections;
import java.util.List;
import java.util.Set;

public class Initialize extends State {

    public Initialize(Game game) {
        super(game);
    }

    @Override
    public void start() {

        boolean repeat = true;

        game.setLevel(1);
        game.addAbilities(List.of(new Slash(1), new Swing(1), new Thrust(1), new Pierce(1), new Parry(1),
                new Focus(1), new Reflect(1), new Water(1), new Ice(1), new Fire(1), new Lightning(1)));

        game.addMonsters(List.of(new Frog(), new Ghost(), new Gorgon(), new Skeleton(), new Spider(), new Goblin(),
                new Rat(), new Mushroomlin()));
        Entity runa = game.getRuna();
        System.out.println("Welcome to Runa's Strive\nSelect Runa's character class\n1) Warrior\n2) Mage\n3) Paladin");
        while (repeat) {
            //normally only one repetition is needed
            repeat = false;
            //TODO classes for runa?
            //TODO extract to ui
            switch (UI.getSingleInput(3)) {
                case 1:
                    GameUtil.moveCards(Set.of("Thrust(1)", "Parry(1)"), game.getAbilities(), runa.getAbilities());
                    break;

                case 2:
                    GameUtil.moveCards(Set.of("Focus(1)", "Water(1)"), game.getAbilities(), runa.getAbilities());
                    break;

                case 3:
                    GameUtil.moveCards(Set.of("Slash(1)", "Reflect(1)"), game.getAbilities(), runa.getAbilities());
                    break;

                default:
                    repeat = true;
                    break;
            }
        }
        Collections.sort(runa.getAbilities());
        nextState(new Shuffle(game));
    }
}
