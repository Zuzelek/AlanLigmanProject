import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.*;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Map;

import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;


public class GameRental extends JFrame implements ActionListener {
    private String clock,date;
    private JFrame systemFrame;
    private JButton addGameButton, removeGameButton,viewGameButton, rentGame;
    private JPanel gamePanel;
    private JLabel logoImage;
    private JLabel clockLabel;
    private JLabel dateLabel;
    public JLabel nicknameLabel;
    private JMenuBar mainMenuJMenuBar;
    private JMenu mainMenuJMenuCustomer, mainMenuJMenuGames, mainMenuJMenuEmployee, mainMenuJMenuFiles;
    private JMenuItem mainMenuJMenuAddCustomer, mainMenuJMenuViewCustomer, mainMenuJMenuRemoveCustomer, mainMenuJMenuOpenFile, mainMenuJMenuSaveFile, mainMenuJMenuExit;
    private JMenuItem mainMenuJMenuAddGame, mainMenuJMenuViewGames, mainMenuJMenuRemoveGame;
    private JMenuItem mainMenuJMenuAddEmployee, mainMenuJMenuRemoveEmployee, mainMenuJMenuViewEmployee;
    Calendar calendar;
    SimpleDateFormat formatTime;
    SimpleDateFormat formatDate;

    MediaPlayer mediaPlayer;
    String backgroundSong = "src/backgroundMusic.mp3";
    JFXPanel fxPanel = new JFXPanel();
    private Game game;
    private Employee employee;
    private Customer customer;
    private Rent rent;

    ArrayList<Game> games = new ArrayList<>();
    ArrayList<Employee> employees = new ArrayList<>();
    ArrayList<Customer> customers = new ArrayList<>();

    public GameRental() {
        playAudio();
        systemFrame = new JFrame("Game System");

        systemFrame.setIconImage(new ImageIcon("src/syslogo.png").getImage());
        displayJMenu();


        gamePanel = new JPanel();
        gamePanel.setLayout(null);
        gamePanel.setBackground(Color.DARK_GRAY);

        clockLabel = new JLabel();
        clockLabel.setSize(100,30);
        clockLabel.setLocation(10,20);
        clockLabel.setBackground(Color.BLACK);
        gamePanel.add(clockLabel);
        displayClock();

        nicknameLabel = new JLabel("Welcome Back!");
        nicknameLabel.setSize(120,20);
        nicknameLabel.setFont(new Font("Arial",Font.BOLD,16));
        nicknameLabel.setForeground(new Color(255,51,51));
        nicknameLabel.setLocation(180,150);
        gamePanel.add(nicknameLabel);

        addGameButton = new JButton("Add Game");
        addGameButton.setMnemonic('A');
        addGameButton.setBackground(Color.LIGHT_GRAY);
        addGameButton.setBounds(15,25,15,25);
        addGameButton.setFont(new Font("Arial",Font.BOLD,13));
        addGameButton.setSize(125,50);
        addGameButton.setLocation(25,575);
        addGameButton.addActionListener(this);
        gamePanel.add(addGameButton);

        removeGameButton = new JButton("Remove Game");
        removeGameButton.setMnemonic(KeyEvent.VK_R);
        removeGameButton.setBackground(Color.LIGHT_GRAY);
        removeGameButton.setForeground(new Color(51,153,255));
        removeGameButton.setFont(new Font("Arial",Font.BOLD,13));
        removeGameButton.setBounds(175,575,135,50);
        removeGameButton.addActionListener(this);
        gamePanel.add(removeGameButton);

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

        rentGame = new JButton("Rent a Game");
        rentGame.setBounds(100,500,125,50);
        gamePanel.add(rentGame);
        rentGame.addActionListener(this);

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
        int i;

        boolean valid;
        while(!firstName.equals(""))
        {
            valid = false;
            while(!valid)
            {
                String lastName = JOptionPane.showInputDialog("Please enter your last name");
                String password = JOptionPane.showInputDialog("Please enter a password");
                String emailAddress = JOptionPane.showInputDialog("Please enter your Email Address");
                String address = JOptionPane.showInputDialog("Please enter your address");
                String phoneNumber = JOptionPane.showInputDialog("Please enter your phone number EG. 1234567890");
                String dateOfBirth = JOptionPane.showInputDialog("Please enter your date of Birth in the format of DD/MM/YYYY");

                if(!lastName.equals(""))
                {
                    if(password.length() >= 8 && password.length() <= 15)
                    {
                        if(phoneNumber.length() == 10)
                        {
                            if(dateOfBirth.length() == 12)
                            {
                                if(Character.isDigit(dateOfBirth.charAt(0)) && (Character.isDigit(dateOfBirth.charAt(1))) && dateOfBirth.charAt(2) == '/'
                                && (Character.isDigit(dateOfBirth.charAt(3))) && Character.isDigit(dateOfBirth.charAt(4))
                                && dateOfBirth.charAt(5) == '/' && Character.isDigit(dateOfBirth.charAt(6)) && Character.isDigit(dateOfBirth.charAt(7))
                                && Character.isDigit(dateOfBirth.charAt(8)) && Character.isDigit(dateOfBirth.charAt(9)))
                                {
                                    for (i = 0; i < address.length(); i++)
                                        break;
                                    if (Character.isDigit(phoneNumber.charAt(i))) {
                                        this.customer = new Customer(firstName, lastName, emailAddress, address, phoneNumber, dateOfBirth, password);
                                        JOptionPane.showMessageDialog(null, "Customer: " + firstName + " has been added to the system", "Customer Added", JOptionPane.INFORMATION_MESSAGE);
                                        valid = true;
                                    } else
                                        phoneNumber = JOptionPane.showInputDialog("Phone number must be numeric, please re-enter");
                                }
                                else
                                    dateOfBirth = JOptionPane.showInputDialog("Date of birth must be in the format DD/MM/YYYY, please re-enter");
                            }
                            else
                                dateOfBirth = JOptionPane.showInputDialog("Date of Birth must be 12 characters in length and in the format of DD/MM/YYYY, please re-enter");
                        }
                        else
                            phoneNumber = JOptionPane.showInputDialog("Phone number must be 10 in length, please re-enter");
                    }
                    else
                        password = JOptionPane.showInputDialog("Password must be between 8 and 15 characters, please re-enter");
                }
                else
                    lastName = JOptionPane.showInputDialog("Last name cannot be empty, please re-enter");
            }
            break;
        }
        this.customers.add(this.customer);
    }
    public void displayCustomer(){
        JComboBox customersComboBox = new JComboBox();
        JTextArea customerResults = new JTextArea();
        customerResults.append("The following customers have been found in the system:\n\n");
        try{
            if(this.customers.size() < 1){
                JOptionPane.showMessageDialog(null,"No customers have been found in the system, please load a file","Error, no customers found",JOptionPane.ERROR_MESSAGE);
            }else{
                Iterator<Customer> customerIterator = this.customers.iterator(); {
                    while(customerIterator.hasNext())
                        customersComboBox.addItem(((Customer) customerIterator.next()).getFirstName() + "\n");
                    JOptionPane.showMessageDialog(null, customersComboBox,"Customer Details",JOptionPane.INFORMATION_MESSAGE);

                    int comboBoxSelection = customersComboBox.getSelectedIndex();
                    customerResults.append(((Customer) this.customers.get(comboBoxSelection)).toString());
                    JOptionPane.showMessageDialog(null,customerResults,"Customer Details",JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Customer details could not be loaded", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
    public void removeCustomer(){
        JComboBox customerList = new JComboBox();
        for(Customer c : this.customers)
            customerList.addItem(c.getFirstName());
        if(this.customers.size() < 1){
            JOptionPane.showMessageDialog(null,"No customers have been found in the system","Customers not found",JOptionPane.ERROR_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null,"Please select a customer you wish to remove\n\n","Remove Customer",JOptionPane.QUESTION_MESSAGE);
            JOptionPane.showMessageDialog(null,customerList,"Remove Customer",JOptionPane.INFORMATION_MESSAGE);
            int customerSelect = customerList.getSelectedIndex();
            this.customers.remove(customerSelect);
            JOptionPane.showMessageDialog(null,"Selected customer has been removed","Remove Customer",JOptionPane.INFORMATION_MESSAGE);
        }
    }
    public void addEmployee()
    {
        String firstName = JOptionPane.showInputDialog("Please enter employees first name");
        String lastName = JOptionPane.showInputDialog("Please enter employees last name");
        int i;
        boolean valid;
        while(!firstName.equals(""))
        {
            valid = false;
            while(!valid)
            {
                for (i = 0; i < firstName.length(); i++)
                    break;
                        if (!Character.isDigit(firstName.charAt(i)))
                        {
                                for (i = 0; i < lastName.length(); i++)
                                    break;
                                if (!Character.isDigit(lastName.charAt(i)))
                                {
                                    this.employee = new Employee(firstName,lastName);
                                    JOptionPane.showMessageDialog(null,"Employee: "+firstName+" has been added to the system","Employee Added",JOptionPane.INFORMATION_MESSAGE);
                                    valid = true;
                                    continue;
                                } else
                                    firstName = JOptionPane.showInputDialog("First name must be numeric, please re-enter");
                        } else
                            lastName = JOptionPane.showInputDialog("Last name must be numeric , please re-enter");
            }
            break;
        }
        //ADD TO ARRAY LIST
        this.employees.add(this.employee);
    }
    public void displayEmployees(){
        JComboBox<String> employeeComboBox = new JComboBox<>();
        JTextArea employeeResults = new JTextArea();
        employeeResults.setText("Employees found in the system\n\n");
        try{
            if(this.employees.size() < 1){
                JOptionPane.showMessageDialog(null,"No employees have been found in the system. Please 'Open' the file.","Error, no employees found",JOptionPane.ERROR_MESSAGE);
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
        String gamePrice = JOptionPane.showInputDialog("Please enter the price of the game (€00.00 or €0.00)");
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
                            if (gamePrice.length() == 2 || gamePrice.length() == 5 && gamePrice.charAt(2) == '.' || gamePrice.length() == 4 && gamePrice.charAt(1) == '.') {
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
                                gamePrice = JOptionPane.showInputDialog("Game price must be in the form of (€00.00 or €0.00), please re-enter");
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
                JOptionPane.showMessageDialog(null, "No games have been found in the system. Please load a file", "Error, no games found", JOptionPane.ERROR_MESSAGE);
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

        mainMenuJMenuFiles = new JMenu("File");
        mainMenuJMenuBar.add(mainMenuJMenuFiles);

        mainMenuJMenuSaveFile = new JMenuItem("Save File");
        mainMenuJMenuFiles.addSeparator();
        mainMenuJMenuFiles.add(mainMenuJMenuSaveFile);
        mainMenuJMenuSaveFile.addActionListener(this);

        mainMenuJMenuOpenFile = new JMenuItem("Open File");
        mainMenuJMenuFiles.addSeparator();
        mainMenuJMenuFiles.add(mainMenuJMenuOpenFile);
        mainMenuJMenuOpenFile.addActionListener(this);

        mainMenuJMenuExit = new JMenuItem("Exit");
        mainMenuJMenuFiles.addSeparator();
        mainMenuJMenuFiles.add(mainMenuJMenuExit);
        mainMenuJMenuExit.addActionListener(this);

        mainMenuJMenuCustomer = new JMenu("Customers");
        mainMenuJMenuBar.add(mainMenuJMenuCustomer);

        mainMenuJMenuAddCustomer = new JMenuItem("Add Customer");
        mainMenuJMenuCustomer.add(mainMenuJMenuAddCustomer);
        mainMenuJMenuCustomer.addSeparator();
        mainMenuJMenuAddCustomer.addActionListener(this);

        mainMenuJMenuViewCustomer = new JMenuItem("View Customers");
        mainMenuJMenuCustomer.add(mainMenuJMenuViewCustomer);
        mainMenuJMenuCustomer.addSeparator();
        mainMenuJMenuViewCustomer.addActionListener(this);

        mainMenuJMenuRemoveCustomer = new JMenuItem("Remove Customer");
        mainMenuJMenuCustomer.add(mainMenuJMenuRemoveCustomer);
        mainMenuJMenuRemoveCustomer.addActionListener(this);

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
    public void saveSystem() throws IOException {
        FileOutputStream employeeOut = new FileOutputStream("EmployeeDetails.ser");
        ObjectOutputStream employeeOutStream = new ObjectOutputStream(employeeOut);
        employeeOutStream.writeObject(this.employees);
        employeeOut.close();

        FileOutputStream customerOut = new FileOutputStream("CustomerDetails.ser");
        ObjectOutputStream customerOutStream = new ObjectOutputStream(customerOut);
        customerOutStream.writeObject(this.customers);
        customerOut.close();

        FileOutputStream gameOut = new FileOutputStream("GameDetails.ser");
        ObjectOutputStream gameOutStream = new ObjectOutputStream(gameOut);
        gameOutStream.writeObject(this.games);
        gameOut.close();

        JOptionPane.showMessageDialog(null,"All Details have been saved!","Saved",JOptionPane.INFORMATION_MESSAGE);
    }
    public void openSystem() throws IOException, ClassNotFoundException {
        FileInputStream employeeIn = new FileInputStream("EmployeeDetails.ser");
        ObjectInputStream employeeInStream = new ObjectInputStream(employeeIn);
        this.employees = (ArrayList<Employee>) employeeInStream.readObject();
        employeeIn.close();
        employeeInStream.close();

        FileInputStream customerIn = new FileInputStream("CustomerDetails.ser");
        ObjectInputStream customerInStream = new ObjectInputStream(customerIn);
        this.customers = (ArrayList<Customer>) customerInStream.readObject();
        customerIn.close();
        customerInStream.close();

        FileInputStream gameIn = new FileInputStream("GameDetails.ser");
        ObjectInputStream gameInStream = new ObjectInputStream(gameIn);
        this.games = (ArrayList<Game>) gameInStream.readObject();
        gameIn.close();
        gameInStream.close();

        JOptionPane.showMessageDialog(null,"All Details have been loaded onto the system","Files Loaded",JOptionPane.INFORMATION_MESSAGE);
    }

    public void playAudio(){
        try {
            Media media = new Media(Paths.get(backgroundSong).toUri().toString());
            mediaPlayer = new MediaPlayer(media);
            mediaPlayer.play();
        }catch (Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"File "+backgroundSong+" could not be found","MP3 Error",JOptionPane.ERROR_MESSAGE);
        }
    }

    public void borrowGame(String gameTitle){
        for(Game g : this.games){
            if(g.getTitle().equals(gameTitle)){
                if(g.isBorrowed())
                    JOptionPane.showMessageDialog(null,"Game borrowed","Borrowed",JOptionPane.INFORMATION_MESSAGE);
            }
            else{
                JOptionPane.showMessageDialog(null,"This game cannot be borrowed at this time, please try-again later.","Error",JOptionPane.WARNING_MESSAGE);
            }
        }
    }
    public void returnGame(String gameTitle){
        for(Game g : this.games){
            if(g.getTitle().equals(gameTitle)){
                if(g.isReturned()){
                    JOptionPane.showMessageDialog(null,"Game has been returned","Returned",JOptionPane.INFORMATION_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(null,"Game cannot be returned at this moment","Return Error",JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }
    public void actionPerformed(ActionEvent e){

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
        else if(e.getSource() == this.mainMenuJMenuAddCustomer)
        {
            addCustomer();
        }
        else if(e.getSource() == this.mainMenuJMenuViewCustomer)
        {
            displayCustomer();
        }
        else if(e.getSource() == this.mainMenuJMenuRemoveCustomer)
        {
            removeCustomer();
        }
        else if(e.getSource() == this.mainMenuJMenuSaveFile)
        {
            try {
                saveSystem();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
        else if(e.getSource() == this.mainMenuJMenuOpenFile)
        {
            try {
                openSystem();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            } catch (ClassNotFoundException ex) {
                throw new RuntimeException(ex);
            }
        }
        else if(e.getSource() == this.mainMenuJMenuExit)
        {
            JOptionPane.showMessageDialog(null,"Goodbye!");
            System.exit(0);
        }
        else if(e.getSource() == this.rentGame)
        {
            //findEmployee();
            //int name = binarySearch()
        }
    }
}


