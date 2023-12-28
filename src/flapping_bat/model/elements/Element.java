package flapping_bat.model.elements;

import flapping_bat.model.Position;

public abstract class Element {
    private Position position;
    public Element(Position position){
        this.position = position;
    }
    public Position getPosition(){
        return this.position;
    }
    public void setPosition(Position position){
        this.position = position;
    }

}
