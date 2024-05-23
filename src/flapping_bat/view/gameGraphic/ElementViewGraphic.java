package flapping_bat.view.gameGraphic;

import flapping_bat.GUI.LanternaTextGUI;
import flapping_bat.GUI.SwingGUI;
import flapping_bat.model.elements.Element;

public interface ElementViewGraphic<T extends Element> {
    void draw(T element, SwingGUI swingGUI);

}
