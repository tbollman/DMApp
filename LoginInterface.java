import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginInterface {

    public static UserMan users = new UserMan();
    private JFrame frame;
    private JTextField usernameTextField;
    private JPasswordField passwordField;

    /*
     * Launch the application
     */
    public static void main(String[] args) {
        users.read_file();
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
        initialize();
    }

    /*
     * Initialize the contents of the frame
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 850, 730);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        try {
            final BufferedImage image = ImageIO.read(new File("./src/background.jpeg"));
            JPanel panel = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.drawImage(image, 0, 0, null);
                }
            };
            frame.getContentPane().add(panel, BorderLayout.CENTER);

            usernameTextField = new JTextField();
            usernameTextField.setFont(new Font("Arial", Font.PLAIN, 16));
            usernameTextField.setToolTipText("");
            usernameTextField.setColumns(10);

            passwordField = new JPasswordField();
            passwordField.setFont(new Font("Arial", Font.PLAIN, 16));

            JButton loginButton = new JButton("Login");
            loginButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    boolean valid = users.login_attempt(usernameTextField.getText(), passwordField.getText());
                    if(valid) {
                        frame.dispose();
                        MainMenuInterface MainMenuInterface = new MainMenuInterface();
                    }
                    //mainMenuInterface.setVisible(true);
//	        		characterSheetInterface.setTitle("Character Sheet");
//	        		characterSheetFrame.setBounds(100, 100, 850, 730);
//	        		characterSheetFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//	        		JPanel characterSheetPanel = new JPanel();
//	        		characterSheetFrame.getContentPane().add(characterSheetPanel, BorderLayout.CENTER);
//	        		characterSheetPanel.setLayout(null);
//	        		JButton submitButton = new JButton("Submit");
//	        		submitButton.addActionListener(new ActionListener() {
//	        			public void actionPerformed(ActionEvent arg0) {
//	        				frame.setVisible(true);
//	        				characterSheetFrame.setVisible(false);
//	        			}
//	        		});
//	        		submitButton.setBounds(300, 50, 97, 25);
//	        		characterSheetPanel.add(submitButton);
//	        		characterSheetFrame.setVisible(true);
                }
            });
            loginButton.setForeground(Color.BLACK);
            loginButton.setBackground(Color.ORANGE);
            loginButton.setFont(new Font("Algerian", Font.PLAIN, 18));

            JButton createAccountButton = new JButton("Create Account");
            createAccountButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    frame.dispose();
                    CreateAccountInterface createAccountInterface = new CreateAccountInterface();
                    createAccountInterface.setVisible(true);
//	        		createAccountFrame.setTitle("Create Account");
//	        		createAccountFrame.setBounds(100, 100, 1105, 782);
//	        		JPanel characterSheetPanel = new JPanel();
//	        		createAccountFrame.getContentPane().add(characterSheetPanel, BorderLayout.CENTER);
//	        		characterSheetPanel.setLayout(null);
//	        		JButton submitButton = new JButton("Submit");
//	        		submitButton.addActionListener(new ActionListener() {
//	        			public void actionPerformed(ActionEvent arg0) {
//	        				frame.setVisible(true);
//	        				createAccountFrame.setVisible(false);
//	        			}
//	        		});
//	        		submitButton.setBounds(300, 50, 97, 25);
//	        		characterSheetPanel.add(submitButton);
//	        		createAccountFrame.setVisible(true);
                }
            });
            createAccountButton.setForeground(Color.BLACK);
            createAccountButton.setBackground(Color.ORANGE);
            createAccountButton.setFont(new Font("Algerian", Font.PLAIN, 18));

            JLabel usernameLabel = new JLabel("Username");
            usernameLabel.setForeground(Color.ORANGE);
            usernameLabel.setFont(new Font("Algerian", Font.BOLD, 18));

            JLabel lblPassword = new JLabel("Password");
            lblPassword.setForeground(Color.ORANGE);
            lblPassword.setFont(new Font("Algerian", Font.BOLD, 18));
            GroupLayout gl_panel = new GroupLayout(panel);
            gl_panel.setHorizontalGroup(
                    gl_panel.createParallelGroup(Alignment.LEADING)
                            .addGroup(gl_panel.createSequentialGroup()
                                    .addGap(100)
                                    .addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
                                            .addGroup(gl_panel.createSequentialGroup()
                                                    .addComponent(usernameLabel, GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                                                    .addGap(544))
                                            .addComponent(usernameTextField, GroupLayout.DEFAULT_SIZE, 651, Short.MAX_VALUE)
                                            .addGroup(gl_panel.createSequentialGroup()
                                                    .addComponent(lblPassword, GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                                                    .addGap(544))
                                            .addComponent(passwordField, GroupLayout.DEFAULT_SIZE, 651, Short.MAX_VALUE)
                                            .addGroup(gl_panel.createSequentialGroup()
                                                    .addComponent(loginButton, GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                                                    .addGap(300)
                                                    .addComponent(createAccountButton, GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)))
                                    .addGap(81))
            );
            gl_panel.setVerticalGroup(
                    gl_panel.createParallelGroup(Alignment.LEADING)
                            .addGroup(gl_panel.createSequentialGroup()
                                    .addGap(326)
                                    .addComponent(usernameLabel, GroupLayout.PREFERRED_SIZE, 16, Short.MAX_VALUE)
                                    .addGap(13)
                                    .addComponent(usernameTextField, GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                                    .addGap(13)
                                    .addComponent(lblPassword, GroupLayout.PREFERRED_SIZE, 16, Short.MAX_VALUE)
                                    .addGap(13)
                                    .addComponent(passwordField, GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                                    .addGap(13)
                                    .addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
                                            .addComponent(loginButton, GroupLayout.PREFERRED_SIZE, 25, Short.MAX_VALUE)
                                            .addComponent(createAccountButton, GroupLayout.PREFERRED_SIZE, 25, Short.MAX_VALUE))
                                    .addGap(168))
            );
            panel.setLayout(gl_panel);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        setUIAppearance();
    }

    /*
     * Set the look and feel of the application to the system's look and feel
     */
    private void setUIAppearance()
    {
        try
        {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch(ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        catch(InstantiationException e)
        {
            e.printStackTrace();
        }
        catch(IllegalAccessException e)
        {
            e.printStackTrace();
        }
        catch(UnsupportedLookAndFeelException e)
        {
            e.printStackTrace();
        }
    }
}