package flapping_bat.view.gameGraphic;

import flapping_bat.GUI.SwingGUI;
import flapping_bat.model.Position;
import flapping_bat.model.elements.Player;

import java.util.List;

public class PlayerViewGraphic implements ElementViewGraphic<Player> {

    public void draw(Player player, SwingGUI swingGUI) {
        List<Position> positionList = player.getPositions();
        swingGUI.drawImage(positionList.getFirst().getX(), positionList.getFirst().getY()*16,"src/resources/bat.png",32,32);

    }
}
