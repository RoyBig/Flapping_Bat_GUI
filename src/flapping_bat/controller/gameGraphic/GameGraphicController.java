package flapping_bat.controller.gameGraphic;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import flapping_bat.AppMVC;
import flapping_bat.controller.ControllerGraphicGame;
import flapping_bat.controller.game.CollisionController;
import flapping_bat.controller.game.PlayerController;
import flapping_bat.controller.game.WallController;
import flapping_bat.controller.game.WallCreatorContoller;
import flapping_bat.model.Game;
import flapping_bat.model.enums.AppStatus;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

public class GameGraphicController extends ControllerGraphicGame<Game> {
    private final PlayerControllerGraphic playerController;
    private final WallControllerGraphic wallController;
    private final WallCreatorContoller wallCreatorContoller;
    private final CollisionControllerGraphic collisionController;
    private KeyEvent buttonState;
    public GameGraphicController(Game game) {
        super(game);
        this.playerController = new PlayerControllerGraphic(game);
        this.wallController = new WallControllerGraphic(game);
        this.wallCreatorContoller = new WallCreatorContoller(game);
        this.collisionController = new CollisionControllerGraphic(game, this.playerController);
    }

    private void updateScore() {
        int playerX = getModel().getPlayer().getPosition().getX();
        var walls = getModel().getWallList();

        for (var wall : walls) {
            int wallX = wall.getPosition().getX() + 1;

            if (playerX == wallX + 1) {
                getModel().incrementScore(1);
                break;
            }
        }
    }

    public void step(AppMVC app, KeyEvent keyEvent) throws IOException {
        KeyEvent buttonStep = buttonState;
        if (keyEvent != null) {
            if (keyEvent.getKeyCode() == KeyEvent.VK_ESCAPE) {
                getModel().setPlaying(false);
                app.setStatus(AppStatus.PAUSE_GAME);
            }
        }
        playerController.step(app, buttonState);
        wallCreatorContoller.step();
        wallController.step(app, buttonState);
        collisionController.step(app, buttonState);
        updateScore();
    }
    public void setButtonState(KeyEvent keyEvent){
        this.buttonState = keyEvent;
    }
}

