package flapping_bat.controller.menu;

import flapping_bat.AppMVC;

import java.io.IOException;

public interface IMenu {
    void optionSelected(AppMVC game) throws IOException;

    void escapePressed(AppMVC game) throws IOException;

    void backspacePressed(AppMVC game) throws IOException;
}
