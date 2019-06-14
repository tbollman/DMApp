import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainMenuInterface extends JFrame {
    UserMan users = new UserMan();
    private JFrame frame;
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
        users.read_characters();
        //System.out.println("Username: "+ users.characters.get(0).getUsername() + " Character Name: " + users.characters.get(0).getCharacterName());
        frame = new JFrame();
        setTitle("Main Menu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 797, 543);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.CENTER);
        panel.setLayout(null);

        JButton btnNewButton = new JButton("New button");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                CharacterSheetAbilityInterface characterSheetAbilityInterface = new CharacterSheetAbilityInterface(users);
                characterSheetAbilityInterface.setVisible(true);
            }
        });
        btnNewButton.setBounds(44, 51, 97, 25);
        panel.add(btnNewButton);

        JButton btnNewButton_1 = new JButton("New button");
        btnNewButton_1.setBounds(260, 51, 97, 25);
        panel.add(btnNewButton_1);
        setVisible(true);
    }

}
