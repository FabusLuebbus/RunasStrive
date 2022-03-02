package states;

import game.Game;
import gamemodelling.Ability;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Shuffle extends State {

    public Shuffle(Game context) {
        super(context);
    }

    @Override
    public void start() {
        Scanner scanner = new Scanner(System.in);
        boolean repeat = true;
        System.out.println("To shuffle ability cards and monsters, enter two seeds");
        while (repeat) {
            System.out.println("Enter seeds [1--2147483647] separated by comma:");
            repeat = false;
            String input = scanner.next();
            if (input.matches("[0-9]*,[0-9]*")) {
                int[] inputArray = new int[2];
                for (int i = 0; i < 2; i++) {
                    String part = input.split(",")[i];
                    int partAsInt = Integer.parseUnsignedInt(part);
                    if (partAsInt < 1) {
                        repeat = true;
                        break;
                    }
                    inputArray[i] = partAsInt;


                }
                List<Ability> tempAbilityList = game.getAbilityList();
                Collections.shuffle(tempAbilityList, new Random(inputArray[0]));
                game.addAbilitiesToQueue(tempAbilityList);
                Collections.shuffle(game.getMonsterList(), new Random(inputArray[1]));
                game.addMonstersToQueue(game.getMonsterList());
                
            } else {
                repeat = true;
            }
        }
        nextState(new Stage1(game));
    }
}
