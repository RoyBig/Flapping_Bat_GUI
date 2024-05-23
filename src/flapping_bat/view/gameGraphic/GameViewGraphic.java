package flapping_bat.view.gameGraphic;

import flapping_bat.GUI.LanternaTextGUI;
import flapping_bat.GUI.SwingGUI;
import flapping_bat.model.Game;
import flapping_bat.model.Position;
import flapping_bat.model.elements.Element;
import flapping_bat.model.elements.Ground;
import flapping_bat.model.enums.Colors;
import flapping_bat.view.ViewGraphic;
import flapping_bat.view.ViewGraphicGame;
import flapping_bat.view.game.ElementView;
import flapping_bat.view.game.GroundView;
import flapping_bat.view.game.PlayerView;
import flapping_bat.view.game.WallView;

import java.awt.*;
import java.util.List;

public class GameViewGraphic extends ViewGraphicGame<Game> {
    public GameViewGraphic(Game game){
        super(game);
    }

    @Override
    protected void drawElements(SwingGUI swingGUI) {
        drawSky(swingGUI);
        drawElement(swingGUI, getModel().getPlayer(), new PlayerViewGraphic());
        drawElements(swingGUI, getModel().getWallList(), new WallViewGraphic());
        drawElement(swingGUI, getModel().getGround(), new GroundViewGraphic());
        drawScore(swingGUI);
    }

    private <T extends Element> void drawElements(SwingGUI swingGUI, List<T> elements, ElementViewGraphic<T> view) {
        for (T element : elements)
            drawElement(swingGUI, element, view);
    }

    private <T extends Element> void drawElement(SwingGUI swingGUI, T element, ElementViewGraphic<T> view) {
        view.draw(element, swingGUI);

    }

    private void drawScore(SwingGUI swingGUI) {
        String scoreText = "SCORE: " + getModel().getScore();
        swingGUI.addText(scoreText, new Font("SansSerif", Font.BOLD, 16),16,0,200,40,Color.ORANGE);
    }


    private void drawSky(SwingGUI swingGUI) {
        swingGUI.paintBackground("src/resources/backgroundGame.png");
    }
}

