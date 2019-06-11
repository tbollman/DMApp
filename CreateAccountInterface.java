import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CreateAccountInterface extends JFrame {

    public static UserMan users = new UserMan();
    private JPanel contentPane;
    private JTextField usernameTextField;
    private JTextField passwordTextField;

    /*
     * Launch the application
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CreateAccountInterface frame = new CreateAccountInterface();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /*
     * Create the frame
     */
    public CreateAccountInterface() {
        users.read_file();
        setTitle("Create Account");
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

        usernameTextField = new JTextField();
        usernameTextField.setBounds(143, 173, 600, 40);
        panel.add(usernameTextField);
        usernameTextField.setColumns(10);

        JComboBox accountTypeComboBox = new JComboBox();
        accountTypeComboBox.setMaximumRowCount(3);
        accountTypeComboBox.setBounds(175, 332, 130, 22);
        panel.add(accountTypeComboBox);
        accountTypeComboBox.addItem(new String("1. Player"));
        accountTypeComboBox.addItem(new String("2. Dungeon Master"));
        accountTypeComboBox.addItem(new String("3. Administrator"));

        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setForeground(Color.RED);
        passwordLabel.setFont(new Font("Algerian", Font.BOLD, 16));
        passwordLabel.setBounds(40, 260, 91, 16);
        panel.add(passwordLabel);

        passwordTextField = new JTextField();
        passwordTextField.setColumns(10);
        passwordTextField.setBounds(143, 248, 600, 40);
        panel.add(passwordTextField);

        JLabel accountTypeLabel = new JLabel("Account Type");
        accountTypeLabel.setForeground(Color.RED);
        accountTypeLabel.setFont(new Font("Algerian", Font.BOLD, 16));
        accountTypeLabel.setBounds(40, 335, 123, 16);
        panel.add(accountTypeLabel);

        JButton confirmButton = new JButton("Confirm");
        confirmButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                if (users.create_account(usernameTextField.getText(), accountTypeComboBox.getSelectedIndex(), passwordTextField.getText())) {
                    dispose();
                    LoginInterface loginInterface = new LoginInterface();
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
    }
}