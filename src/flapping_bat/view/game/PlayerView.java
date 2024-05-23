package flapping_bat.view.game;

import flapping_bat.GUI.LanternaTextGUI;
import flapping_bat.model.Position;
import flapping_bat.model.elements.Player;
import flapping_bat.model.enums.Colors;

import java.util.List;

public class PlayerView implements ElementView<Player> {
    public void draw(Player player, LanternaTextGUI textGUI) {
        char playerChar = 118;
        char playerChar2 = 94;
        char playerChar3 = 47;
        char playerChar4 = 92;
        List<Position> positionList = player.getPositions();
        for (int i=0; i< player.getPositions().size(); i++) {
            if(i == 0) {
                textGUI.drawPixel(positionList.get(i), playerChar, Colors.BLACK.getHex(), Colors.STATE_BLUE.getHex());
            }
            if(i==1 || i == 3){
                textGUI.drawPixel(positionList.get(i), playerChar2, Colors.BLACK.getHex(), Colors.STATE_BLUE.getHex());
            }
            if(i==2){
                textGUI.drawPixel(positionList.get(i), playerChar4, Colors.BLACK.getHex(), Colors.STATE_BLUE.getHex());
            }
            if(i==4){
                textGUI.drawPixel(positionList.get(i), playerChar3, Colors.BLACK.getHex(), Colors.STATE_BLUE.getHex());
            }
        }

    }
}
