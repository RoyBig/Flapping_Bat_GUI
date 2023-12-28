package flapping_bat.view.menu;

import flapping_bat.model.Position;
import flapping_bat.model.enums.Colors;
import flapping_bat.model.menu.Pause;
import flapping_bat.textGUI.LanternaTextGUI;

public class PauseView extends MenuView<Pause>{
    public PauseView(Pause pause){
        super(pause, new Position(8,13));
    }
    @Override
    protected void drawInsideElements(LanternaTextGUI lanternaTextGUI) {
        drawTitle(lanternaTextGUI, "Pause", Colors.ORANGE.getHex());
    }
}
