import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToeActionListener implements ActionListener {
    private TicTacToeFrame frame;

    public TicTacToeActionListener(TicTacToeFrame frame) {
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        TicTacToeTile tile = (TicTacToeTile) e.getSource();
        int row = tile.getRow();
        int col = tile.getCol();

//        System.out.println("Clicked row: " + row + ", col: " + col); // debug to verify ActionListener functionality

        if (tile.getText().equals(" ")) {


            tile.setText(String.valueOf(frame.getCurrentPlayer())); // Set the current player's mark
            if (frame.isWin(frame.getCurrentPlayer())) {


                JOptionPane.showMessageDialog(frame, "Player " + frame.getCurrentPlayer() + " wins!");
                int response = JOptionPane.showConfirmDialog(frame, "Start a new game?", "Game Over", JOptionPane.YES_NO_OPTION);


                if (response == JOptionPane.YES_OPTION) {
                    frame.resetBoard();
                }
            } else if (frame.isTie()) {


                JOptionPane.showMessageDialog(frame, "It's a tie!");
                int response = JOptionPane.showConfirmDialog(frame, "Start a new game?", "Game Over", JOptionPane.YES_NO_OPTION);


                if (response == JOptionPane.YES_OPTION) {
                    frame.resetBoard();
                }
            } else {
                frame.switchPlayer(); // Switch to the next player
            }



        }
    }
}
