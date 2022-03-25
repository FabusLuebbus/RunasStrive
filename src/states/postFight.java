package states;

import game.Game;
import gamemodelling.abilities.Ability;
import gamemodelling.entities.runa.Runa;

import java.util.List;

public class postFight extends State {
    int numOfRewardCards;
    public postFight(Game context, int numOfRewardCards) {
        super(context);
        this.numOfRewardCards = numOfRewardCards;
    }

    @Override
    public void start() {
        Runa runa = game.getRuna();
        if (game.getStageNumber() == 4) {
            //after bossfight
            //todo insert ENDLEVEL instead of 2
            if (game.getLevel() == 2) {
                nextState(new GameOver(game));
                return;
            }
            List<Ability> newAbilities = runa.getRunaClass().getAbilityUpgrade();
            newUI.stateNewAbilities(newAbilities);
            runa.addAbilities(newAbilities);
            game.incrLevel();
            nextState(new InitializeLevel(game));
        } else {
            //after normal fight
            int choice = 1;
            if (runa.getMaxFocusPoints() < 12) {
                choice = newUI.selectRewardOption();
            }
            //todo quit int
            if (game.isAbort()) {
                return;
            }
            switch (choice) {
                case 2:
                    runa.upgradeDie(newUI);
                    break;
                case 1:
                    List<Ability> selectedAbilities = newUI.selectRewardAbilities(numOfRewardCards);
                    if (game.isAbort()) {
                        return;
                    }
                    newUI.stateNewAbilities(selectedAbilities);
                    for (Ability ability : selectedAbilities) {
                        runa.addAbility(ability);

                    }
            }
            game.incrStage();
            nextState(new Stage(game));
        }

        //healing
        //TODO magic numbers
        if (runa.getHealthPoints() < 50 && runa.getAbilities().size() > 1) {
            List<Ability> discardForHealing = newUI.selectHealingDiscard();
            if (game.isAbort()) {
                return;
            }
            int healAmount = 0;
            for (Ability ability : discardForHealing) {
                runa.getAbilities().remove(ability);
                healAmount += (Math.min(10, runa.getMaxHealth() - (runa.getHealthPoints() + healAmount)));
            }
            if (healAmount > 0) {
                runa.addHealth(healAmount);
            }
        }

    }
}
