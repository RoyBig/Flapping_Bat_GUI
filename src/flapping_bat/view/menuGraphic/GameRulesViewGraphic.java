package flapping_bat.view.menuGraphic;

import flapping_bat.GUI.SwingGUI;
import flapping_bat.controller.menuGraphic.TextToMenuControllerGraphic;
import flapping_bat.model.menu.GameRules;
import flapping_bat.view.ViewGraphic;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameRulesViewGraphic extends ViewGraphic {
    TextToMenuControllerGraphic gameRulesControllerGraphic;
    public GameRulesViewGraphic(SwingGUI swingGUI, TextToMenuControllerGraphic gameRulesControllerGraphic, GameRules gameRules){
        swingGUI.clear();
        this.gameRulesControllerGraphic = gameRulesControllerGraphic;
        swingGUI.paintBackground("src/resources/backgroundRules.png");
        for (int i = 0; i < gameRules.getSize(); i++) {
            swingGUI.addText(gameRules.getLine(i), new Font("SansSerif", Font.BOLD, 20),85,(100+i*16),500,100,Color.orange);
        }
        swingGUI.addButton("src/resources/back.png", 0, 0, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameRulesControllerGraphic.backButtonPressed();
            }
        });
        swingGUI.setVisible();

    }

}
