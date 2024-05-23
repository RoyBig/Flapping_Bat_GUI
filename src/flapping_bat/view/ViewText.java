package flapping_bat.view;

import flapping_bat.GUI.LanternaTextGUI;

import java.io.IOException;

public abstract class ViewText<T> {
    private final T model;
    public ViewText(T model) {
        this.model = model;
    }
    public T getModel() {
        return model;
    }

    public void draw(LanternaTextGUI textGUI) throws IOException {
        textGUI.clear();
        drawElements(textGUI);
        textGUI.refresh();
    }

    protected abstract void drawElements(LanternaTextGUI textGUI);
}
