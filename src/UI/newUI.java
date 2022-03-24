package UI;

import game.Game;
import gamemodelling.abilities.Ability;
import gamemodelling.entities.Entity;
import gamemodelling.entities.runa.Runa;
import gamemodelling.entities.runa.RunaClasses;
import states.Stage;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class newUI implements UserInterface {
    private static final String MULTIPLE_INPUT_FORMAT = "^(?!0)([0-9]+,)*[0-9]+$";
    private static final String INPUT_FORMAT = "^quit$|^$|" + MULTIPLE_INPUT_FORMAT;
    private static final String NO_ACTION_CODE = "0";
    private static final int NO_ACTION_INT = 0;
    private static final String SEGMENT_SEPARATOR = "----------------------------------------";

    private final Scanner scanner = new Scanner(System.in);
    Game game;

    public newUI(Game game) {
        this.game = game;
    }

    @Override
    public RunaClasses setupAndGetInitialRunaClass() {
        System.out.println("Welcome to Runa's Strive\nSelect Runa's character class\n1) Warrior\n2) Mage\n3) Paladin");
        RunaClasses runaClass = null;
        switch (getSingleInput(3)) {
            case 1:
                runaClass = RunaClasses.WARRIOR;
                break;

            case 2:
                runaClass = RunaClasses.MAGE;
                break;

            case 3:
                runaClass = RunaClasses.PALADIN;
                break;

            default:
                break;
        }
        return runaClass;
    }

    @Override
    public List<Integer> getMultipleInputs(int amount, String request) {
        boolean repeat = true;
        List<Integer> inputs = new ArrayList<>();
        while (repeat) {
            repeat = false;
            String[] tempInput = getInputString(request).split(",");
            if (tempInput.length != amount) {
                if (tempInput[0].equals(NO_ACTION_CODE) ) {
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
                inputs.add(i, partAsInt);
            }
        }
        return inputs;
    }

    @Override
    public int[] getShuffleSeeds() {
        System.out.println("To shuffle ability cards and monsters, enter two seeds");
        List<Integer> seedList = getMultipleInputs(2, "Enter seeds [1--2147483647] separated by comma:");
        return seedList.stream().mapToInt(Integer::intValue).toArray();
    }

    @Override
    public void stateRoomEntering() {
        System.out.println("Runa enters Stage " + game.getStageNumber() + " of Level " + game.getLevel());
    }

    @Override
    public Ability selectAbilityToPlay() {
        System.out.println("Select card to play");
        Runa runa = game.getRuna();
        List<Ability> abilities = runa.getAbilities();
        printRunaAbilities();
        int index = getSingleInput(abilities.size()) - 1;
        return abilities.get(index);
    }

    private void printRunaAbilities() {
        List<Ability> abilities = game.getRuna().getAbilities();
        for (int i = 1; i <= abilities.size(); i++) {
            Ability ability = abilities.get(i - 1);
            System.out.println(i + ") " + ability.getName());
        }

    }

    public void printStageFighters(Stage stage) {
        List<Entity> fighters = stage.getFighters();
        System.out.println(SEGMENT_SEPARATOR);
        fighters.get(0).print();
        System.out.println("vs.");
        for (int i = 1; i < fighters.size(); i++) {
            fighters.get(i).print();
        }
        System.out.println(SEGMENT_SEPARATOR);
    }

    @Override
    public Entity selectTarget() {
        Stage stage = game.getCurrentStage();
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

    @Override
    public int selectRewardOption() {
        System.out.println("Choose Runa’s reward\n1) new ability cards\n2) next player dice");
        return getSingleInput(2);
    }

    @Override
    public List<Ability> selectRewardAbilities(int amount) {
        System.out.println("Pick " + amount + " card(s) as loot");
        List<Ability> abilities = game.getAbilityList();
        List<Ability> offeredAbilities = List.copyOf(abilities.subList(0, Math.min((2 * amount), abilities.size())));
        List<Ability> chosenAbilities = new LinkedList<>();
        for (int i = 0; i < offeredAbilities.size(); i++) {
            System.out.println((i + 1) + ") " + offeredAbilities.get(i).getName());
        }
        List<Integer> choices = new LinkedList<Integer>();
        if (amount == 1) {
            choices.add(getSingleInput(amount * 2));
        } else {
            choices.addAll(getMultipleInputs(amount, "Enter numbers [1--" + (amount * 2) + "] separated by comma:"));
        }
        for (int i : choices) {
            chosenAbilities.add(offeredAbilities.get(i - 1));
        }
        game.removeAbilitiesFromList(offeredAbilities);
        return chosenAbilities;
    }

    @Override
    public List<Ability> selectHealingDiscard() {
        return null;
    }

    @Override
    public void stateFocusGain(Entity entity) {
        System.out.println(entity.getName() + " gains " + entity.getPotentialFocusGain() + " focus");

    }

    @Override
    public void stateDieUpgrade(Runa runa) {
        System.out.println("Runa upgrades her die to a d" + runa.getMaxFocusPoints());
    }

    @Override
    public void stateAbilityUsage(Entity user, Ability ability) {
        System.out.println(user.getName() + " uses " + ability.getName());
    }

    public int getDiceRoll(int upperBoundary) {
        return getInputNumber(upperBoundary, "Enter dice roll [1--" + upperBoundary + "]:");
    }

    private int getSingleInput(int upperBoundary) {
        return getInputNumber(upperBoundary, "Enter number [1--" + upperBoundary + "]:");
    }

    private int getInputNumber(int upperBoundary, String request) {
        boolean running = true;
        int input = 0;
        while (running) {
            String inputString = getInputString(request);
            try {
                input = Integer.parseInt(inputString);
            } catch (NumberFormatException e) {
                continue;
            }

            if (input > upperBoundary || input < NO_ACTION_INT) {
                continue;
            }
            running = false;
        }
        return input;
    }



    private String getInputString(String inputRequest) {
        boolean repeat;
        String input;
        do {
            repeat = false;
            System.out.println(inputRequest);
            input = scanner.next();
            if (!input.matches(INPUT_FORMAT)) {
                repeat = true;
            }
        } while (repeat);

        if (input.equals("quit")) {
            game.setAbort(true);
        }

        if (input.equals("")) {
            input = NO_ACTION_CODE;
        }
        return input;
    }

}
