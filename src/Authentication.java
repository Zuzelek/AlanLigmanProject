import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Authentication extends JFrame implements ActionListener {
    private JPanel authenticationPanel;
    private JLabel username, password, welcome;
    private JTextField userText;
    private JPasswordField passwordText;
    private JButton login,close;
    public Authentication(){
        this.setTitle("Authentication");
        this.setSize(400,250);

        this.setLocationRelativeTo(null);
        this.setResizable(false);

        authenticationPanel = new JPanel();
        this.add(authenticationPanel);
        authenticationPanel.setLayout(null);

        Font welcomeFont = new Font("Aharoni",Font.BOLD, 13);

        welcome = new JLabel("Welcome to the System! \nPlease login to proceed.");
        welcome.setFont(welcomeFont);
        welcome.setBounds(35,5,350,20);
        authenticationPanel.add(welcome);

        username = new JLabel("User:");
        username.setBounds(85,35,100,30);
        authenticationPanel.add(username);

        userText = new JTextField();
        userText.setBounds(150,45,150,20);
        authenticationPanel.add(userText);

        password = new JLabel("Password:");
        password.setBounds(85,70,100,30);
        authenticationPanel.add(password);

        passwordText = new JPasswordField();
        passwordText.setBounds(150,75,150,20);
        authenticationPanel.add(passwordText);

        login = new JButton("Login");
        login.setBounds(175,110,75,25);
        authenticationPanel.add(login);
        login.addActionListener(this);

        close = new JButton("Close");

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
            if (e.getSource() == this.login || e.getSource() == this.username || e.getSource() == passwordText || e.getSource() == userText) {
                String user = userText.getText();
                String pass = passwordText.getText();

                if(!user.equals("") && !pass.equals(""))
                {
                    JOptionPane.showMessageDialog(null,"Welcome back "+user);
                    GameRental rentalStart = new GameRental();
                    rentalStart.setVisible(true);
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"The login or password you have entered is invalid, try-again.","Invalid Credentials",JOptionPane.ERROR_MESSAGE);
                    this.username.requestFocus();
                    this.username.setText("");
                    this.passwordText.setText("");
                }



        }
    }
}
