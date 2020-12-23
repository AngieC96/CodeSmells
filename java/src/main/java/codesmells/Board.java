package codesmells;

import java.util.ArrayList;
import java.util.List;

public class Board {

    final int DIMBOARD = 3;
    private List<Tile> _plays = new ArrayList<>();

    public Board() {
        for (int i = 0; i < DIMBOARD; i++) {
            for (int j = 0; j < DIMBOARD; j++) {
                _plays.add(new Tile(new Position(i, j), ' '));
            }
        }
    }

    public Tile TileAt(Position p) {
        for (Tile t : _plays) {
            if (t.getP().equals(p)){
                return t;
            }
        }
        return null;
    }

    public char returnSymbolInTileAt(Position p) {
        return TileAt(p).getSymbol();
    }

    public void changeSymbolInTileAt(Position p, char symbol) {
        TileAt(p).setSymbol(symbol);
    }
}
