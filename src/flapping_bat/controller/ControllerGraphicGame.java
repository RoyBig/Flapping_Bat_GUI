package flapping_bat.controller;

import com.googlecode.lanterna.input.KeyStroke;
import flapping_bat.AppMVC;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

public abstract class ControllerGraphicGame<T> extends ControllerGraphic{
    private final T model;
    public ControllerGraphicGame(T model) {
        this.model = model;
    }

    public T getModel() {
        return model;
    }

}
