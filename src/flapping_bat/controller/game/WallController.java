package flapping_bat.controller.game;

import com.googlecode.lanterna.input.KeyStroke;
import flapping_bat.AppMVC;
import flapping_bat.controller.ControllerText;
import flapping_bat.model.Game;
import flapping_bat.model.elements.Wall;

import java.util.Iterator;

public class WallController extends ControllerText<Game> {
    public WallController(Game game)
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
    @Override
    public void step(AppMVC app, KeyStroke key) {
        if(!getModel().isPlaying()) return;
        moveWalls();
    }

}
