package codesmells;

public class Position {
    private int X;
    private int Y;

    public Position(int x, int y) {
        X = x;
        Y = y;
    }

    public int getX() {
        return X;
    }

    public void setX(int x) {
        X = x;
    }

    public int getY() {
        return Y;
    }

    public void setY(int y) {
        Y = y;
    }

    public boolean equals(Position p) {
        if (this.getX() == p.getX() && this.getY() == p.getY()) {
            return true;
        }
        return false;
    }
}
