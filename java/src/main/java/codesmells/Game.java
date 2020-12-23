package codesmells;

public class Game {

    private char _lastSymbol = ' ';
    private Board _board = new Board();

    public void Play(Position p, char symbol) throws Exception {
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
        else if (_board.returnSymbolInTileAt(p) != ' ') {
            throw new Exception("Invalid position");
        }

        // update game state
        _lastSymbol = symbol;
        _board.changeSymbolInTileAt(p, symbol);
    }

    public char Winner() {
        for (int i=0; i < _board.DIMBOARD; ++i) {
            if (checkWinByRow(i))
                return getSymbolInTileAt(i, 0);
        }
        return ' ';
    }

    private char getSymbolInTileAt(int x, int y) {
        return _board.returnSymbolInTileAt(new Position(x, y));
    }

    private boolean checkWinByRow(int i) {
        if (isRowFull(i)) {
            return isRowFullWithSameSymbol(i);
        }
        return false;
    }

    private boolean isRowFullWithSameSymbol(int i) {
        return getSymbolInTileAt(i, 0) ==
                getSymbolInTileAt(i, 1) &&
                getSymbolInTileAt(i, 2) == getSymbolInTileAt(i, 1);
    }

    private boolean isRowFull(int i) {
        return getSymbolInTileAt(i, 0) != ' ' &&
                getSymbolInTileAt(i, 1) != ' ' &&
                getSymbolInTileAt(i, 2) != ' ';
    }
}

