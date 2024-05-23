package flapping_bat.model.menu;

import flapping_bat.GUI.LanternaTextGUI;

import java.util.Arrays;

public class GameOver extends Menu{
    private static final int MAX_LENGTH = LanternaTextGUI.width/2;
    private String username;
    private final Integer score;

    public GameOver(int score) {
        this.username = "";
        this.score = score;
        this.options = Arrays.asList("Play Again", "Main Menu");
    }

    public String getUsername() {
        return username;
    }

    public void addChar(Character character) {
        if (username.length() < MAX_LENGTH) {
            username += character;
        }
    }

    public void removeChar() {
        if (username.length() > 0) {
            username = username.substring(0, username.length() - 1);
        }
    }

    public Integer getScore() {
        return score;
    }

    public boolean isSelectedPlayAgain() {
        return isSelected(0);
    }

    public boolean isSelectedMainMenu() {
        return isSelected(1);
    }
}
