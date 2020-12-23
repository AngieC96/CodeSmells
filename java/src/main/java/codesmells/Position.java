package codesmells;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        // self check
        if (this == o)
            return true;
        // null check
        if (o == null)
            return false;
        // type check and cast
        if (getClass() != o.getClass())
            return false;
        Position p = (Position) o;
        // field comparison
        return this.getX() == p.getX() &&
                this.getY() == p.getY();
    }

    @Override
    public int hashCode() {
        return Objects.hash(X, Y);
    }

}
