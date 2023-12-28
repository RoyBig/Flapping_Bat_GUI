package flapping_bat.controller.menu;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import flapping_bat.AppMVC;
import flapping_bat.model.enums.AppStatus;
import flapping_bat.model.menu.TextToMenu;

import java.io.IOException;

public class TextToMenuController extends MenuController<TextToMenu> {
    public TextToMenuController(TextToMenu textToMenu) {
        super(textToMenu);
    }
    @Override
    public void optionSelected(AppMVC game) throws IOException {

    }

    @Override
    public void escapePressed(AppMVC game) throws IOException {
        game.setStatus(AppStatus.MAIN_MENU);
    }

    @Override
    public void backspacePressed(AppMVC game) throws IOException {

    }
    @Override
    public void step(AppMVC game, KeyStroke key) throws IOException{
        if (key == null) return;
        if (key.getKeyType() == KeyType.Escape) {
            escapePressed(game);
        }
    }
}
