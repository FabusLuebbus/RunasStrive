package states;

import game.Game;
import gamemodelling.abilities.Ability;

import java.util.List;

public class postFight extends State {
    int numOfRewardCards;
    public postFight(Game context, int numOfRewardCards) {
        super(context);
        this.numOfRewardCards = numOfRewardCards;
    }

    @Override
    public void start() {
        int choice = 1;
        if (game.getRuna().getMaxFocusPoints() < 12) {
            choice = newUI.selectRewardOption();
        }
        switch (choice) {
            case 2:
                game.getRuna().upgradeDie(newUI);
                break;
            case 1:
                List<Ability> selectedAbilities = newUI.selectRewardAbilities(numOfRewardCards);
                for (Ability ability : selectedAbilities) {
                    game.getRuna().addAbility(ability);
                }
        }
        //healing
        List<Ability> discardAbilities = newUI.selectHealingDiscard();
    }
}
