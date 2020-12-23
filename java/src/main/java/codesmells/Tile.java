package codesmells;

public class Tile {

    private Position P;
    private char Symbol;

    public Tile(Position p, char symbol) {
        setP(p);
        Symbol = symbol;
    }

    public Position getP() {
        return P;
    }

    public void setP(Position p) {
        P = p;
        //P.setX(p.getX());
        //P.setY(p.getY());
    }

    public char getSymbol() {
        return Symbol;
    }

    public void setSymbol(char symbol) {
        Symbol = symbol;
    }
}
