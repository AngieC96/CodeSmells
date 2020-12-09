package codesmells;

public class Game {
    private char _lastSymbol = ' ';
    private Board _board = new Board();

    public void Play(char symbol, int x, int y) throws Exception {
        //if first move
        if (_lastSymbol == ' ') {
            //if player is X
            if (symbol == 'O') {
                throw new Exception("Invalid first player");
            }
        }
        //if not first move but player repeated
        else if (symbol == _lastSymbol) {
            throw new Exception("Invalid next player");
        }
        //if not first move but play on an already played tile
        else if (_board.TileAt(x, y).getSymbol() != ' ') {
            throw new Exception("Invalid position");
        }

        // update game state
        _lastSymbol = symbol;
        _board.changeSymbolInTileAt(symbol, x, y);
    }

    public char Winner() {
        for (int i=0; i < _board.DIMBOARD; ++i) {
            if (checkWinByRow(i))
                return _board.TileAt(i, 0).getSymbol();
        }
        return ' ';
    }

    private boolean checkWinByRow(int i) {
        if (isRowFull(i)) {
            return isRowFullWithSameSymbol(i);
        }
        return false;
    }

    private boolean isRowFullWithSameSymbol(int i) {
        return _board.TileAt(i, 0).getSymbol() ==
                _board.TileAt(i, 1).getSymbol() &&
                _board.TileAt(i, 2).getSymbol() == _board.TileAt(i, 1).getSymbol();
    }

    private boolean isRowFull(int i) {
        return _board.TileAt(i, 0).getSymbol() != ' ' &&
                _board.TileAt(i, 1).getSymbol() != ' ' &&
                _board.TileAt(i, 2).getSymbol() != ' ';
    }
}

