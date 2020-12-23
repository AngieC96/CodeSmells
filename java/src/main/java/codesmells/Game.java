package codesmells;

public class Game {

    private char _lastSymbol = ' ';
    private Board _board = new Board();

    public void Play(Position p, char symbol) throws Exception {
        if (invalidFirstPlayer(symbol)) {
            throw new Exception("Invalid first player");
        }
        else if (playerRepeatedTwice(symbol)) {
            throw new Exception("Invalid next player");
        }
        else if (PlayedInAlreadyPlayedPosition(p)) {
            throw new Exception("Invalid position");
        }

        updateGameState(p, symbol);
    }

    private void updateGameState(Position p, char symbol) {
        _lastSymbol = symbol;
        _board.changeSymbolInTileAt(p, symbol);
    }

    private boolean PlayedInAlreadyPlayedPosition(Position p) {
        return _board.returnSymbolInTileAt(p) != ' ';
    }

    private boolean playerRepeatedTwice(char symbol) {
        return _lastSymbol == symbol;
    }

    private boolean invalidFirstPlayer(char symbol) {
        return _lastSymbol == ' ' && symbol == 'O';
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
        return getSymbolInTileAt(i, 0) == getSymbolInTileAt(i, 1) &&
                getSymbolInTileAt(i, 2) == getSymbolInTileAt(i, 1);
    }

    private boolean isRowFull(int i) {
        return getSymbolInTileAt(i, 0) != ' ' &&
                getSymbolInTileAt(i, 1) != ' ' &&
                getSymbolInTileAt(i, 2) != ' ';
    }
}

