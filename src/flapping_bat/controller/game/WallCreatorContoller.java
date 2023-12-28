package flapping_bat.controller.game;

import flapping_bat.model.Game;
import flapping_bat.model.elements.WallCreator;

public class WallCreatorContoller {
    private final Game game;
    private final WallCreator wallCreator;
    public WallCreatorContoller(Game game){
        this.game = game;
        this.wallCreator = new WallCreator();
    }
    public void generateWall(){
        game.addWall(wallCreator.create());
    }
    public void step() {
        if (game.isPlaying()) {
            if (game.getSteps() == 0) generateWall();
            game.incrementSteps();
        }
}
}
