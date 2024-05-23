package flapping_bat.view.menuGraphic;

import flapping_bat.GUI.SwingGUI;
import flapping_bat.controller.menuGraphic.TextToMenuControllerGraphic;
import flapping_bat.model.menu.Leaderboard;
import flapping_bat.view.ViewGraphic;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LeaderboardViewGraphic extends ViewGraphic {
    TextToMenuControllerGraphic leaderboardControllerGraphic;
    public LeaderboardViewGraphic(SwingGUI swingGUI, TextToMenuControllerGraphic leaderboardControllerGraphic, Leaderboard leaderboard){
        this.leaderboardControllerGraphic= leaderboardControllerGraphic;
        swingGUI.clear();
        swingGUI.paintBackground("src/resources/backgroundLeader.png");
        for (int i = 0; i < leaderboard.getSize(); i++) {
            if(i==0) {
                swingGUI.addText(leaderboard.getLine(i), new Font("SansSerif", Font.BOLD, 36), 150, (90 + i * 16), 500, 100, Color.RED);
            }
            else{
                swingGUI.addText(leaderboard.getLine(i), new Font("SansSerif", Font.BOLD, 24), 150, (100 + i * 16*2), 500, 100, Color.ORANGE);
            }
        }
        swingGUI.addButton("src/resources/back.png", 0, 0, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                leaderboardControllerGraphic.backButtonPressed();
            }
        });
        swingGUI.setVisible();
    }
}
