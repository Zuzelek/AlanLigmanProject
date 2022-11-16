import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;


public class GameRental extends JFrame implements ActionListener {

    private String clock;
    private JFrame systemFrame;
    private JButton addGameButton, removeGameButton,viewGameButton ;
    private JPanel gamePanel;
    private JLabel logoImage, clockLabel;
    private SimpleDateFormat clockFormat;
    private JMenuBar mainMenuJMenuBar;
    private JMenu mainMenuJMenuMembers, mainMenuJMenuGames;
    private JMenuItem mainMenuJMenuAddMembers, mainMenuJMenuViewMembers, mainMenuJMenuRemoveMembers,
                      mainMenuJMenuAddGame, mainMenuJMenuViewGames, mainMenuJMenuRemoveGame;

    private Game game;
    private Employee employee;
    private Customer customer;

    ArrayList<Game> games = new ArrayList<>();
    ArrayList<Employee> employees = new ArrayList<>();
    ArrayList<Customer> customers = new ArrayList<>();




    public GameRental() {

        systemFrame = new JFrame("Game System");

        mainMenuJMenuBar = new JMenuBar();
        systemFrame.setJMenuBar(mainMenuJMenuBar);

        //MEMBERS JMENU
        createMenuMembers();
        //GAMES JMENU
        mainMenuJMenuGames = new JMenu("Games");
        mainMenuJMenuBar.add(mainMenuJMenuGames);

        mainMenuJMenuAddGame = new JMenuItem("Add Game");
        mainMenuJMenuGames.add(mainMenuJMenuAddGame);

        mainMenuJMenuViewGames = new JMenuItem("View Games");
        mainMenuJMenuGames.add(mainMenuJMenuViewGames);

        mainMenuJMenuRemoveGame = new JMenuItem("Remove Game");
        mainMenuJMenuGames.add(mainMenuJMenuRemoveGame);


        gamePanel = new JPanel();
        gamePanel.setLayout(null);
        gamePanel.setBackground(Color.DARK_GRAY);
        //CLOCK LABEL
        clockLabel = new JLabel();
        clockLabel.setSize(100,30);
        clockLabel.setLocation(10,20);
        clockLabel.setBackground(Color.BLACK);
        gamePanel.add(clockLabel);


        //ADD GAME BUTTON
        addGameButton = new JButton("Add Game");
        addGameButton.setMnemonic('A');
        addGameButton.setBackground(Color.LIGHT_GRAY);
        addGameButton.setMargin(new Insets(15,25,15,25));
        addGameButton.setFont(new Font("Arial",Font.BOLD,13));
        addGameButton.setSize(125,50);
        addGameButton.setLocation(25,575);
        addGameButton.addActionListener(this);
        gamePanel.add(addGameButton);

        //REMOVE GAME BUTTON
        removeGameButton = new JButton("Remove Game");
        removeGameButton.setMnemonic(KeyEvent.VK_R);
        removeGameButton.setBackground(Color.LIGHT_GRAY);
        removeGameButton.setForeground(new Color(51,153,255));
        removeGameButton.setFont(new Font("Arial",Font.BOLD,13));
        removeGameButton.setSize(135,50);
        removeGameButton.setLocation(175,575);
        removeGameButton.addActionListener(this);
        gamePanel.add(removeGameButton);

        //VIEW GAME BUTTON
        viewGameButton = new JButton("View Games");
        viewGameButton.setMnemonic(KeyEvent.VK_V);
        viewGameButton.setBackground(Color.LIGHT_GRAY);
        viewGameButton.setFont(new Font("Arial",Font.BOLD,13));
        viewGameButton.setSize(125,50);
        viewGameButton.setLocation(335,575);
        viewGameButton.addActionListener(this);
        gamePanel.add(viewGameButton);

        //NEED TO CHANGE IT TO BACKGROUND IMG INSTEAD!!!!!!!!!
        logoImage = new JLabel();
        logoImage.setIcon(new ImageIcon("src/gamePad.png"));
        logoImage.setSize(350,450);
        logoImage.setLocation(60,100);
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
    public void createMenuMembers(){
        mainMenuJMenuMembers = new JMenu("Members");
        mainMenuJMenuBar.add(mainMenuJMenuMembers);

        mainMenuJMenuAddMembers = new JMenuItem("Add Member");
        mainMenuJMenuMembers.add(mainMenuJMenuAddMembers);

        mainMenuJMenuViewMembers = new JMenuItem("View Members");
        mainMenuJMenuMembers.add(mainMenuJMenuViewMembers);
        mainMenuJMenuMembers.addSeparator();

        mainMenuJMenuRemoveMembers = new JMenuItem("Remove Member");
        mainMenuJMenuMembers.add(mainMenuJMenuRemoveMembers);
        mainMenuJMenuMembers.addActionListener(this);
    }
    public void addGame(){
        String gameTitle = JOptionPane.showInputDialog("Please enter the game title: ");
        int gameReleaseYear = Integer.parseInt(JOptionPane.showInputDialog("Please enter the release year: "));
        float gamePrice = Float.parseFloat(JOptionPane.showInputDialog("Please enter the price of the game"));
        String gameCategories[] = {"Sandbox", "Shooters", "Role-playing","Simulation and sports","Puzzlers and party games","Action-adventure","Survival and Horror","Platformer"};
        String category = (String)JOptionPane.showInputDialog(null, "Choose", "Game Category", JOptionPane.PLAIN_MESSAGE, null, gameCategories, gameCategories[0]);

        this.game = new Game(gameTitle,gameReleaseYear,category,gamePrice);
        int i;
        /*boolean valid = false;
        while(!gameTitle.equals(""))
        {
            valid = false;
            while(!valid)
            {
                for (i = 0; i < gameReleaseYear.length(); i++)
                {
                    if (gameReleaseYear.length() == 4) {
                        if (Character.isDigit(gameReleaseYear.charAt(i))) {
                            if (gamePrice.length() == 2) {
                                for (i = 0; i < gamePrice.length(); i++)

                                    if (Character.isDigit(gamePrice.charAt(i))) {
                                        valid = true;
                                    } else
                                        gamePrice = JOptionPane.showInputDialog("Game price must be numeric, please re-enter");
                            } else
                                gamePrice = JOptionPane.showInputDialog("Game price must be 2 digits, please re-enter");
                        } else
                            gameReleaseYear = JOptionPane.showInputDialog("Release year must be numeric, please re-enter");
                    } else
                        gameReleaseYear = JOptionPane.showInputDialog("Release year must be 4 digits long, please re-enter");
                }
            }
            break;
            }*/
        this.games.add(this.game);

    }
    public void displayStaff() {
        JComboBox<String> cuisineCombo = new JComboBox();
        JTextArea output = new JTextArea();
        output.setText("Cuisine Details:\n\n");
        if (this.games.size() < 1) {
            JOptionPane.showMessageDialog(null, "No cuisines is added in the system. Please 'Open' the file.", "Error", 0);
        } else {
            Iterator<Game> iterator = this.games.iterator();
            while (iterator.hasNext())
            {
                System.out.println(iterator.next()+ " ");
            }
            }
        }

    /*
    public void displayGames(){
        JComboBox<String> gameComboBox = new JComboBox<>();
        JTextArea gameList = new JTextArea("Game Details");

        if(this.games.size() == 0)
        {
            JOptionPane.showMessageDialog(null,"No games have been found","Game Details",JOptionPane.ERROR_MESSAGE);
        }
        else
        {
            Iterator<Game> gameIterator = this.games.iterator();

            while(gameIterator.hasNext())
            {
                JOptionPane.showMessageDialog(null,gameIterator.next() + "\n","Game List",JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }*/
    public void removeGameButton(){

    }
    public void rentalClock(){


        while(true) {
            clockFormat = new SimpleDateFormat("hh:mm:ss");
            clock = clockFormat.format(Calendar.getInstance().getTime());
        try {
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        GameRental.this.clockLabel.setText(clock);
        }
    }

    public void actionPerformed(ActionEvent e){
        String menuOption = e.getActionCommand();

        if(menuOption == "Add Game" || e.getSource() == this.addGameButton)
        {
            addGame();
        }
        else if(e.getSource() == this.mainMenuJMenuMembers || e.getSource() == this.viewGameButton)
        {
            displayStaff();
        }

    }
}


