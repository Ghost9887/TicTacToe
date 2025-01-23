import javax.swing.*;

public class GUI {

    Logic logic = new Logic();

   public void drawBoard(){
       JFrame frame = new JFrame("TicTacToe");
       JPanel panel = new JPanel();
       panel.setLayout(null);



       frame.add(panel);

       frame.setVisible(true);
       frame.setSize(600, 600);
       frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

   }

}
