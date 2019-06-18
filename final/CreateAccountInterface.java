import java.awt.BorderLayout;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * The CreateAccountInterface creates the graphical user interface that users can use to create a new account.
 * 
 * @author Noah Shaw
 * @see JFrame
 */
public class CreateAccountInterface extends JFrame {

    /**
    * An instance of UserMan that manages the user(s).
    */
    private UserMan users;
    /**
     * A container that contains all JavaSwing components.
     */
    private JPanel contentPane;

    /**
     * Initializes the frame and adds every component to the frame. A constructor for CreateAccountInterface.
     * 
     * @param	u	the active instance of UserMan that manages the current user(s)
     * @see		UserMan
     */
    public CreateAccountInterface(UserMan u) {
    	users = u;
        setTitle("Create Account");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 876, 532);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        JPanel panel = new JPanel();
        panel.setBackground(Color.BLACK);
        contentPane.add(panel, BorderLayout.CENTER);
        panel.setLayout(null);

        JLabel usernameLabel = new JLabel("Username");
        usernameLabel.setForeground(Color.RED);
        usernameLabel.setFont(new Font("Algerian", Font.BOLD, 16));
        usernameLabel.setBounds(40, 185, 91, 16);
        panel.add(usernameLabel);

        JTextField usernameTextField = new JTextField();
        usernameTextField.setFont(new Font("Arial", Font.PLAIN, 16));
        usernameTextField.setBounds(143, 173, 600, 40);
        panel.add(usernameTextField);
        usernameTextField.setColumns(10);

        JComboBox<String> accountTypeComboBox = new JComboBox<String>();
        accountTypeComboBox.setFont(new Font("Arial", Font.PLAIN, 14));
        accountTypeComboBox.setMaximumRowCount(3);
        accountTypeComboBox.setBounds(175, 332, 130, 22);
        panel.add(accountTypeComboBox);
        accountTypeComboBox.addItem(new String("Player"));
        accountTypeComboBox.addItem(new String("Dungeon Master"));
        accountTypeComboBox.addItem(new String("Administrator"));

        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setForeground(Color.RED);
        passwordLabel.setFont(new Font("Algerian", Font.BOLD, 16));
        passwordLabel.setBounds(40, 260, 91, 16);
        panel.add(passwordLabel);

        JTextField passwordTextField = new JTextField();
        passwordTextField.setFont(new Font("Arial", Font.PLAIN, 16));
        passwordTextField.setColumns(10);
        passwordTextField.setBounds(143, 248, 600, 40);
        panel.add(passwordTextField);

        JLabel accountTypeLabel = new JLabel("Account Type");
        accountTypeLabel.setForeground(Color.RED);
        accountTypeLabel.setFont(new Font("Algerian", Font.BOLD, 16));
        accountTypeLabel.setBounds(40, 335, 123, 16);
        panel.add(accountTypeLabel);
        
        // Go to the login screen if account creation is successful.
        JButton confirmButton = new JButton("Confirm");
        confirmButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                if (users.create_account(usernameTextField.getText(), accountTypeComboBox.getSelectedIndex(), passwordTextField.getText())) {
                    dispose();
                    LoginInterface loginInterface = new LoginInterface();
                } else {
                    JOptionPane.showMessageDialog(null, "Username already exists!");
                }
            }
        });
        confirmButton.setFont(new Font("Algerian", Font.BOLD, 16));
        confirmButton.setBounds(369, 437, 116, 25);
        panel.add(confirmButton);

        JLabel createNewAccountLabel = new JLabel("Create New Account");
        createNewAccountLabel.setFont(new Font("Algerian", Font.BOLD, 70));
        createNewAccountLabel.setForeground(Color.ORANGE);
        createNewAccountLabel.setBounds(12, 13, 824, 160);
        panel.add(createNewAccountLabel);
        
        setUIAppearance();
        setVisible(true);
    }
    
    /**
     * Sets the look and feel of the application to the system's look and feel.
     */
    private void setUIAppearance() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
    }
}
