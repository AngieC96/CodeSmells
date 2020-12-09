package codesmells;

import java.util.ArrayList;
import java.util.List;

public class Board
{
    final int DIMBOARD = 3;
    private List<Tile> _plays = new ArrayList<>();

    public Board()
    {
        for (int i = 0; i < DIMBOARD; i++)
        {
            for (int j = 0; j < DIMBOARD; j++)
            {
                Tile tile = new Tile(i, j, ' ');
                _plays.add(tile);
            }
        }
    }

    public Tile TileAt(int x, int y)
    {
        for (Tile t : _plays) {
            if (t.getX() == x && t.getY() == y){
                return t;
            }
        }
        return null;
    }

    public void changeSymbolInTileAt(char symbol, int x, int y)
    {
        TileAt(x, y).setSymbol(symbol);
    }
}
