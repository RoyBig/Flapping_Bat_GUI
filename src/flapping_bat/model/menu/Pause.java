package flapping_bat.model.menu;

import java.util.Arrays;

public class Pause extends Menu{
    public Pause(){
        this.options= Arrays.asList("Resume","Restart Game","Main Menu");
    }
    public boolean isSelectedResume(){
        return isSelected(0);
    }
    public boolean isSelectedRestartGame(){
        return isSelected(1);
    }
    public boolean isSelectedMainMenu(){
        return isSelected(2);
    }
}
