package codesmells;

import java.util.ArrayList;
import java.util.List;

public class Board
{
    private List<Tile> _plays = new ArrayList<>();

    public Board()
    {
        final int DIM = 3;
        for (int i = 0; i < DIM; i++)
        {
            for (int j = 0; j < DIM; j++)
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
