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


    private String clock,date;
    private JFrame systemFrame;
    private JButton addGameButton, removeGameButton,viewGameButton ;
    private JPanel gamePanel;
    private JLabel logoImage, clockLabel, dateLabel;
    private JMenuBar mainMenuJMenuBar;
    private JMenu mainMenuJMenuCustomer, mainMenuJMenuGames, mainMenuJMenuEmployee;
    private JMenuItem mainMenuJMenuAddCustomer, mainMenuJMenuViewCustomer, mainMenuJMenuRemoveCustomer;
    private JMenuItem mainMenuJMenuAddGame, mainMenuJMenuViewGames, mainMenuJMenuRemoveGame;
    private JMenuItem mainMenuJMenuAddEmployee, mainMenuJMenuRemoveEmployee, mainMenuJMenuViewEmployee;

    Calendar calendar;
    SimpleDateFormat formatTime;
    SimpleDateFormat formatDate;


    private Game game;
    private Employee employee;
    private Customer customer;

    ArrayList<Game> games = new ArrayList<>();
    ArrayList<Employee> employees = new ArrayList<>();
    ArrayList<Customer> customers = new ArrayList<>();




    public GameRental() {
        systemFrame = new JFrame("Game System");

        displayJMenu();


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
        addGameButton.setBounds(15,25,15,25);
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
        removeGameButton.setBounds(175,575,135,50);
        removeGameButton.addActionListener(this);
        gamePanel.add(removeGameButton);

        //VIEW GAME BUTTON
        viewGameButton = new JButton("View Games");
        viewGameButton.setMnemonic(KeyEvent.VK_V);
        viewGameButton.setBackground(Color.LIGHT_GRAY);
        viewGameButton.setFont(new Font("Arial",Font.BOLD,13));
        viewGameButton.setBounds(335,575,125,50);
        viewGameButton.addActionListener(this);
        gamePanel.add(viewGameButton);


        logoImage = new JLabel();
        logoImage.setIcon(new ImageIcon("src/gamePad.png"));
        logoImage.setBounds(60,100,350,450);
        gamePanel.add(logoImage);

        //CLOCK LABEL
        displayClock();

        systemFrame.setSize(500, 700);
        systemFrame.setLocationRelativeTo(null);
        systemFrame.setResizable(false);
        systemFrame.add(gamePanel);


        systemFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        systemFrame.setVisible(true);
        rentalClock();
    }
    public static void main(String[] args) {

        new GameRental();
    }


    public void addCustomer()
    {
        String firstName = JOptionPane.showInputDialog("Please enter your first name");
        String lastName = JOptionPane.showInputDialog("Please enter your last name");
        String emailAddress = JOptionPane.showInputDialog("Please enter your Email Address");
        String address = JOptionPane.showInputDialog("Please enter your address");
        String phoneNumber = JOptionPane.showInputDialog("Please enter your phone number");
        String dateOfBirth = JOptionPane.showInputDialog("Please enter your date of Birth");
        String password = JOptionPane.showInputDialog("Please enter a password");

        this.customer = new Customer(firstName,lastName,emailAddress,address,phoneNumber,dateOfBirth,password);

       //DO VALIDATION FOR ADD CUSTOMER

        //ADD TO ARRAY LIST
        this.customers.add(this.customer);
    }
    public void addEmployee()
    {
        String firstName = JOptionPane.showInputDialog("Please enter your first name");
        String lastName = JOptionPane.showInputDialog("Please enter your last name");

        this.employee = new Employee(firstName,lastName);

        //DO VALIDATION FOR ADD CUSTOMER

        //ADD TO ARRAY LIST
        this.employees.add(this.employee);
        JOptionPane.showMessageDialog(null,"Employee has been added to the system","Employee Added",JOptionPane.INFORMATION_MESSAGE);
    }
    public void displayEmployees(){
        JComboBox<String> employeeComboBox = new JComboBox<>();
        JTextArea employeeResults = new JTextArea();
        employeeResults.setText("Employees found in the system\n\n");
        try{
            if(this.employees.size() < 1){
                JOptionPane.showMessageDialog(null,"No customers have been found in the system. Please 'Open' the file.","Error, no employees found",JOptionPane.ERROR_MESSAGE);
            }else {
                Iterator<Employee> employeeIterator = this.employees.iterator();
                while(employeeIterator.hasNext())
                    employeeComboBox.addItem(((Employee) employeeIterator.next()).getFirstName() + "\n");
                    JOptionPane.showMessageDialog(null, employeeComboBox, "Select an employee to view details",JOptionPane.INFORMATION_MESSAGE);

                    int comboBoxSelection = employeeComboBox.getSelectedIndex();
                    employeeResults.append(((Employee) this.employees.get(comboBoxSelection)).toString());
                    JOptionPane.showMessageDialog(null, employeeResults,"Employee Details",JOptionPane.INFORMATION_MESSAGE);
            }

        }catch (NullPointerException e){
            JOptionPane.showMessageDialog(null,"Employee details could not be loaded","Error",JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
    public void removeEmployee(){
        JComboBox employeeList = new JComboBox();
        for(Employee e : this.employees)
            employeeList.addItem(e.getFirstName());
        if(this.employees.size() < 1){
            JOptionPane.showMessageDialog(null,"No employees have been found in the system","Employees not found",JOptionPane.ERROR_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null,"Please select an employee you wish to remove\n\n","Remove Employee",JOptionPane.QUESTION_MESSAGE);
            JOptionPane.showMessageDialog(null,employeeList,"Remove Customer",JOptionPane.INFORMATION_MESSAGE);
            int employeeSelect = employeeList.getSelectedIndex();
            this.employees.remove(employeeSelect);
            JOptionPane.showMessageDialog(null,"Selected employee has been removed","Remove Employee",JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void addGame(){
        String gameTitle = JOptionPane.showInputDialog("Please enter the game title: ");
        String gameReleaseYear = JOptionPane.showInputDialog("Please enter the release year (YYYY) ");
        String gamePrice = JOptionPane.showInputDialog("Please enter the price of the game (€EE.CC)");
        String gameCategories[] = {"Sandbox", "Shooters", "Role-playing","Simulation and sports","Puzzlers and party games","Action-adventure","Survival and Horror","Platformer"};
        String category = (String)JOptionPane.showInputDialog(null, "Choose", "Game Category", JOptionPane.PLAIN_MESSAGE, null, gameCategories, gameCategories[0]);

        int i;
        boolean valid;
        while(!gameTitle.equals(""))
        {
            valid = false;
            while(!valid)
            {
                for (i = 0; i < gameReleaseYear.length(); i++)
                    break;
                {
                    if (gameReleaseYear.length() == 4) {
                        if (Character.isDigit(gameReleaseYear.charAt(i))) {
                            if (gamePrice.length() == 2 || gamePrice.length() == 5 && gamePrice.charAt(2) == '.') {
                                for (i = 0; i < gamePrice.length(); i++)
                                    break;
                                if (Character.isDigit(gamePrice.charAt(i)))
                                {
                                    this.game = new Game(gameTitle,gameReleaseYear,category,gamePrice);
                                    JOptionPane.showMessageDialog(null,"Game: "+gameTitle+" has been added to the system","Game Added",JOptionPane.INFORMATION_MESSAGE);
                                    valid = true;
                                    continue;
                                } else
                                    gamePrice = JOptionPane.showInputDialog("Game price must be numeric, please re-enter");
                                continue;
                            } else
                                gamePrice = JOptionPane.showInputDialog("Game price must be in the form of (€EE.CC), please re-enter");
                            continue;
                        } else
                            gameReleaseYear = JOptionPane.showInputDialog("Release year must be numeric (YYYY), please re-enter");
                        continue;
                    } else
                        gameReleaseYear = JOptionPane.showInputDialog("Release year must be 4 digits long (YYYY), please re-enter");
                    continue;
                }
            }
            break;
        }
        this.games.add(this.game);

    }
    public void displayGames() {
        JComboBox<String> gamesComboBox = new JComboBox();
        JTextArea gameResults = new JTextArea();
        gameResults.setText("Game Details Found in the system:\n\n");
        try {
            if (this.games.size() == 0) {
                JOptionPane.showMessageDialog(null, "No games have been found in the system. Please 'Open' the file.", "Error, no games found", JOptionPane.ERROR_MESSAGE);
            } else {
                Iterator<Game> gameIterator = this.games.iterator();
                while (gameIterator.hasNext())
                    gamesComboBox.addItem(((Game) gameIterator.next()).getTitle() + "\n");
                    JOptionPane.showMessageDialog(null, gamesComboBox, "Select a game to view it's details", JOptionPane.NO_OPTION);
                    
                    int comboBoxSelection = gamesComboBox.getSelectedIndex();
                    gameResults.append(((Game) this.games.get(comboBoxSelection)).toString());
                    JOptionPane.showMessageDialog(null, gameResults, "Game Details", JOptionPane.NO_OPTION);

                
            }
        }catch(NullPointerException e)
        {
            JOptionPane.showMessageDialog(null,"Game details could not be loaded","Error",JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        }
    public void removeGame(){
        JComboBox gamesList = new JComboBox();
        for(Game g : this.games)
            gamesList.addItem(g.getTitle());
        if(this.games.size() < 1)
        {
            JOptionPane.showMessageDialog(null,"No games have been found in the system","Games not found",JOptionPane.ERROR_MESSAGE);
        }
        else {
            JOptionPane.showMessageDialog(null, "Please select a game you wish to remove\n\n", "Remove Game", JOptionPane.QUESTION_MESSAGE);
            JOptionPane.showMessageDialog(null, gamesList, "Remove Game", JOptionPane.INFORMATION_MESSAGE);
            int gameSelect = gamesList.getSelectedIndex();
            this.games.remove(gameSelect);
            JOptionPane.showMessageDialog(null, "Selected game has been removed", "Game Removed", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void displayJMenu(){
        mainMenuJMenuBar = new JMenuBar();
        systemFrame.setJMenuBar(mainMenuJMenuBar);

        //CUSTOMERS JMENU
        mainMenuJMenuCustomer = new JMenu("Customers");
        mainMenuJMenuBar.add(mainMenuJMenuCustomer);

        mainMenuJMenuAddCustomer = new JMenuItem("Add Customer");
        mainMenuJMenuCustomer.add(mainMenuJMenuAddCustomer);
        mainMenuJMenuCustomer.addSeparator();

        mainMenuJMenuViewCustomer = new JMenuItem("View Customers");
        mainMenuJMenuCustomer.add(mainMenuJMenuViewCustomer);
        mainMenuJMenuCustomer.addSeparator();
        mainMenuJMenuViewCustomer.addActionListener(this);

        mainMenuJMenuRemoveCustomer = new JMenuItem("Remove Customer");
        mainMenuJMenuCustomer.add(mainMenuJMenuRemoveCustomer);
        mainMenuJMenuCustomer.addActionListener(this);
        //GAMES JMENU
        mainMenuJMenuGames = new JMenu("Games");
        mainMenuJMenuBar.add(mainMenuJMenuGames);

        mainMenuJMenuAddGame = new JMenuItem("Add Game");
        mainMenuJMenuGames.add(mainMenuJMenuAddGame);
        mainMenuJMenuGames.addSeparator();
        mainMenuJMenuAddGame.addActionListener(this);

        mainMenuJMenuViewGames = new JMenuItem("View Games");
        mainMenuJMenuGames.add(mainMenuJMenuViewGames);
        mainMenuJMenuGames.addSeparator();
        mainMenuJMenuViewGames.addActionListener(this);

        mainMenuJMenuRemoveGame = new JMenuItem("Remove Game");
        mainMenuJMenuGames.add(mainMenuJMenuRemoveGame);
        mainMenuJMenuRemoveGame.addActionListener(this);
        //CUSTOMERS JMENU
        mainMenuJMenuEmployee = new JMenu("Employees");

        mainMenuJMenuAddEmployee = new JMenuItem("Add Employee");
        mainMenuJMenuEmployee.add(mainMenuJMenuAddEmployee);
        mainMenuJMenuEmployee.addSeparator();
        mainMenuJMenuAddEmployee.addActionListener(this);

        mainMenuJMenuViewEmployee = new JMenuItem("View Employees");
        mainMenuJMenuEmployee.add(mainMenuJMenuViewEmployee);
        mainMenuJMenuEmployee.addSeparator();
        mainMenuJMenuViewEmployee.addActionListener(this);

        mainMenuJMenuRemoveEmployee = new JMenuItem("Remove Employee");
        mainMenuJMenuEmployee.add(mainMenuJMenuRemoveEmployee);
        mainMenuJMenuRemoveEmployee.addActionListener(this);

        mainMenuJMenuBar.add(mainMenuJMenuEmployee);

    }
    public void displayClock(){
        clockLabel = new JLabel();
        clockLabel.setBounds(205,25,120,40);
        clockLabel.setFont(new Font("Arial",Font.BOLD,22));
        clockLabel.setForeground(new Color(51,153,255));
        gamePanel.add(clockLabel);

        dateLabel = new JLabel();
        dateLabel.setBounds(190,50,120,40);
        dateLabel.setFont(new Font("Arial",Font.BOLD,13));
        dateLabel.setForeground(new Color(51,153,255));
        gamePanel.add(dateLabel);
    }
    public void rentalClock(){

        while(true) {
            formatTime = new SimpleDateFormat("kk:mm:ss");
            clock = formatTime.format(Calendar.getInstance().getTime());
            formatDate = new SimpleDateFormat("dd MMMM yyyy");
            date = formatDate.format(Calendar.getInstance().getTime());

        try {
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
            GameRental.this.clockLabel.setText(clock);
            GameRental.this.dateLabel.setText(date);
        }

    }
    public void actionPerformed(ActionEvent e){


        String menuOption = e.getActionCommand();

        if(e.getSource() == this.mainMenuJMenuAddGame || e.getSource() == this.addGameButton)
        {
            addGame();
        }
        else if (e.getSource() == this.mainMenuJMenuRemoveGame || e.getSource() == this.removeGameButton)
        {
            removeGame();
        }
        else if(e.getSource() == this.mainMenuJMenuViewGames|| e.getSource() == this.viewGameButton)
        {
            displayGames();
        }
        else if(e.getSource() == this.mainMenuJMenuAddEmployee)
        {
            addEmployee();
        }
        else if(e.getSource() == this.mainMenuJMenuViewEmployee)
        {
            displayEmployees();
        }
        else if(e.getSource() == this.mainMenuJMenuRemoveEmployee)
        {
            removeEmployee();
        }

    }
}


