package flapping_bat.controller.menuGraphic;

import flapping_bat.AppMVC;
import flapping_bat.controller.ControllerGraphic;
import flapping_bat.model.enums.AppStatus;

import java.io.IOException;

public class TextToMenuControllerGraphic extends ControllerGraphic {
    AppMVC appMVC;
    public TextToMenuControllerGraphic(AppMVC appMVC){
        this.appMVC = appMVC;
    }

    public void backButtonPressed(){
        try {
            appMVC.setStatus(AppStatus.MAIN_MENU);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
