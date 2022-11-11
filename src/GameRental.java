import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.border.Border;


public class GameRental extends JFrame implements ActionListener {
    private JFrame systemFrame;
    private JButton addGameButton;
    private JButton removeGameButton;
    private JButton viewGameButton;
    private JPanel gamePanel;
    private JLabel logoImage;
    private JMenu gameOptionMenu;
    public GameRental() {

            systemFrame = new JFrame("Game System");



        gamePanel = new JPanel();
        gamePanel.setLayout(null);
        gamePanel.setBackground(Color.DARK_GRAY);
        //ADD GAME BUTTON
        addGameButton = new JButton("Add Game");
        addGameButton.setMnemonic('A');
        addGameButton.setBackground(Color.LIGHT_GRAY);
        addGameButton.setMargin(new Insets(15,25,15,25));
        addGameButton.setFont(new Font("Arial",Font.BOLD,13));
        addGameButton.setSize(125,50);
        addGameButton.setLocation(60,150);
        addGameButton.setLocation(25,575);
        gamePanel.add(addGameButton);

        //REMOVE GAME BUTTON
        removeGameButton = new JButton("Remove Game");
        removeGameButton.setMnemonic(KeyEvent.VK_R);
        removeGameButton.setBackground(Color.LIGHT_GRAY);
        removeGameButton.setForeground(new Color(51,153,255));
        removeGameButton.setFont(new Font("Arial",Font.BOLD,13));
        removeGameButton.setSize(135,50);
        removeGameButton.setLocation(175,575);
        gamePanel.add(removeGameButton);

        //VIEW GAME BUTTON
        viewGameButton = new JButton("View Games");
        viewGameButton.setMnemonic(KeyEvent.VK_V);
        viewGameButton.setBackground(Color.LIGHT_GRAY);
        viewGameButton.setFont(new Font("Arial",Font.BOLD,13));
        viewGameButton.setSize(125,50);
        viewGameButton.setLocation(335,575);
        gamePanel.add(viewGameButton);

        //NEED TO CHANGE IT TO BACKGROUND IMG INSTEAD!!!!!!!!!
        logoImage = new JLabel();
        logoImage.setIcon(new ImageIcon("C:\\Users\\t00223033\\IdeaProjects\\AlanLigmanProject\\src\\GameRentalLogo-removebg-preview.png"));
        logoImage.setSize(350,450);
        logoImage.setLocation(60,125);
        //logoImage.setBounds(50,150);
        gamePanel.add(logoImage);


        systemFrame.setSize(500, 700);
        systemFrame.setLocationRelativeTo(null);
        systemFrame.setResizable(false);
        systemFrame.add(gamePanel);

        systemFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        systemFrame.setVisible(true);
    }
    public static void main(String[] args) {

        new GameRental();
    }
    public void addGame(){

    }


    public void actionPerformed(ActionEvent e){
        String menuOption = e.getActionCommand();

        if(menuOption == "Add Game" || e.getSource() == this.addGameButton)
            addGame();

    }
}


