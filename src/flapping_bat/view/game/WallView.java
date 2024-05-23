package flapping_bat.view.game;

import flapping_bat.GUI.LanternaTextGUI;
import flapping_bat.model.Position;
import flapping_bat.model.elements.Wall;
import flapping_bat.model.enums.Colors;

public class WallView implements ElementView<Wall> {
    public void draw(Wall wall, LanternaTextGUI textGUI) {
        textGUI.drawRectangle(wall.getPosition(), Wall.getWidth(), wall.getHeight(), Colors.DARK_PURPLE.getHex());
        textGUI.drawRectangle(wall.getPosition(), Wall.getWidth()-1, wall.getHeight(), Colors.DARK_PURPLE.getHex());
        textGUI.drawRectangle(wall.getPosition(), Wall.getWidth()-2, wall.getHeight(), Colors.DARK_PURPLE.getHex());
        int newY = wall.getHeight() + wall.getSpace();
        textGUI.drawRectangle(new Position(wall.getPosition().getX(), newY), Wall.getWidth(), textGUI.getHeight() - (wall.getHeight() + wall.getSpace()), Colors.DARK_PURPLE.getHex());
        textGUI.drawRectangle(new Position(wall.getPosition().getX(), newY), Wall.getWidth()-1, textGUI.getHeight() - (wall.getHeight() + wall.getSpace()), Colors.DARK_PURPLE.getHex());
        textGUI.drawRectangle(new Position(wall.getPosition().getX(), newY), Wall.getWidth()-2, textGUI.getHeight() - (wall.getHeight() + wall.getSpace()), Colors.DARK_PURPLE.getHex());
    }
}
