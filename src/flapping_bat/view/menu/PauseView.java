package flapping_bat.view.menu;

import flapping_bat.GUI.LanternaTextGUI;
import flapping_bat.model.Position;
import flapping_bat.model.enums.Colors;
import flapping_bat.model.menu.Pause;

public class PauseView extends MenuView<Pause>{
    public PauseView(Pause pause){
        super(pause, new Position(8,13));
    }
    @Override
    protected void drawInsideElements(LanternaTextGUI textGUI) {
        drawTitle(textGUI, "Pause", Colors.ORANGE.getHex());
    }
}
