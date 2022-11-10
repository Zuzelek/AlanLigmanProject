import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;


public class GameRental extends JFrame implements ActionListener {
    private JFrame systemFrame;
    private JButton addGameButton;
    private JButton removeGameButton;
    private JButton viewGameButton;
    private JPanel gamePanel;

    private JLabel background;
    public GameRental() {
        systemFrame = new JFrame("Game System");

        gamePanel = new JPanel();

        /*background = new JLabel();
        background.setSize(200,200);
        setLayout(null);
        ImageIcon img = new ImageIcon("GameRental.PNG");
        background = new JLabel("",img,JLabel.CENTER);
        background.setBounds(0,0,200,200);
        add(background); */

        //ADD GAME BUTTON
        addGameButton = new JButton("Add Game");
        addGameButton.setMnemonic('A');
        addGameButton.setBackground(Color.GREEN);
        addGameButton.setMargin(new Insets(5,25,5,25));
        gamePanel.add(addGameButton);

        //REMOVE GAME BUTTON
        removeGameButton = new JButton("Remove Game");
        removeGameButton.setMnemonic(KeyEvent.VK_R);
        removeGameButton.setBackground(Color.RED);
        removeGameButton.setMargin(new Insets(5,25,5,25));
        gamePanel.add(removeGameButton);

        //VIEW GAME BUTTON
        viewGameButton = new JButton("View Games");
        viewGameButton.setMnemonic(KeyEvent.VK_V);
        viewGameButton.setBackground(Color.GREEN);
        viewGameButton.setMargin(new Insets(5,25,5,25));
        gamePanel.add(viewGameButton);




        systemFrame.setSize(500, 500);
        systemFrame.setLocationRelativeTo(null);
        systemFrame.setResizable(false);

        systemFrame.add(gamePanel);
        //setIconImage(new ImageIcon(getClass().getResource("bf2042.jpg")).getImage());

        systemFrame.setVisible(true);
    }
    public static void main(String[] args) {
        new GameRental();
    }


    public void actionPerformed(ActionEvent e){

    }
}


