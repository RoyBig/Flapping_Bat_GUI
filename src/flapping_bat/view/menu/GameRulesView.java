package flapping_bat.view.menu;

import flapping_bat.model.Position;
import flapping_bat.model.enums.Colors;
import flapping_bat.model.menu.GameRules;
import flapping_bat.textGUI.LanternaTextGUI;

public class GameRulesView extends MenuView<GameRules> {
    public GameRulesView(GameRules gameRules){super(gameRules,new Position(2,7));

    }
    protected void drawInsideElements(LanternaTextGUI lanternaTextGUI) {
        drawTitle(lanternaTextGUI, "Game Rules", Colors.ORANGE.getHex());

        for (int i = 0; i < getModel().getSize(); i++) {
            drawText(lanternaTextGUI, new Position(2, 7 + i), getModel().getLine(i), Colors.WHITE.getHex());
        }
    }
    @Override
    public void drawOptions(LanternaTextGUI lanternaTextGUI) {

    }

}
