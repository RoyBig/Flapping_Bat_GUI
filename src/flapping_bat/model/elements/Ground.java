package flapping_bat.model.elements;

import flapping_bat.textGUI.LanternaTextGUI;
import flapping_bat.model.Position;

import java.util.ArrayList;
import java.util.List;

public class Ground extends Element implements Collidable{
    public Ground(int y){
        super(new Position(0,y));
    }
    public List<Position> getPositions() {
        List<Position> positions = new ArrayList<>();
        for (int i = 0; i < LanternaTextGUI.width; i++) {
            positions.add(new Position(i, this.getPosition().getY()));
        }
        return positions;
    }
}
