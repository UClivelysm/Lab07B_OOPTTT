import javax.swing.*;
import java.awt.*;

public class TicTacToeFrame extends JFrame {
    private TicTacToeTile[][] board;
    private String currentPlayer = "X";




    public TicTacToeFrame() {
        board = new TicTacToeTile[3][3];
        setLayout(new GridLayout(3, 3));
        CreateBoard();
        setTitle("Tic-Tac-Toe");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }

    private void CreateBoard() {
        TicTacToeActionListener listener = new TicTacToeActionListener(this);
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                board[row][col] = new TicTacToeTile(row, col);
                board[row][col].setText(" ");
                board[row][col].addActionListener(listener);
                add(board[row][col]);
            }
        }
    }
    public String getCurrentPlayer() {
        return currentPlayer;
    }
    public void switchPlayer() {
        if (currentPlayer.equals("X")) {
            currentPlayer = "O";
        } else {
            currentPlayer = "X";
        }
    }
    public TicTacToeTile[][] getBoard() {
        return board;
    }

    public boolean isWin(String player) {
        return isRowWin(player) || isColWin(player) || isDiagonalWin(player);
    }

    private boolean isRowWin(String player) {
        for (int row = 0; row < 3; row++) {
            if (board[row][0].getText().equals(player) &&
                    board[row][1].getText().equals(player) &&
                    board[row][2].getText().equals(player)) {
                return true;
            }
        }
        return false;
    }

    private boolean isColWin(String player) {
        for (int col = 0; col < 3; col++) {
            if (board[0][col].getText().equals(player) &&
                    board[1][col].getText().equals(player) &&
                    board[2][col].getText().equals(player)) {
                return true;
            }
        }
        return false;
    }

    private boolean isDiagonalWin(String player) {
        return (board[0][0].getText().equals(player) &&
                board[1][1].getText().equals(player) &&
                board[2][2].getText().equals(player)) ||
                (board[0][2].getText().equals(player) &&
                        board[1][1].getText().equals(player) &&
                        board[2][0].getText().equals(player));
    }

    public boolean isTie() {
        boolean xFlag = false;
        boolean oFlag = false;

        for (int row = 0; row < 3; row++) {
            xFlag = oFlag = false;
            for (int col = 0; col < 3; col++) {
                if (board[row][col].getText().equals("X")) {
                    xFlag = true;
                }
                if (board[row][col].getText().equals("O")) {
                    oFlag = true;
                }
            }
            if (!(xFlag && oFlag)) {
                return false;
            }
        }

        for (int col = 0; col < 3; col++) {
            xFlag = oFlag = false;
            for (int row = 0; row < 3; row++) {
                if (board[row][col].getText().equals("X")) {
                    xFlag = true;
                }
                if (board[row][col].getText().equals("O")) {
                    oFlag = true;
                }
            }
            if (!(xFlag && oFlag)) {
                return false;
            }
        }

        xFlag = oFlag = false;
        if (board[0][0].getText().equals("X") || board[1][1].getText().equals("X") || board[2][2].getText().equals("X")) {
            xFlag = true;
        }
        if (board[0][0].getText().equals("O") || board[1][1].getText().equals("O") || board[2][2].getText().equals("O")) {
            oFlag = true;
        }
        if (!(xFlag && oFlag)) {
            return false;
        }

        xFlag = oFlag = false;
        if (board[0][2].getText().equals("X") || board[1][1].getText().equals("X") || board[2][0].getText().equals("X")) {
            xFlag = true;
        }
        if (board[0][2].getText().equals("O") || board[1][1].getText().equals("O") || board[2][0].getText().equals("O")) {
            oFlag = true;
        }
        if (!(xFlag && oFlag)) {
            return false;
        }

        return true;
    }
    public void resetBoard() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                board[row][col].setText(" ");
            }
        }
        this.currentPlayer = "X";
    }



}



