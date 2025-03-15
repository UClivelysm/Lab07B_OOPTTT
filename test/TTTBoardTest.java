import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TTTBoardTest {
    private TTTBoard gameBoard;

    @BeforeEach
    void setUp() {
        gameBoard = new TTTBoard();
    }

    @Test
    void testInitialBoardIsEmpty() {
        TicTacToeTile[][] board = gameBoard.getBoard();
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                assertEquals(" ", board[row][col].getText());
            }
        }
    }

    @Test
    void testInitialPlayerIsX() {
        assertEquals("X", gameBoard.getCurrentPlayer());
    }

    @Test
    void testPlayerSwitchesAfterMove() {
        gameBoard.makeMove(0, 0);
        assertEquals("O", gameBoard.getCurrentPlayer());

        gameBoard.makeMove(1, 1);
        assertEquals("X", gameBoard.getCurrentPlayer());
    }

    @Test
    void testWinByRow() {
        gameBoard.makeMove(0, 0); // X
        gameBoard.makeMove(1, 0); // O
        gameBoard.makeMove(0, 1); // X
        gameBoard.makeMove(1, 1); // O
        gameBoard.makeMove(0, 2); // X wins
        assertTrue(gameBoard.isWin("X"));
    }

    @Test
    void testWinByColumn() {
        gameBoard.makeMove(0, 0);
        gameBoard.makeMove(0, 1);
        gameBoard.makeMove(1, 0);
        gameBoard.makeMove(1, 1);
        gameBoard.makeMove(2, 0);
        assertTrue(gameBoard.isWin("X"));
    }

    @Test
    void testWinByDiagonal() {
        gameBoard.makeMove(0, 0);
        gameBoard.makeMove(0, 1);
        gameBoard.makeMove(1, 1);
        gameBoard.makeMove(0, 2);
        gameBoard.makeMove(2, 2);
        assertTrue(gameBoard.isWin("X"));
    }

    @Test
    void testTieCondition() {
        gameBoard.makeMove(0, 0);
        gameBoard.makeMove(0, 1);
        gameBoard.makeMove(0, 2);
        gameBoard.makeMove(1, 1);
        gameBoard.makeMove(1, 0);
        gameBoard.makeMove(1, 2);
        gameBoard.makeMove(2, 1);
        gameBoard.makeMove(2, 0);
        gameBoard.makeMove(2, 2);
        assertTrue(gameBoard.isTie());
    }

    @Test
    void testMoveOnTakenTileDoesNotSwitchPlayer() {
        gameBoard.makeMove(0, 0);
        String playerAfterFirstMove = gameBoard.getCurrentPlayer();
        gameBoard.makeMove(0, 0);
        assertEquals(playerAfterFirstMove, gameBoard.getCurrentPlayer());
    }

    @Test
    void testBoardResetsCorrectly() {
        gameBoard.makeMove(0, 0);
        gameBoard.makeMove(1, 1);
        gameBoard.makeMove(2, 2);
        gameBoard.resetBoard();

        TicTacToeTile[][] board = gameBoard.getBoard();
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                assertEquals(" ", board[row][col].getText());
            }
        }
        assertEquals("X", gameBoard.getCurrentPlayer());
    }
}
