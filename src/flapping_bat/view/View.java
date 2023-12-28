package flapping_bat.view;

import flapping_bat.textGUI.LanternaTextGUI;

import java.io.IOException;

public abstract class View<T> {
    private final T model;
    public View(T model) {
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

    protected abstract void drawElements(LanternaTextGUI gui);
}
