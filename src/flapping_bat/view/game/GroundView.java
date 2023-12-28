package flapping_bat.view.game;

import flapping_bat.textGUI.LanternaTextGUI;
import flapping_bat.model.Position;
import flapping_bat.model.elements.Ground;
import flapping_bat.model.enums.Colors;

public class GroundView implements ElementView<Ground>{
    public void draw(Ground ground, LanternaTextGUI lanternaTextGUI){
        int groundY = ground.getPosition().getY();
        for(int x = 0; x < lanternaTextGUI.getWidth(); x++){
            lanternaTextGUI.paintPixel(new Position(x,groundY), Colors.PURPLE.getHex());
        }
    }
}
