package flapping_bat.controller.gameGraphic;

import com.googlecode.lanterna.input.KeyStroke;
import flapping_bat.AppMVC;
import flapping_bat.controller.ControllerGraphicGame;
import flapping_bat.controller.game.PlayerController;
import flapping_bat.model.Game;
import flapping_bat.model.elements.Wall;
import flapping_bat.model.enums.AppStatus;

import java.awt.event.KeyEvent;
import java.io.IOException;

public class CollisionControllerGraphic extends ControllerGraphicGame<Game> {
    private final PlayerControllerGraphic playerController;
    public CollisionControllerGraphic(Game game, PlayerControllerGraphic playerController){
        super(game);
        this.playerController = playerController;
    }


    public void step(AppMVC app, KeyEvent keyEvent) throws IOException {
        if (playerController.isCollidingWith(getModel().getGround())){
            app.setStatus(AppStatus.GAME_OVER);
            return;
        }
        for (Wall wall : getModel().getWallList()) {

            if (playerController.isCollidingWith(wall)) {
                app.setStatus(AppStatus.GAME_OVER);
                return;
            }
        }
    }
}
