package flapping_bat.controller.menu;

import flapping_bat.AppMVC;
import flapping_bat.model.enums.AppStatus;
import flapping_bat.model.menu.Pause;

import java.io.IOException;

public class PauseController extends MenuController<Pause> {
    public PauseController(Pause pause) {
        super(pause);
    }

    @Override
    public void optionSelected(AppMVC game) throws IOException {
        if (getModel().isSelectedResume()) {
            game.setStatus(AppStatus.CURRENT_GAME);
        }
        if (getModel().isSelectedRestartGame()) game.setStatus(AppStatus.IN_GAME);
        if (getModel().isSelectedMainMenu()) game.setStatus(AppStatus.MAIN_MENU);
    }

    @Override
    public void escapePressed(AppMVC game) throws IOException {
        game.setStatus(AppStatus.CURRENT_GAME);
    }

    @Override
    public void backspacePressed(AppMVC game) throws IOException {

    }
}
