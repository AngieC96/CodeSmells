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
        else if (_board.TileAt(x, y).Symbol != ' ') {
            throw new Exception("Invalid position");
        }

        // update game state
        _lastSymbol = symbol;
        _board.AddTileAt(symbol, x, y);
    }

    public char Winner() {
        if (isRowFull(0)) {
            if (isRowFullWithSameSymbol(0)) {
                return _board.TileAt(0, 0).Symbol;
            }
        }

        if (isRowFull(1)) {
            if (isRowFullWithSameSymbol(1)) {
                return _board.TileAt(1, 0).Symbol;
            }
        }

        if (isRowFull(2)) {
            if (isRowFullWithSameSymbol(2)) {
                return _board.TileAt(2, 0).Symbol;
            }
        }

        return ' ';
    }

    private boolean isRowFullWithSameSymbol(int i) {
        return _board.TileAt(i, 0).Symbol ==
                _board.TileAt(i, 1).Symbol &&
                _board.TileAt(i, 2).Symbol == _board.TileAt(i, 1).Symbol;
    }

    private boolean isRowFull(int i) {
        return _board.TileAt(i, 0).Symbol != ' ' &&
                _board.TileAt(i, 1).Symbol != ' ' &&
                _board.TileAt(i, 2).Symbol != ' ';
    }
}

