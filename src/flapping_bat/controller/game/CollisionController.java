package flapping_bat.controller.game;

import com.googlecode.lanterna.input.KeyStroke;
import flapping_bat.AppMVC;
import flapping_bat.controller.ControllerText;
import flapping_bat.model.enums.AppStatus;
import flapping_bat.model.Game;
import flapping_bat.model.elements.Wall;

import java.io.IOException;

public class CollisionController extends ControllerText<Game> {
    private final PlayerController playerController;
    public CollisionController(Game game, PlayerController playerController){
        super(game);
        this.playerController = playerController;
    }

    @Override
    public void step(AppMVC app, KeyStroke key) throws IOException {
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
