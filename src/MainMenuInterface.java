import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class MainMenuInterface extends JFrame {
	
	UserMan users = new UserMan();
    private JPanel contentPane;

    /*
     * Launch the application
     */
/*    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MainMenuInterface window = new MainMenuInterface();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }*/

    /*
     * Create the frame
     */
    public MainMenuInterface(UserMan u) {
    	users = u;
    	System.out.println(users.owned_character_count);
    	if(users.characters.size() == 0) {
    		users.read_characters();
    	}
        setTitle("Main Menu");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 797, 543);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        JPanel panel = new JPanel();
        panel.setBackground(Color.GRAY);
        contentPane.add(panel, BorderLayout.CENTER);
        panel.setLayout(null);

        JButton abilitiesButton = new JButton("Abilities");
        abilitiesButton.setFont(new Font("Algerian", Font.PLAIN, 16));
        abilitiesButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                CharacterSheetAbilityInterface characterSheetAbilityInterface = new CharacterSheetAbilityInterface(users);
            }
        });
        abilitiesButton.setBounds(10, 51, 751, 25);
        panel.add(abilitiesButton);

        JButton skillsButton = new JButton("Skills");
        skillsButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		dispose();
        		CharacterSheetSkillInterface characterSheetSkillInterface = new CharacterSheetSkillInterface(users);
        	}
        });
        skillsButton.setFont(new Font("Algerian", Font.PLAIN, 16));
        skillsButton.setBounds(10, 117, 751, 25);
        panel.add(skillsButton);
        
        JButton updatePasswordButton = new JButton("Update Password");
        updatePasswordButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String currentPassword = JOptionPane.showInputDialog(null, "Enter your current password.");
        		String newPassword = JOptionPane.showInputDialog(null, "Enter your new password.");
        		users.change_password(newPassword, currentPassword);
        	}
        });
        updatePasswordButton.setFont(new Font("Algerian", Font.PLAIN, 16));
        updatePasswordButton.setBounds(10, 183, 751, 25);
        panel.add(updatePasswordButton);
        
        JButton logoutButton = new JButton("Logout");
        logoutButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
        		users.logged_in = false;
        		LoginInterface loginInterface = new LoginInterface();
        	}
        });
        logoutButton.setFont(new Font("Algerian", Font.PLAIN, 16));
        logoutButton.setBounds(10, 251, 751, 25);
        panel.add(logoutButton);
        setUIAppearance();
        setVisible(true);
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