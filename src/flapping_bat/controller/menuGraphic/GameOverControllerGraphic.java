package flapping_bat.controller.menuGraphic;

import flapping_bat.AppMVC;
import flapping_bat.controller.ControllerGraphic;
import flapping_bat.controller.menu.GameOverController;
import flapping_bat.model.enums.AppStatus;
import flapping_bat.model.menu.GameOver;
import flapping_bat.view.menuGraphic.GameOverViewGraphic;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class GameOverControllerGraphic extends ControllerGraphic {
    AppMVC appMVC;
    public GameOverControllerGraphic(AppMVC appMVC){
        this.appMVC = appMVC;
    }
    public void playAgainButtonPressed(){
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
    public void updateLeaderboard(int score, String username) throws IOException {
        File leaderboard = new File("src/resources/leaderboard.txt");
        Scanner scanner = new Scanner(leaderboard);
        ArrayList<Integer> scores = new ArrayList<>();
        ArrayList<String> usernames = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] parts = line.split("-");
            scores.add(Integer.parseInt(parts[0].trim()));
            usernames.add(parts[1].trim());
        }

        if (scores.size() < 10) {
            FileWriter writer = new FileWriter(leaderboard, true);
            writer.write(score + " - " + username + "\n");
            writer.close();
            return;
        }

        int minimumScore = Collections.min(scores);
        int minimumScoreIndex = scores.indexOf(minimumScore);

        if (score > minimumScore) {
            scores.set(minimumScoreIndex, score);
            usernames.set(minimumScoreIndex, username);
            FileWriter writer = new FileWriter(leaderboard);
            for (int i = 0; i < scores.size(); i++) {
                writer.write(scores.get(i) + " - " + usernames.get(i) + "\n");
            }
            writer.close();
        }
    }
}
