package flapping_bat.view.menu;

import flapping_bat.model.Position;
import flapping_bat.model.enums.Colors;
import flapping_bat.model.menu.Leaderboard;
import flapping_bat.textGUI.LanternaTextGUI;

public class LeaderboardView extends MenuView<Leaderboard>{
    public LeaderboardView(Leaderboard leaderboard){
        super(leaderboard, new Position(2,7));
    }

    protected void drawInsideElements(LanternaTextGUI lanternaTextGUI) {
        drawTitle(lanternaTextGUI, "Leaderboard", Colors.ORANGE.getHex());

        for (int i = 0; i < getModel().getSize(); i++) {
            if(i==0) {
                drawText(lanternaTextGUI, new Position(8, 13 + i), getModel().getLine(i), Colors.ORANGE.getHex());
            }
            else{
                drawText(lanternaTextGUI, new Position(8, 13 + i), getModel().getLine(i), Colors.WHITE.getHex());

            }
        }
    }
    @Override
    public void drawOptions(LanternaTextGUI lanternaTextGUI) {

    }
}
