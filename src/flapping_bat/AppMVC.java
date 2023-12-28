package flapping_bat;

import com.googlecode.lanterna.input.KeyStroke;
import flapping_bat.controller.menu.GameOverController;
import flapping_bat.controller.menu.MainMenuController;
import flapping_bat.controller.menu.PauseController;
import flapping_bat.controller.menu.TextToMenuController;
import flapping_bat.model.menu.*;
import flapping_bat.textGUI.LanternaTextGUI;
import flapping_bat.controller.Controller;
import flapping_bat.controller.game.GameController;
import flapping_bat.model.enums.AppStatus;
import flapping_bat.model.Game;
import flapping_bat.view.View;
import flapping_bat.view.game.GameView;
import flapping_bat.view.menu.*;

import java.io.IOException;

public class AppMVC {
        private final LanternaTextGUI textGUI;
        private Controller controller;
        private AppStatus status;
        private View view;
        private MainMenu mainMenu;
        private Pause pause;
        private Game game = new Game();
        private Game prevGame;

    public AppMVC() throws IOException {
            this.textGUI = new LanternaTextGUI();
            this.status = AppStatus.MAIN_MENU;
            this.mainMenu = new MainMenu();
            this.controller = new MainMenuController(mainMenu);
            this.view = new MainMenuView(mainMenu);
        }

        public static void main(String[] args) {
            try {
                new AppMVC().start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        private void start() throws Exception {
            int FPS = 14;
            int frameTime = 1000 / FPS;
            while (this.status != null) {
                long startTime = System.currentTimeMillis();

                KeyStroke next_key = textGUI.getNextAction();

                controller.step(this, next_key);
                view.draw(textGUI);


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

        public void exit() {
            this.status = null;
        }

        public void setStatus(AppStatus status) throws IOException {
            if (status == AppStatus.PAUSE_GAME) {
                this.prevGame = this.game;
            }
            this.status = status;
            switch (status) {
                case MAIN_MENU:
                    this.mainMenu = new MainMenu();
                    this.controller = new MainMenuController(mainMenu);
                    this.view = new MainMenuView(mainMenu);
                    break;
                case IN_GAME:
                    this.game = new Game();
                    this.controller = new GameController(game);
                    this.view = new GameView(game);
                    break;
                case CURRENT_GAME:
                    this.game = this.prevGame;
                    this.controller = new GameController(game);
                    this.view = new GameView(game);
                    break;
                case LEADERBOARD_VIEW:
                    Leaderboard leaderboard = new Leaderboard();
                    this.controller = new TextToMenuController(leaderboard);
                    this.view = new LeaderboardView(leaderboard);
                    break;
                case GAME_RULES_VIEW:
                    GameRules gameRules = new GameRules();
                    this.controller = new TextToMenuController(gameRules);
                    this.view = new GameRulesView(gameRules);
                    break;
                case PAUSE_GAME:
                    this.pause = new Pause();
                    this.controller = new PauseController(pause);
                    this.view = new PauseView(pause);
                    break;
                case GAME_OVER:
                    GameOver gameOver = new GameOver(this.game.getScore());
                    this.controller = new GameOverController(gameOver);
                    this.view = new GameOverView(gameOver);
                    break;
            }
    }
}

