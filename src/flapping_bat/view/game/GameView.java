package flapping_bat.view.game;

import flapping_bat.textGUI.LanternaTextGUI;
import flapping_bat.model.Game;
import flapping_bat.model.Position;
import flapping_bat.model.elements.Element;
import flapping_bat.model.enums.Colors;
import flapping_bat.view.View;

import java.util.List;

public class GameView extends View<Game> {
    public GameView(Game game){
        super(game);
    }
    @Override
    protected void drawElements(LanternaTextGUI textGUI) {
        drawSky(textGUI);
        drawElement(textGUI, getModel().getPlayer(), new PlayerView());
        drawElements(textGUI, getModel().getWallList(), new WallView());
        drawElement(textGUI, getModel().getGround(), new GroundView());
        drawScore(textGUI);
    }

    private <T extends Element> void drawElements(LanternaTextGUI textGUI, List<T> elements, ElementView<T> view) {
        for (T element : elements)
            drawElement(textGUI, element, view);
    }

    private <T extends Element> void drawElement(LanternaTextGUI textGUI, T element, ElementView<T> view) {
        view.draw(element, textGUI);
    }

    private void drawScore(LanternaTextGUI textGUI) {
        String scoreText = "SCORE: " + getModel().getScore();
        textGUI.drawRectangle(new Position(0, 0), scoreText.length() + 2, 3, Colors.INDYGO.getHex());
        textGUI.drawText(new Position(1, 1), scoreText, Colors.WHITE.getHex(),Colors.INDYGO.getHex());
    }


    private void drawSky(LanternaTextGUI cli) {
        cli.paintBackground(Colors.STATE_BLUE.getHex());
    }
}
