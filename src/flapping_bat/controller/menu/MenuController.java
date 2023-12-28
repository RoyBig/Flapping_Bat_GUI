package flapping_bat.controller.menu;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import flapping_bat.AppMVC;
import flapping_bat.controller.Controller;
import flapping_bat.model.menu.Menu;

import java.io.IOException;
;

public abstract class MenuController<T extends Menu> extends Controller<T> implements IMenu {
    public MenuController(T model) {
        super(model);
    }

    @Override
    public void step(AppMVC game, KeyStroke key) throws IOException{
        if (key == null) return;
        if (key.getKeyType() == KeyType.ArrowUp) {
            getModel().previousOption();
        }
        if (key.getKeyType() == KeyType.ArrowDown) {
            getModel().nextOption();
        }
        if (key.getKeyType() == KeyType.Enter) {
            optionSelected(game);
        }
        if (key.getKeyType() == KeyType.Escape) {
            escapePressed(game);
        }
        if (key.getKeyType() == KeyType.Backspace) {
            backspacePressed(game);
        }
        if (key.getKeyType() == KeyType.Character) {
            if (key.getCharacter() == null) return;
            charSelected(key);
        }
    }
    public void charSelected(KeyStroke key) {

    }
}
