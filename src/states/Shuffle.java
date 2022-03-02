package states;

import game.Game;
import gameModelling.Card;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Shuffle extends State{

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
            if (input.matches("[0-9]*,[0-9]*")){
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
                Collections.shuffle(game.getAbilityList(), new Random(inputArray[0]));
                
            } else {
                repeat = true;
            }
        }
        
    }

    @Override
    public void nextState(State s) {

    }
}
