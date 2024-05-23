package flapping_bat.view.game;

import flapping_bat.GUI.LanternaTextGUI;
import flapping_bat.model.elements.Element;

public interface ElementView<T extends Element> {
    void draw(T element, LanternaTextGUI textGUI);
}
