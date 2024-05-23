package flapping_bat;

import com.googlecode.lanterna.input.KeyStroke;
import flapping_bat.GUI.SwingGUI;
import flapping_bat.controller.ControllerGraphic;
import flapping_bat.controller.gameGraphic.GameGraphicController;
import flapping_bat.controller.menu.GameOverController;
import flapping_bat.controller.menu.MainMenuController;
import flapping_bat.controller.menu.PauseController;
import flapping_bat.controller.menu.TextToMenuController;
import flapping_bat.controller.menuGraphic.GameOverControllerGraphic;
import flapping_bat.controller.menuGraphic.PauseGraphicController;
import flapping_bat.controller.menuGraphic.TextToMenuControllerGraphic;
import flapping_bat.controller.menuGraphic.MainMenuControllerGraphic;

import flapping_bat.model.menu.*;
import flapping_bat.GUI.LanternaTextGUI;
import flapping_bat.controller.ControllerText;
import flapping_bat.controller.game.GameController;
import flapping_bat.model.enums.AppStatus;
import flapping_bat.model.Game;
import flapping_bat.view.ViewGraphic;
import flapping_bat.view.ViewText;
import flapping_bat.view.game.GameView;
import flapping_bat.view.gameGraphic.GameViewGraphic;
import flapping_bat.view.menu.*;
import flapping_bat.view.menuGraphic.*;

import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;


public class AppMVC {
        private LanternaTextGUI textGUI;
        private SwingGUI graphicGUI;
        private ControllerText controllerText;
        private ControllerGraphic controllerGraphic;
        private AppStatus status;
        private ViewText viewText;
        private ViewGraphic viewGraphic;
        private MainMenu mainMenu;
        private Pause pause;
        private Game game = new Game();
        private Game prevGame;
        private boolean useTextInterface;
        KeyEvent keyEvent;
        Timer timer = null;


    public AppMVC(boolean useTextInterface) throws IOException {
        this.status = AppStatus.MAIN_MENU;
        this.mainMenu = new MainMenu();
        this.useTextInterface = useTextInterface;
        if (useTextInterface) {
            this.textGUI = new LanternaTextGUI();
            this.controllerText = new MainMenuController(mainMenu);
            this.viewText = new MainMenuView(mainMenu);
        } else {
            this.graphicGUI = new SwingGUI();
            this.controllerGraphic = new MainMenuControllerGraphic(this);
            this.viewGraphic = new MainMenuViewGraphic(graphicGUI, (MainMenuControllerGraphic) controllerGraphic);
        }
    }


        public static void main(String[] args) throws IOException {
            try {
                if (args.length > 0 && args[0].equalsIgnoreCase("text")) {
                    new AppMVC(true).startText();
                } else {
                    new AppMVC(false);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        private void startText() throws Exception {
            int FPS = 14;
            int frameTime = 1000 / FPS;
            while (this.status != null) {
                long startTime = System.currentTimeMillis();

                KeyStroke next_key = textGUI.getNextAction();

                controllerText.step(this, next_key);
                viewText.draw(textGUI);


                long elapsedTime = System.currentTimeMillis() - startTime;
                long sleepTime = frameTime - elapsedTime;

                try {
                    if (sleepTime > 0) Thread.sleep(sleepTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            textGUI.close();
        }

    private void startGraphic() throws Exception {
        graphicGUI.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ESCAPE){
                    try {
                        setStatus(AppStatus.PAUSE_GAME);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ESCAPE){
                    try {
                        setStatus(AppStatus.PAUSE_GAME);
                        timer.stop();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }

                controllerGraphic.setButtonState(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {

                controllerGraphic.setButtonState(null);
            }
        });
        AppMVC appMVC = this;

            timer = new Timer(71, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        controllerGraphic.step(appMVC, keyEvent);
                        viewGraphic.draw(graphicGUI);
                        if (status != AppStatus.IN_GAME && status != AppStatus.CURRENT_GAME) {
                            timer.stop();
                        }



                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            });
            timer.start();

        }

        public void exit() {
            this.status = null;
            if(!useTextInterface) graphicGUI.close();
        }

        public void setStatus(AppStatus status) throws IOException {
            if (status == AppStatus.PAUSE_GAME) {
                this.prevGame = this.game;
            }
            this.status = status;
            switch (status) {
                case MAIN_MENU:
                    this.mainMenu = new MainMenu();
                    if(useTextInterface) {
                        this.viewText = new MainMenuView(mainMenu);
                        this.controllerText = new MainMenuController(mainMenu);
                    }
                    else{
                        this.controllerGraphic = new MainMenuControllerGraphic(this);
                        this.viewGraphic = new MainMenuViewGraphic(graphicGUI, (MainMenuControllerGraphic) controllerGraphic);
                    }
                    break;
                case IN_GAME:
                    this.game = new Game();
                    if(useTextInterface) {
                        this.controllerText = new GameController(game);
                        this.viewText = new GameView(game);
                    }
                    else{
                        this.controllerGraphic = new GameGraphicController(game);
                        this.viewGraphic = new GameViewGraphic(game);
                        try {
                            this.startGraphic();
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;
                case CURRENT_GAME:
                    this.game = this.prevGame;
                    if(useTextInterface) {
                        this.controllerText = new GameController(game);
                        this.viewText = new GameView(game);
                    }
                    else{
                        this.controllerGraphic = new GameGraphicController(game);
                        this.viewGraphic = new GameViewGraphic(game);
                        try {
                            this.startGraphic();
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;
                case LEADERBOARD_VIEW:
                    Leaderboard leaderboard = new Leaderboard();
                    if(useTextInterface) {
                        this.controllerText = new TextToMenuController(leaderboard);
                        this.viewText = new LeaderboardView(leaderboard);
                    }
                    else {
                        this.controllerGraphic = new TextToMenuControllerGraphic(this);
                            this.viewGraphic = new LeaderboardViewGraphic(graphicGUI,(TextToMenuControllerGraphic) controllerGraphic,leaderboard);
                    }
                    break;
                case GAME_RULES_VIEW:
                    GameRules gameRules = new GameRules();
                    if(useTextInterface){
                        this.controllerText = new TextToMenuController(gameRules);
                        this.viewText = new GameRulesView(gameRules);
                    }
                    else {
                        this.controllerGraphic = new TextToMenuControllerGraphic(this);
                        this.viewGraphic = new GameRulesViewGraphic(graphicGUI, (TextToMenuControllerGraphic) controllerGraphic, gameRules);
                    }
                    break;
                case PAUSE_GAME:
                    this.pause = new Pause();
                    if(useTextInterface) {
                        this.controllerText = new PauseController(pause);
                        this.viewText = new PauseView(pause);
                    }
                    else{
                        this.controllerGraphic = new PauseGraphicController(this);
                        this.viewGraphic = new PauseViewGraphic(graphicGUI,(PauseGraphicController) controllerGraphic);
                    }
                    break;
                case GAME_OVER:
                    GameOver gameOver = new GameOver(this.game.getScore());
                    if(useTextInterface) {
                        this.controllerText = new GameOverController(gameOver);
                        this.viewText = new GameOverView(gameOver);
                    }
                    else{
                        this.controllerGraphic = new GameOverControllerGraphic(this);
                        this.viewGraphic = new GameOverViewGraphic(graphicGUI,(GameOverControllerGraphic) controllerGraphic,gameOver);
                    }
                    break;
            }
    }
}

