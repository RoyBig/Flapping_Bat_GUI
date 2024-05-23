package flapping_bat.view.menuGraphic;

import flapping_bat.GUI.SwingGUI;
import flapping_bat.controller.menuGraphic.PauseGraphicController;
import flapping_bat.view.ViewGraphic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PauseViewGraphic extends ViewGraphic {
    PauseGraphicController pauseGraphicController;
    public PauseViewGraphic(SwingGUI swingGUI, PauseGraphicController pauseGraphicController){
        swingGUI.clear();
        this.pauseGraphicController = pauseGraphicController;
        swingGUI.paintBackground("src/resources/backgroundPause.png");
        swingGUI.addButton("src/resources/resume.png", 173, 150, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pauseGraphicController.resumeButtonPressed();
            }
        });
        swingGUI.addButton("src/resources/playAgain.png", 173, 250, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pauseGraphicController.restartButtonPressed();
            }
        });
        swingGUI.addButton("src/resources/menu.png", 173, 350, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pauseGraphicController.backToMenuButtonPressed();
            }
        });
        swingGUI.setVisible();
    }
}
