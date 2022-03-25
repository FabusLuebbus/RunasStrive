package UI;

import game.Game;
import gamemodelling.abilities.Ability;
import gamemodelling.entities.Entity;
import gamemodelling.entities.monsters.Monster;
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
    private static final String QUIT = "quit";
    private static final int NO_ACTION_INT = 0;
    private static final int QUIT_INT = -1;
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
        switch (getSingleInput(3, false)) {
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


    public List<Integer> getMultipleInputs(int amount, String request, boolean allowNoAction, boolean allowDoubleEntries) {
        List<Integer> inputs;
        do {
            inputs = getMultipleInputs(request, allowNoAction, allowDoubleEntries);
        } while (inputs.size() != amount && inputs.get(0) != QUIT_INT);
        return inputs;
    }

    private List<Integer> getMultipleInputs(String request, boolean allowNoAction, boolean allowDoubleEntries) {
        //Todo make no input possible
        List<Integer> inputs = new ArrayList<>();
        boolean repeat = true;
        while (repeat) {
            repeat = false;
            String[] tempInput = getInputString(request).split(",");
            for (int i = 0; i < tempInput.length; i++) {
                int partAsInt;
                try {
                    partAsInt = Integer.parseInt(tempInput[i]);
                } catch (NumberFormatException e) {
                    repeat = true;
                    break;
                }

                //TODO use isEmpty() here
                if (partAsInt < QUIT_INT || (!allowNoAction && partAsInt == NO_ACTION_INT)
                        || (!allowDoubleEntries && inputs.contains(partAsInt))) {
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
        List<Integer> seedList = getMultipleInputs(2, "Enter seeds [1--2147483647] separated by comma:", false, true);
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
        int input = getSingleInput(abilities.size(), false);
        if (input == QUIT_INT) {
            return null;
        }
        int index = --input;
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
        List<Monster> monsters = stage.getMonsters();
        System.out.println(SEGMENT_SEPARATOR);
        game.getRuna().print();
        System.out.println("vs.");
        for (Monster monster : monsters) {
            monster.print();
        }
        System.out.println(SEGMENT_SEPARATOR);
    }

    @Override
    public Entity selectTarget() {
        Stage stage = game.getCurrentStage();
        List<Monster> monsters = stage.getMonsters();
        if (monsters.size() == 1) {
            return monsters.get(0);
        }
        System.out.println("Select Runa’s target.");
        for (int i = 0; i < monsters.size(); i++) {
            System.out.println((i + 1) + ") " + monsters.get(i).getName());
        }
        return monsters.get(getSingleInput(monsters.size(), false) - 1);
    }

    @Override
    public int selectRewardOption() {
        System.out.println("Choose Runa’s reward\n1) new ability cards\n2) next player dice");
        int input;
        do {
            input = getSingleInput(2, false);
        } while (input == NO_ACTION_INT);
        return input;
    }

    @Override
    public List<Ability> selectRewardAbilities(int amount) {
        System.out.println("Pick " + amount + " card(s) as loot");
        List<Ability> abilities = game.getAbilityList();
        List<Ability> offeredAbilities = List.copyOf(abilities.subList(0, Math.min((2 * amount), abilities.size())));
        printAbilityList(offeredAbilities);
        List<Integer> choices = new LinkedList<>();
        do {
            if (amount == 1) {
                choices.add(getSingleInput(amount * 2, false));
            } else {
                choices = (getMultipleInputs(amount, "Enter numbers [1--" + (amount * 2)
                        + "] separated by comma:", false, false));
            }
        } while (choices.get(0) == NO_ACTION_INT);
        if (choices.get(0) == QUIT_INT) {
            return null;
        }
        game.removeAbilitiesFromList(offeredAbilities);
        return getAbilitiesFromIndices(choices, offeredAbilities);
    }

    @Override
    public List<Ability> selectHealingDiscard() {
        Runa runa = game.getRuna();
        List<Ability> runaAbilities = game.getRuna().getAbilities();
        int maxDiscardAmount = runaAbilities.size() - 1;
        System.out.println("Runa (" + runa.getHealthPoints() + "/" + runa.getMaxHealth()
                + " HP) can discard ability cards for healing (or none)");
        printAbilityList(runaAbilities);
        List<Integer> choices = new LinkedList<>();
        if (maxDiscardAmount == 1) {
            choices.add(getSingleInput(runaAbilities.size(), true));
        } else {
            do {
                choices = getMultipleInputs("Enter numbers [1--" + runaAbilities.size()
                        + "] separated by comma:", true, false);
            } while (choices.size() > maxDiscardAmount);
        }
        if (choices.get(0) == NO_ACTION_INT || choices.get(0) == QUIT_INT) {
            return new LinkedList<>();
        }
        return getAbilitiesFromIndices(choices, runaAbilities);
    }

    /**
     * this method returns a selection of abilities based on a list of indices given as parameter.
     * note that all indices are incremented by one in order to match output format. This means
     * that in thie method every index has to be decremented before accessing list.
     *
     * @param indices list of indices
     * @param abilities base list of abilities
     * @return selection of abilities based on index list
     */
    private List<Ability> getAbilitiesFromIndices(List<Integer> indices, List<Ability> abilities) {
        List<Ability> output = new LinkedList<>();
        for (int i : indices) {
            output.add(abilities.get(i - 1));
        }
        return output;
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
    public void stateNewAbilities(List<Ability> abilities) {
        for (Ability ability : abilities) {
            System.out.println("Runa gets " + ability.getName());
        }
    }

    @Override
    public void stateAbilityUsage(Entity user, Ability ability) {
        System.out.println(user.getName() + " uses " + ability.getName());
    }

    public int getDiceRoll(int upperBoundary) {
        return getInputNumber(upperBoundary, "Enter dice roll [1--" + upperBoundary + "]:", false);
    }

    private int getSingleInput(int upperBoundary, boolean allowNoAction) {
        return getInputNumber(upperBoundary, "Enter number [1--" + upperBoundary + "]:", allowNoAction);
    }

    private int getInputNumber(int upperBoundary, String request, boolean allowNoAction) {
        boolean running = true;
        int input = 0;
        while (running) {
            String inputString = getInputString(request);
            try {
                input = Integer.parseInt(inputString);
            } catch (NumberFormatException e) {
                continue;
            }

            if (input > upperBoundary || input < QUIT_INT || (input == NO_ACTION_INT && !allowNoAction)) {
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
            input = scanner.nextLine();
            if (!input.matches(INPUT_FORMAT)) {
                repeat = true;
            }
        } while (repeat);

        if (input.equals(QUIT)) {
            //Todo fertig machen
            game.abort();
            return Integer.toString(QUIT_INT);
        }

        if (input.isEmpty()) {
            input = NO_ACTION_CODE;
        }
        return input;
    }

    private void printAbilityList(List<Ability> abilities) {
        for (int i = 0; i < abilities.size(); i++) {
            System.out.println((i + 1) + ") " + abilities.get(i).getName());
        }
    }

}
