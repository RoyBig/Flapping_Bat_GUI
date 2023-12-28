package flapping_bat.model.elements;

import flapping_bat.textGUI.LanternaTextGUI;
import flapping_bat.model.Position;

import java.util.ArrayList;
import java.util.List;

public class Wall extends Element implements Collidable{
    private final static int speed = -1;
    private final static int width = 4;

    private int height;
    private int space;
    public Wall(int height){
        super(new Position(LanternaTextGUI.width, 0));
        this.height = height;
        this.space = 15;;
    }
    public static int getSpeed(){
        return speed;
    }
    public static int getWidth(){
        return width;
    }
    public int getHeight(){
        return height;
    }
    public int getSpace(){
        return space;
    }
    public void setX(int x){
        this.setPosition(new Position(x,this.getPosition().getY()));
    }
    public boolean isGapHeight(int y){
        return y > this.height && y < this.height + this.space;
    }
    public boolean isOutOfScreen(){
        return this.getPosition().getX() < -1;
    }
    public void move(){
        this.setX(this.getPosition().getX()+ getSpeed());
    }
    public List<Position> getPositions() {
        List<Position> positions = new ArrayList<>();

        int x = this.getPosition().getX();

        for (int y = 0; y <= LanternaTextGUI.height; y++) {
            if (this.isGapHeight(y)) continue;
            positions.add(new Position(x, y));
            positions.add(new Position(x + 1, y));
            positions.add(new Position(x-1,y));
            positions.add(new Position(x-2,y));
        }
        return positions;
    }
}


