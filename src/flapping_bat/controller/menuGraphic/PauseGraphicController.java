package flapping_bat.controller.menuGraphic;

import flapping_bat.AppMVC;
import flapping_bat.GUI.SwingGUI;
import flapping_bat.controller.ControllerGraphic;
import flapping_bat.controller.menu.PauseController;
import flapping_bat.model.enums.AppStatus;

import java.io.IOException;

public class PauseGraphicController extends ControllerGraphic {
    AppMVC appMVC;
    public PauseGraphicController(AppMVC appMVC){
        this.appMVC = appMVC;
    }
    public void resumeButtonPressed(){
        try {
            appMVC.setStatus(AppStatus.CURRENT_GAME);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void restartButtonPressed(){
        try {
            appMVC.setStatus(AppStatus.IN_GAME);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void backToMenuButtonPressed(){
        try {
            appMVC.setStatus(AppStatus.MAIN_MENU);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
