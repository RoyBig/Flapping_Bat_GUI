package flapping_bat.model.menu;

import java.awt.font.GraphicAttribute;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class GameRules extends TextToMenu {
    public GameRules() throws FileNotFoundException {
        super("src/resources/gameRules.txt");
    }
}
