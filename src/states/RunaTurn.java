package states;

import game.Game;
import gamemodelling.Ability;
import gamemodelling.Runa;

import java.util.List;
import java.util.Scanner;

public class RunaTurn extends State {
    Stage stage;
    public RunaTurn(Game context, Stage stage) {
        super(context);
        this.stage = stage;
    }

    @Override
    public void start() {
        stage.printFighters();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select card to play");
        stage.printAbilities();
        List<Ability> abilities = game.getRuna().getAbilities();
        running = true;
        while (running) {
            System.out.println("Enter number [1--" + abilities.size() + "]:");
            int input = scanner.nextInt();
            if (input > abilities.size() || input < 1) {
                continue;
            }
            abilities.get(input - 1).play(stage.fighters.get(0), stage.fighters.get(1), stage);
            running = false;
        }
        nextState(new FocusPointsMonsters(game, stage));
    }
}
