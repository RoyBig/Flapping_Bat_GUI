package flapping_bat.controller.gameGraphic;

import com.googlecode.lanterna.input.KeyStroke;
import flapping_bat.AppMVC;
import flapping_bat.controller.ControllerGraphicGame;
import flapping_bat.model.Game;
import flapping_bat.model.elements.Wall;

import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Iterator;

public class WallControllerGraphic extends ControllerGraphicGame<Game> {
    public WallControllerGraphic(Game game)
    {
        super(game);
    }

    private void moveWalls(){
        Iterator<Wall> wallIterator = getModel().getWallList().iterator();
        while(wallIterator.hasNext()){
            Wall wall = wallIterator.next();
            wall.move();
            if(wall.isOutOfScreen()){
                wallIterator.remove();
            }
        }
    }

    public void step(AppMVC game, KeyEvent keyEvent) throws IOException {
        if(!getModel().isPlaying()) return;
        moveWalls();
    }
}
