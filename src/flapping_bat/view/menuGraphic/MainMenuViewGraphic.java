package flapping_bat.view.menuGraphic;

import flapping_bat.GUI.SwingGUI;
import flapping_bat.controller.menuGraphic.MainMenuControllerGraphic;
import flapping_bat.view.ViewGraphic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenuViewGraphic extends ViewGraphic {

    MainMenuControllerGraphic mainMenuControllerGraphic;

    public MainMenuViewGraphic(SwingGUI swingGUI, MainMenuControllerGraphic mainMenuControllerGraphic){
        this.mainMenuControllerGraphic = mainMenuControllerGraphic;
        swingGUI.clear();
        swingGUI.paintBackground("src/resources/backgroundMenu.png");
        swingGUI.addButton("src/resources/play.png", 173, 140, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainMenuControllerGraphic.playButtonPress();
            }
        });
        swingGUI.addButton("src/resources/leaderboard.png", 173, 220, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainMenuControllerGraphic.LeaderBoardButtonPressed();
            }
        });
        swingGUI.addButton("src/resources/rules.png", 173, 300, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainMenuControllerGraphic.GameRulesButtonPressed();
            }
        });
        swingGUI.addButton("src/resources/exit.png", 173, 380, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainMenuControllerGraphic.exitButtonPressed();
            }
        });
        swingGUI.setVisible();
    }
}
