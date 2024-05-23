package flapping_bat.controller.game;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import flapping_bat.AppMVC;
import flapping_bat.controller.ControllerText;
import flapping_bat.model.Game;
import flapping_bat.model.enums.AppStatus;

import java.io.IOException;

public class GameController extends ControllerText<Game> {
    private final PlayerController playerController;
    private final WallController wallController;
    private final WallCreatorContoller wallCreatorContoller;
    private final CollisionController collisionController;

    public GameController(Game game) {
        super(game);
        this.playerController = new PlayerController(game);
        this.wallController = new WallController(game);
        this.wallCreatorContoller = new WallCreatorContoller(game);
        this.collisionController = new CollisionController(game, this.playerController);
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

    @Override
    public void step(AppMVC app, KeyStroke key) throws IOException {
        if (key != null) {
            if (key.getKeyType() == KeyType.Escape) {
                getModel().setPlaying(false);
                app.setStatus(AppStatus.PAUSE_GAME);
            }
        }
        playerController.step(app, key);
        wallCreatorContoller.step();
        wallController.step(app, key);
        collisionController.step(app, key);
        updateScore();
    }
}
