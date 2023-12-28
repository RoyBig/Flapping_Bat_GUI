package flapping_bat.controller.menu;

import flapping_bat.AppMVC;
import flapping_bat.model.enums.AppStatus;
import flapping_bat.model.menu.MainMenu;

import java.io.IOException;

public class MainMenuController extends MenuController<MainMenu> {
    public MainMenuController(MainMenu mainMenu) {
        super(mainMenu);
    }

    @Override
    public void optionSelected(AppMVC game) throws IOException {
        if (getModel().isSelectedPlay()) {
            game.setStatus(AppStatus.IN_GAME);
            return;
        }
        if (getModel().isSelectedExit()) game.exit();
        if (getModel().isSelectedLeaderboard()) game.setStatus(AppStatus.LEADERBOARD_VIEW);
        if (getModel().isSelectedGameRules()) game.setStatus(AppStatus.GAME_RULES_VIEW);
    }

    @Override
    public void escapePressed(AppMVC game) throws IOException {

    }

    @Override
    public void backspacePressed(AppMVC game) throws IOException {

    }
}
