package flapping_bat.view;

import flapping_bat.GUI.SwingGUI;

import java.io.IOException;

public abstract class ViewGraphicGame<T>  extends ViewGraphic {
    private final T model;
    public ViewGraphicGame(T model) {
        this.model = model;
    }
    public T getModel() {
        return model;
    }

    @Override
    public void draw(SwingGUI swingGUI) throws IOException {
        swingGUI.clear();
        drawElements(swingGUI);
        swingGUI.setVisible();
    }

    protected abstract void drawElements(SwingGUI swingGUI);
}
