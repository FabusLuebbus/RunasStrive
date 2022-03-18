package UI;

import gamemodelling.abilities.Ability;
import gamemodelling.entities.Entity;
import gamemodelling.entities.runa.Runa;
import states.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UI {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String MULTIPLE_INPUT_FORMAT = "^(?!0)([0-9]+,)*[0-9]+$";
    private static final String INPUT_FORMAT = "^quit$|^$|" + MULTIPLE_INPUT_FORMAT;


    //TODO constants
    private static final String QUIT_CODE = "-1";
    private static final int QUIT_INT = -1;
    private static final String NO_ACTION_CODE = "-2";
    private static final int NO_ACTION_INT = -2;

    public static int getSingleInput(int upperBoundary) {
        return getInputNumber(upperBoundary, "Enter number [1--" + upperBoundary + "]:");
    }

    public static int getDiceRoll(int upperBoundary) {
        return getInputNumber(upperBoundary, "Enter dice roll [1--" + upperBoundary + "]:");
    }



    public static int getInputNumber(int upperBoundary, String request) {
        boolean running = true;
        int input = 0;
        while (running) {
            String inputString = getInputString(request);
            try {
                input = Integer.parseInt(inputString);
            } catch (NumberFormatException e) {
                continue;
            }

            //TODO check if castable
            if (input > upperBoundary || input < NO_ACTION_INT) {
                continue;
            }
            running = false;
        }
        return input;

    }

    public static String getInputString(String inputRequest) {
        boolean repeat;
        String input;
        do {
            repeat = false;
            System.out.println(inputRequest);
            input = SCANNER.next();
            if (!input.matches(INPUT_FORMAT)) {
                repeat = true;
            }
        } while (repeat);

        if (input.equals("quit")) {
            input = QUIT_CODE;
        }

        if (input.equals("")) {
            input = NO_ACTION_CODE;
        }
        return input;
    }

    public static Ability selectCard(Runa runa) {
        //TODO check for valid input
        System.out.println("Select card to play");
        runa.printAbilities();
        List<Ability> abilities = runa.getAbilities();
        int index = getSingleInput(abilities.size()) - 1;
        return abilities.get(index);
    }

    public static Entity selectTarget(Stage stage) {
        List<Entity> monsters = stage.getFighters().subList(1, stage.getFighters().size());
        if (monsters.size() == 1) {
            return monsters.get(0);
        }
        System.out.println("Select Runa’s target.");
        for (int i = 0; i < monsters.size(); i++) {
            System.out.println((i + 1) + ") " + monsters.get(i).getName());
        }
        return monsters.get(getSingleInput(monsters.size()) - 1);
    }

    //TODO think about putting this back into shuffle state
    public static List<Integer> getShuffleSeeds() {
        System.out.println("To shuffle ability cards and monsters, enter two seeds");
        return getMultipleInputs(2, "Enter seeds [1--2147483647] separated by comma:");
    }

    public static List<Integer> getMultipleInputs(int amount, String request) {
        boolean repeat = true;
        List<Integer> inputs = new ArrayList<>();
        while (repeat) {
            repeat = false;
            String[] tempInput = getInputString(request).split(",");
            if (tempInput.length != amount) {
                if (tempInput[0].equals(NO_ACTION_CODE) || tempInput[0].equals(QUIT_CODE)) {
                    return new ArrayList<>(Integer.parseInt(tempInput[0]));
                }
                repeat = true;
                continue;
            }
            for (int i = 0; i < amount; i++) {
                int partAsInt;
                try {
                    partAsInt = Integer.parseInt(tempInput[i]);
                } catch (NumberFormatException e) {
                    repeat = true;
                    break;
                }
                //TODO use isEmpty() here
                if (partAsInt < NO_ACTION_INT) {
                    repeat = true;
                    break;
                }
                if (partAsInt < 0) {
                    break;
                }
                inputArray[i] = partAsInt;
            }
        }
        return inputArray;
    }

    public static List<Ability> getAbilityChoice(List<Ability> offeredAbilities, int amount) {
        System.out.println("Pick " + amount + " card(s) as loot");
        Ability[] choices = new Ability[amount];
        for (int i = 0; i < offeredAbilities.size(); i++) {
            Ability current = offeredAbilities.get(i);
            System.out.println((i + 1) + ") " + current.getName());
        }
        List<Integer> input;
        if (amount == 1) {
            input = new ArrayList<>(getSingleInput(2));
        } else {
            input = getMultipleInputs(amount, enterMultipleNumbersRequest(2 * amount));

        }
        for (int i = 0; i < choices.length; i++) {
            choices[i] = offeredAbilities[input[i] - 1];
        }
        return choices;
    }








    public static void stateFocusGain(Entity entity) {
        System.out.println(entity.getName() + " gains " + entity.getPotentialFocusGain() + " focus");
    }

    public static void stateDieUpgrade(Runa runa) {
        System.out.println("Runa upgrades her die to a d" + runa.getMaxFocusPoints());
    }

    public static int getRewardChoice() {
        System.out.println("Choose Runa's reward\n1) new ability cards\n2) next player dice");
        return getSingleInput(2);
    }

    public static void stateAbilityChoice(int index, Ability ability) {
        System.out.println(index + ") " + ability.getName());
    }

    public static String enterMultipleNumbersRequest(int upperBoundary) {
        return "Enter numbers [1--" + upperBoundary + "] separated by comma:";
    }


}
