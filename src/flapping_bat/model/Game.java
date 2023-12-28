package flapping_bat.model;

import flapping_bat.textGUI.LanternaTextGUI;
import flapping_bat.model.elements.Ground;
import flapping_bat.model.elements.Player;
import flapping_bat.model.elements.Wall;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private final Player player;
    private final List<Wall> wallList;
    private final Ground ground;
    private boolean isPlaying;
    private int score;
    private int steps;

    public Game(){
        this.player = new Player(new Position(9, LanternaTextGUI.height/2 - 1));
        this.wallList = new ArrayList<>();
        this.ground = new Ground(LanternaTextGUI.height);
        this.isPlaying = false;
        this.score = 0;
        this.steps =0;
    }
    public Player getPlayer(){
        return player;
    }
    public boolean isPlaying() {return isPlaying;}
    public void setPlaying(boolean playing){
        this.isPlaying = playing;
    }
    public void startPlaying(){
        isPlaying = true;
    }
    public List<Wall> getWallList(){
        return wallList;
    }
    public Ground getGround(){
        return ground;
    }
    public void addWall(Wall wall){
        wallList.add(wall);
    }
    public void incrementScore(int points){
        score +=points;
    }
    public int getScore(){
        return score;
    }
    public int getSteps(){
        return steps;
    }
    public void incrementSteps(){
        steps++;
        if(steps == 20) steps =0;
    }


}
