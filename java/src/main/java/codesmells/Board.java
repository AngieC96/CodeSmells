package codesmells;

import java.util.ArrayList;
import java.util.List;

public class Board {

    final int DIMBOARD = 3;
    private List<Tile> _plays = new ArrayList<>();

    public Board() {
        for (int i = 0; i < DIMBOARD; i++) {
            for (int j = 0; j < DIMBOARD; j++) {
                _plays.add(new Tile(i, j, ' '));
            }
        }
    }

    public Tile TileAt(int x, int y) {
        for (Tile t : _plays) {
            if (t.getX() == x && t.getY() == y){
                return t;
            }
        }
        return null;
    }

    public char returnSymbolInTileAt(int x, int y) {
        return TileAt(x, y).getSymbol();
    }

    public void changeSymbolInTileAt(int x, int y, char symbol) {
        TileAt(x, y).setSymbol(symbol);
    }
}
