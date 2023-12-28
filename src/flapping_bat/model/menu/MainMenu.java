package flapping_bat.model.menu;

import java.util.Arrays;

public class MainMenu extends Menu{
    public MainMenu(){
        this.options = Arrays.asList("Play","Leaderboard","Game Rules","Exit");
    }
    public boolean isSelectedPlay(){
        return isSelected(0);
    }
    public boolean isSelectedLeaderboard(){
        return isSelected(1);
    }
    public boolean isSelectedGameRules(){
        return isSelected(2);
    }
    public boolean isSelectedExit(){
        return isSelected(3);
    }
}
