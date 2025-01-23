import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements ActionListener {
    private JFrame frame;
    private JPanel panel;
    private JButton[] buttons = new JButton[9];
    private boolean xTurn = true;
    private int round = 1;

   public void drawBoard(){
       frame = new JFrame("Tic-Tac-Toe");
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

       panel = new JPanel();
       panel.setLayout(new GridLayout(3, 3));
       panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

       for (int i = 0; i < 9; i++) {
           buttons[i] = new JButton();
           buttons[i].setFont(new Font("Arial", Font.PLAIN, 40));
           buttons[i].addActionListener(this);
           panel.add(buttons[i]);
       }

       frame.add(panel, BorderLayout.CENTER);
       frame.setSize(400, 400);
       frame.setVisible(true);
   }


    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        if (xTurn) {
            button.setText("X");
        } else {
            button.setText("O");
        }
        button.setEnabled(false);
        xTurn = !xTurn;
        round++;
        checkForWinner();
    }

    public void checkForWinner() {
       if(round > 9){
           JOptionPane.showMessageDialog(frame, "Tie!");
           resetGame();
       }
        // Check rows
        for (int i = 0; i < 9; i += 3) {
            if (buttons[i].getText().equals(buttons[i+1].getText()) && buttons[i].getText().equals(buttons[i+2].getText()) && !buttons[i].isEnabled()) {
                JOptionPane.showMessageDialog(frame, buttons[i].getText() + " wins!");
                resetGame();
                return;
            }
        }

        // Check columns
        for (int i = 0; i < 3; i++) {
            if (buttons[i].getText().equals(buttons[i+3].getText()) && buttons[i].getText().equals(buttons[i+6].getText()) && !buttons[i].isEnabled()) {
                JOptionPane.showMessageDialog(frame, buttons[i].getText() + " wins!");
                resetGame();
                return;
            }
        }
        //Diagonal checks

        int count = 0;
        int countO = 0;

        for (int i = 0; i < buttons.length; i += 4) {
            if (buttons[i].getText().equals("X")) {
                count++;
            } else if (buttons[i].getText().equals("O")) {
                countO++;
            }
        }
        if (count == 3) {
            JOptionPane.showMessageDialog(frame, "x wins!");
            resetGame();
            return;
        } else if (countO == 3) {
            JOptionPane.showMessageDialog(frame, "o wins!");
            resetGame();
            return;
        }

        count = 0;
        countO = 0;
        for (int i = buttons.length - 2 - 1; i >= 0; i -= 2) {
            if (buttons[i].getText().equals("X")) {
                count++;
            } else if (buttons[i].getText().equals("O")) {
                countO++;
            }
        }
        if (count == 3) {
            JOptionPane.showMessageDialog(frame, "x wins!");
            resetGame();
        } else if (countO == 3) {
            JOptionPane.showMessageDialog(frame, "o wins!");
            resetGame();
        }
    }

    public void resetGame(){
       for(int i = 0; i < buttons.length; i++){
           buttons[i].setText("");
           buttons[i].setEnabled(true);
           round = 1;
       }
    }


}
