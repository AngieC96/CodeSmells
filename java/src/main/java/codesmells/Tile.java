package codesmells;

public class Tile {

    private Position P;
    private char Symbol;

    public Tile(int x, int y, char symbol) {
        P = new Position(x, y);
        Symbol = symbol;
    }

    public Position getP() {
        return P;
    }

    public void setP(Position p) {
        P.setX(p.getX());
        P.setY(p.getY());
    }

    public char getSymbol() {
        return Symbol;
    }

    public void setSymbol(char symbol) {
        Symbol = symbol;
    }
}
