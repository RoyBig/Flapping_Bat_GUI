package flapping_bat.view.gameGraphic;

import flapping_bat.GUI.SwingGUI;
import flapping_bat.model.elements.Ground;
import flapping_bat.view.ViewGraphic;

public class GroundViewGraphic implements ElementViewGraphic<Ground> {

    public void draw(Ground ground, SwingGUI swingGUI) {
        int groundY = ground.getPosition().getY()*16;
        for(int x=0;x< swingGUI.getWidth();x+=16){
            swingGUI.drawImage(x,groundY-40,"src/resources/grass.png",16,16);
        }
    }
}
