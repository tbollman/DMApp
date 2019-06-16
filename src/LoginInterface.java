import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginInterface {

    public static UserMan users = new UserMan();
    private JFrame frame;

    /*
     * Launch the application
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    LoginInterface window = new LoginInterface();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /*
     * Create the application
     */
    public LoginInterface() {
    	users = new UserMan();
        users.read_file();
        initialize();
    }

    /*
     * Initialize the contents of the frame
     */
    private void initialize() {
        frame = new JFrame();
        frame.setTitle("D&D Mobile Companion");
        frame.setResizable(false);
        frame.setBounds(100, 100, 850, 630);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        try {
            final BufferedImage image = ImageIO.read(new File("./src/background.jpg"));
            JPanel panel = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.drawImage(image, 0, 0, null);
                }
            };
            frame.getContentPane().add(panel, BorderLayout.CENTER);

            JTextField usernameTextField = new JTextField();
            usernameTextField.setBounds(100, 356, 653, 41);
            usernameTextField.setFont(new Font("Arial", Font.PLAIN, 16));
            usernameTextField.setToolTipText("");
            usernameTextField.setColumns(10);

            JTextField passwordField = new JPasswordField();
            passwordField.setBounds(100, 443, 653, 41);
            passwordField.setFont(new Font("Arial", Font.PLAIN, 16));

            JButton loginButton = new JButton("Login");
            loginButton.setBounds(100, 497, 171, 26);
            loginButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                	boolean valid = false;
                	valid = users.login_attempt(usernameTextField.getText(), passwordField.getText());
                    if(valid) {
                        frame.dispose();
                        MainMenuInterface MainMenuInterface = new MainMenuInterface(users);
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "Login Failed!");
                    }
                }
            });
            loginButton.setForeground(Color.BLACK);
            loginButton.setBackground(Color.WHITE);
            loginButton.setFont(new Font("Algerian", Font.PLAIN, 18));

            JButton createAccountButton = new JButton("Create Account");
            createAccountButton.setBounds(529, 497, 224, 26);
            createAccountButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    frame.dispose();
                    CreateAccountInterface createAccountInterface = new CreateAccountInterface(users);
                }
            });
            createAccountButton.setForeground(Color.BLACK);
            createAccountButton.setBackground(Color.WHITE);
            createAccountButton.setFont(new Font("Algerian", Font.PLAIN, 18));

            JLabel usernameLabel = new JLabel("Username");
            usernameLabel.setBounds(100, 326, 109, 17);
            usernameLabel.setForeground(Color.BLACK);
            usernameLabel.setFont(new Font("Algerian", Font.BOLD, 18));

            JLabel passwordLabel = new JLabel("Password");
            passwordLabel.setBounds(100, 410, 109, 20);
            passwordLabel.setForeground(Color.BLACK);
            passwordLabel.setFont(new Font("Algerian", Font.BOLD, 18));
            panel.setLayout(null);
            panel.add(usernameLabel);
            panel.add(usernameTextField);
            panel.add(passwordLabel);
            panel.add(passwordField);
            panel.add(loginButton);
            panel.add(createAccountButton);
        } catch (IOException e) {
            e.printStackTrace();
        }
        setUIAppearance();
        frame.setVisible(true);
    }

    /*
     * Set the look and feel of the application to the system's look and feel
     */
    private void setUIAppearance() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch(ClassNotFoundException e) {
            e.printStackTrace();
        } catch(InstantiationException e) {
            e.printStackTrace();
        } catch(IllegalAccessException e) {
            e.printStackTrace();
        } catch(UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
    }
}