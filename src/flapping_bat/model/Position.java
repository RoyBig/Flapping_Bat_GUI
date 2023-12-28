package flapping_bat.model;

public class Position {
    private int x;
    private int y;
    public Position(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Position)) {
            return false;
        }
        Position position = (Position) obj;
        return position.getX() == this.getX() && position.getY() == this.getY();
    }
}
