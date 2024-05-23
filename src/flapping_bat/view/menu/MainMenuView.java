package flapping_bat.view.menu;

import flapping_bat.GUI.LanternaTextGUI;
import flapping_bat.model.Position;
import flapping_bat.model.enums.Colors;
import flapping_bat.model.menu.MainMenu;

public class MainMenuView extends MenuView<MainMenu> {
    public MainMenuView(MainMenu mainMenu) {
        super(mainMenu, new Position(8, 13));
    }

    @Override
    protected void drawInsideElements(LanternaTextGUI textGUI) {
        drawTitle(textGUI, "Main Menu", Colors.ORANGE.getHex());
    }
}
