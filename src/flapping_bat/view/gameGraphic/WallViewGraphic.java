package flapping_bat.view.gameGraphic;

import flapping_bat.GUI.LanternaTextGUI;
import flapping_bat.GUI.SwingGUI;
import flapping_bat.model.Position;
import flapping_bat.model.elements.Wall;
import flapping_bat.model.enums.Colors;
import flapping_bat.view.ViewGraphic;
import flapping_bat.view.game.ElementView;

public class WallViewGraphic implements ElementViewGraphic<Wall> {

    public void draw(Wall wall, SwingGUI swingGUI) {
        for (int i = 0; i < wall.getHeight(); i++) {
            swingGUI.drawImage(wall.getPosition().getX() * 16 - 160, wall.getPosition().getY() + 16 * i, "src/resources/wall.png", 64, 16);
        }
        int newY = wall.getHeight()+wall.getSpace();
        for(int i = 0;i<(swingGUI.getHeight()/16 + 16);i++){

            if(i> newY)
                swingGUI.drawImage(wall.getPosition().getX()*16-160,newY+16*i,"src/resources/wall.png",64,16);
        }
    }
}

