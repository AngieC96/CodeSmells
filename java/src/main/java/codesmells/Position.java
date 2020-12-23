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
        // self check: checking if both the object references
        // are referring to the same object.
        if (this == o)
            return true;
        // null check: checking if the object reference is null.
        if (o == null)
            return false;
        // type check and cast: it checks if the argument is
        // of the type Position by comparing the classes
        // of the passed argument and this object.
        // if(!(obj instanceof Position)) return false; ---> avoid.
        if (getClass() != o.getClass())
            return false;
        // type casting of the argument.
        Position p = (Position) o;
        // field comparison: comparing the state of argument
        // with the state of 'this' Object.
        return this.getX() == p.getX() &&
                this.getY() == p.getY();
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int result = 1;
        result = prime * (prime + X) + Y;
        return result;
    }

}
