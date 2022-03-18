package states;

import game.Game;
import UI.UI;
import gamemodelling.abilities.Ability;

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
            choice = UI.getRewardChoice();
        }
        switch (choice) {
            case 2:
                game.getRuna().upgradeDie();
                break;
            case 1:
                Ability[] selectedAbilities = UI.getAbilityChoice(choices, defeatedEnemies);
                for (Ability ability : selectedAbilities) {
                    game.getRuna().addAbility(ability);
                }
        }
        //healing
        Ability[] discardAbilities = UI.getAbilityChoice(game.getRuna().getAbilities().toArray(new Ability[0]), )
    }
}
