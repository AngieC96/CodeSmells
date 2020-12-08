package codesmells;

public class Tile
{
    private int X;
    private int Y;
    private char Symbol;

    public Tile(int x, int y, char symbol) {
        X = x;
        Y = y;
        Symbol = symbol;
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

    public char getSymbol() {
        return Symbol;
    }

    public void setSymbol(char symbol) {
        Symbol = symbol;
    }
}
