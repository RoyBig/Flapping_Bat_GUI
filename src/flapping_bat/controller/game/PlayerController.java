package flapping_bat.controller.game;

import flapping_bat.AppMVC;
import flapping_bat.textGUI.LanternaTextGUI;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import flapping_bat.controller.Controller;
import flapping_bat.model.Game;
import flapping_bat.model.Position;
import flapping_bat.model.elements.Collidable;
import flapping_bat.model.elements.Player;

public class PlayerController extends Controller<Game> {
    private final Player player;
    private int waitingCounter = 0;

    public PlayerController(Game game){
        super(game);
        this.player = game.getPlayer();
    }
    public void jumpPlayer(){
        if(!getModel().isPlaying())
            getModel().startPlaying();
        if(player.getPosition().getY()<0) return;
        player.setVelocity(-3);
    }
    public void updatePosition(){
        Position position = player.getPosition();
        if (!getModel().isPlaying()) {
            if (waitingCounter == 0) {
                player.setVelocity(-player.getVelocity());
                position.setY(position.getY() + player.getVelocity());
            }
            waitingCounter = (waitingCounter + 1) % 11;
            return;
        }
        position.setY(position.getY() + player.getVelocity());
        player.setVelocity(player.getVelocity() + player.getGravity());

        if (position.getY() > LanternaTextGUI.height - 1) {
            position.setY(LanternaTextGUI.height - 1);
            player.setVelocity(0);
        }
    }
    public boolean isCollidingWith(Collidable collidable) {
        for (Position playerPosition : player.getPositions()) {
            for (Position elementPosition : collidable.getPositions()) {
                if (elementPosition.equals(playerPosition)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public void step(AppMVC app, KeyStroke key) {
        updatePosition();
        if (key == null) return;
        if (key.getKeyType() == KeyType.Character && key.getCharacter() == ' ') {
            jumpPlayer();
        }
    }
}
