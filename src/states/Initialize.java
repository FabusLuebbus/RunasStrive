package states;

import game.Game;
import game.GameUtil;
import gameModelling.Entity;
import gameModelling.cards.abilities.runa.Focus;
import gameModelling.cards.abilities.runa.Fire;
import gameModelling.cards.abilities.runa.Ice;
import gameModelling.cards.abilities.runa.Lightning;
import gameModelling.cards.abilities.runa.Parry;
import gameModelling.cards.abilities.runa.Pierce;
import gameModelling.cards.abilities.runa.Reflect;
import gameModelling.cards.abilities.runa.Slash;
import gameModelling.cards.abilities.runa.Swing;
import gameModelling.cards.abilities.runa.Thrust;
import gameModelling.cards.abilities.runa.Water;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Initialize extends State{

    public Initialize(Game game) {
        super(game);
    }

    @Override
    public void start() {
        boolean repeat = true;
        Scanner scanner = new Scanner(System.in);

        game.addAbilities(List.of(new Slash(1), new Swing(1), new Thrust(1), new Pierce(1), new Parry(1),
                new Focus(1), new Reflect(1), new Water(1), new Ice(1), new Fire(1), new Lightning(1)));
        Entity runa = game.getRuna();
        System.out.println("Welcome to Runa's Strive\nSelect Runa's character class\n1) Warrior\n2) Mage\n3) Paladin");
        while (repeat) {
            //normally only one repetition is needed
            repeat = false;
            System.out.println("Enter number [1--3]:");
            switch (scanner.next()) {
                case "1":
                    GameUtil.moveCards(Set.of("Focus", "Water"), game.getAbilities(), runa.getAbilities());
                    break;

                case "2":
                    GameUtil.moveCards(Set.of("Thrust", "Parry"), game.getAbilities(), runa.getAbilities());
                    break;

                case "3":
                    GameUtil.moveCards(Set.of("Slash", "Reflect"), game.getAbilities(), runa.getAbilities());
                    break;

                case "quit":
                    break;

                default:
                    repeat = true;
                    break;
            }
        }
        game.updateAbilityList(1);
        Collections.sort(game.getAbilityList());
        nextState(new Shuffle(game));
    }
}
