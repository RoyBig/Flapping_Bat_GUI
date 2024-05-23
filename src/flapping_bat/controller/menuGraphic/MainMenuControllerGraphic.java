package flapping_bat.controller.menuGraphic;

import flapping_bat.AppMVC;
import flapping_bat.controller.ControllerGraphic;
import flapping_bat.controller.menu.MainMenuController;
import flapping_bat.model.enums.AppStatus;

import java.io.IOException;

public class MainMenuControllerGraphic extends ControllerGraphic {
    AppMVC appMVC;
    public MainMenuControllerGraphic(AppMVC appMVC){
        this.appMVC = appMVC;
    }

    public void playButtonPress(){
        try {
            appMVC.setStatus(AppStatus.IN_GAME);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void exitButtonPressed(){
        appMVC.exit();
    }
    public void LeaderBoardButtonPressed(){
        try {
            appMVC.setStatus(AppStatus.LEADERBOARD_VIEW);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void GameRulesButtonPressed(){
        try {
            appMVC.setStatus(AppStatus.GAME_RULES_VIEW);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



}
