package flapping_bat.view.menu;

import flapping_bat.model.Position;
import flapping_bat.model.enums.Colors;
import flapping_bat.model.menu.Menu;
import flapping_bat.textGUI.LanternaTextGUI;
import flapping_bat.view.View;

public abstract class MenuView<T extends Menu> extends View<T> {
    private final Integer options_x;
    private final Integer options_y;

    public MenuView(T model, Position optionsPosition) {
        super(model);
        this.options_x = optionsPosition.getX();
        this.options_y = optionsPosition.getY();
    }

    protected void drawElements(LanternaTextGUI lanternaTextGUI) {
        lanternaTextGUI.paintBackground(Colors.DARK.getHex());

        drawOptions(lanternaTextGUI);

        drawInsideElements(lanternaTextGUI);
    }

    public void drawOptions(LanternaTextGUI textGUI) {
        for (int i = 0; i < getModel().getNumberOfOptions(); i++) {
            if (getModel().isSelected(i)) {
                drawText(textGUI, new Position(options_x, options_y + i), "->" + getModel().getOption(i), Colors.ORANGE.getHex());
            } else {
                drawText(textGUI, new Position(options_x + 1, options_y + i), getModel().getOption(i), Colors.WHITE.getHex());
            }
        }
    }

    public void drawTitle(LanternaTextGUI textGUI, String title, String color) {
        drawText(textGUI, new Position(options_x, options_y - 2), title, color);
    }

    public void drawText(LanternaTextGUI textGUI, Position position, String text, String color) {
        textGUI.drawText(position, text, color, Colors.DARK.getHex());
    }

    abstract protected void drawInsideElements(LanternaTextGUI lanternaTextGUI);
}
