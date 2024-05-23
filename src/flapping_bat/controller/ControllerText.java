package flapping_bat.controller;


import com.googlecode.lanterna.input.KeyStroke;
import flapping_bat.AppMVC;

import java.io.IOException;

public abstract class ControllerText<T> {
    private final T model;

    public ControllerText(T model) {
        this.model = model;
    }

    public T getModel() {
        return model;
    }
    public abstract void step(AppMVC game, KeyStroke key) throws IOException;

}
