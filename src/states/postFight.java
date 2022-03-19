package states;

import game.Game;
import UI.newUI;
import gamemodelling.abilities.Ability;

import java.util.List;

public class postFight extends State {
    int defeatedEnemies;
    public postFight(Game context, int defeatedEnemies) {
        super(context);
        this.defeatedEnemies = defeatedEnemies;
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
                List<Ability> selectedAbilities = newUI.selectRewardAbilities();
                for (Ability ability : selectedAbilities) {
                    game.getRuna().addAbility(ability);
                }
        }
        //healing
        List<Ability> discardAbilities = newUI.selectHealingDiscard();
    }
}
