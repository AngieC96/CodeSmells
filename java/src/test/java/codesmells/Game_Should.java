package codesmells;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Game_Should {
    private Game game;

    @Before
    public void InitializeGame(){
        game = new Game();
    }

    @Test(expected=Exception.class)
    public void NotAllowPlayerOToPlayFirst() throws Exception {
        game.Play(new Position(0, 0), 'O');
    }

    @Test(expected=Exception.class)
    public void NotAllowPlayerXToPlayTwiceInARow() throws Exception
    {
        game.Play(new Position(0, 0), 'X');

        game.Play(new Position(1, 0), 'X');
    }

    @Test(expected=Exception.class)
    public void NotAllowPlayerToPlayInLastPlayedPosition() throws Exception
    {
        game.Play(new Position(0, 0), 'X');

        game.Play(new Position(0, 0), 'O');
    }

    @Test(expected=Exception.class)
    public void NotAllowPlayerToPlayInAnyPlayedPosition() throws Exception
    {
        game.Play(new Position(0, 0), 'X');
        game.Play(new Position(1, 0), 'O');

        game.Play(new Position(0, 0), 'X');
    }

    @Test
    public void DeclarePlayerXAsAWinnerIfThreeInTopRow() throws Exception
    {
        game.Play(new Position(0, 0), 'X');
        game.Play(new Position(1, 0), 'O');
        game.Play(new Position(0, 1), 'X');
        game.Play(new Position(1, 1), 'O');
        game.Play(new Position(0, 2), 'X');

        char winner = game.Winner();

        assertEquals('X', winner);
    }

    @Test
    public void DeclarePlayerOAsAWinnerIfThreeInTopRow() throws Exception
    {
        game.Play(new Position(2, 2), 'X');
        game.Play(new Position(0, 0), 'O');
        game.Play(new Position(1, 0), 'X');
        game.Play(new Position(0, 1), 'O');
        game.Play(new Position(1, 1), 'X');
        game.Play(new Position(0, 2), 'O');

        char winner = game.Winner();

        assertEquals('O', winner);
    }

    @Test
    public void DeclarePlayerXAsAWinnerIfThreeInMiddleRow() throws Exception
    {
        game.Play(new Position(1, 0), 'X');
        game.Play(new Position(0, 0), 'O');
        game.Play(new Position(1, 1), 'X');
        game.Play(new Position(0, 1), 'O');
        game.Play(new Position(1, 2), 'X');

        char winner = game.Winner();

        assertEquals('X', winner);
    }

    @Test
    public void DeclarePlayerOAsAWinnerIfThreeInMiddleRow() throws Exception
    {
        game.Play(new Position(0, 0), 'X');
        game.Play(new Position(1, 0), 'O');
        game.Play(new Position(2, 0), 'X');
        game.Play(new Position(1, 1), 'O');
        game.Play(new Position(2, 1), 'X');
        game.Play(new Position(1, 2), 'O');

        char winner = game.Winner();

        assertEquals('O', winner);
    }

    @Test
    public void DeclarePlayerXAsAWinnerIfThreeInBottomRow() throws Exception
    {
        game.Play(new Position(2, 0), 'X');
        game.Play(new Position(0, 0), 'O');
        game.Play(new Position(2, 1), 'X');
        game.Play(new Position(0, 1), 'O');
        game.Play(new Position(2, 2), 'X');

        char winner = game.Winner();

        assertEquals('X', winner);
    }

    @Test
    public void DeclarePlayerOAsAWinnerIfThreeInBottomRow() throws Exception
    {
        game.Play(new Position(0, 0), 'X');
        game.Play(new Position(2, 0), 'O');
        game.Play(new Position(1, 0), 'X');
        game.Play(new Position(2, 1), 'O');
        game.Play(new Position(1, 1), 'X');
        game.Play(new Position(2, 2), 'O');

        char winner = game.Winner();

        assertEquals('O', winner);
    }
}
