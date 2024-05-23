package flapping_bat.view.menuGraphic;

import flapping_bat.GUI.SwingGUI;
import flapping_bat.controller.menuGraphic.GameOverControllerGraphic;
import flapping_bat.model.menu.GameOver;
import flapping_bat.view.ViewGraphic;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class GameOverViewGraphic extends ViewGraphic {
    GameOverControllerGraphic gameOverControllerGraphic;
    String enteredText = null;
    public GameOverViewGraphic(SwingGUI swingGUI, GameOverControllerGraphic gameOverControllerGraphic, GameOver gameOver){
        this.gameOverControllerGraphic = gameOverControllerGraphic;
        swingGUI.clear();
        swingGUI.paintBackground("src/resources/backgroundGameOver.png");
        swingGUI.addButton("src/resources/playAgain.png", 173, 140, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if(!"Podaj swój nickname".equals(enteredText)){
                        gameOverControllerGraphic.updateLeaderboard(gameOver.getScore(), enteredText);
                    }
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                gameOverControllerGraphic.playAgainButtonPressed();
            }
        });
        swingGUI.addButton("src/resources/menu.png", 173, 380, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if(!"Podaj swój nickname".equals(enteredText)){
                        gameOverControllerGraphic.updateLeaderboard(gameOver.getScore(), enteredText);
                    }
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                gameOverControllerGraphic.backToMenuButtonPressed();
            }
        });
        swingGUI.addText("YOUR SCORE = " + gameOver.getScore(), new Font("SansSerif", Font.BOLD, 24), 150, 180, 500, 100, Color.ORANGE);
        swingGUI.addTextLabel(123, 280, "Podaj swój nickname",new Font("SansSerif", Font.BOLD, 24), new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e){
                try {
                    enteredText = e.getDocument().getText(0, e.getDocument().getLength());
                } catch (BadLocationException ex) {
                    throw new RuntimeException(ex);
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {

            }

            @Override
            public void changedUpdate(DocumentEvent e) {

            }
        });
        swingGUI.setVisible();

    }
}
