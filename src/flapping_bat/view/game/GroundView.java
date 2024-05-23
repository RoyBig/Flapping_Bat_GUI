package flapping_bat.view.game;

import flapping_bat.GUI.LanternaTextGUI;
import flapping_bat.model.Position;
import flapping_bat.model.elements.Ground;
import flapping_bat.model.enums.Colors;

public class GroundView implements ElementView<Ground>{
    public void draw(Ground ground, LanternaTextGUI textGUI){
        int groundY = ground.getPosition().getY();
        for(int x = 0; x < textGUI.getWidth(); x++){
            textGUI.paintPixel(new Position(x,groundY), Colors.PURPLE.getHex());
        }
    }
}
