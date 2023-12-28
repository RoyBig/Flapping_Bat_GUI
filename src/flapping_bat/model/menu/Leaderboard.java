package flapping_bat.model.menu;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Leaderboard extends TextToMenu {
    public Leaderboard() throws FileNotFoundException {
        super("src/resources/leaderboard.txt");
    }

    @Override
    public ArrayList<String> sortText(ArrayList<String> leaderboard) {
        leaderboard.sort((s1, s2) -> {
            String[] s1Split = s1.split(" ");
            String[] s2Split = s2.split(" ");
            return Integer.parseInt(s2Split[0]) - Integer.parseInt(s1Split[0]);
        });
        return leaderboard;
    }
}
