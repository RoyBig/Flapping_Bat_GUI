package flapping_bat.view.menu;

import flapping_bat.GUI.LanternaTextGUI;
import flapping_bat.model.Position;
import flapping_bat.model.enums.Colors;
import flapping_bat.model.menu.GameOver;

public class GameOverView extends MenuView<GameOver> {
    public GameOverView(GameOver gameover){
        super(gameover,new Position(5,21));
    }

    protected void drawInsideElements(LanternaTextGUI textGUI) {
        drawText(textGUI, new Position(6, 13), "G A M E   O V E R", Colors.ORANGE.getHex());
        drawText(textGUI, new Position(6, 15), "Score: " + getModel().getScore(), Colors.WHITE.getHex());
        drawText(textGUI, new Position(6, 17), "Enter your name:", Colors.WHITE.getHex());
        drawText(textGUI, new Position(6, 19), getModel().getUsername(), Colors.ORANGE.getHex());
    }

}
