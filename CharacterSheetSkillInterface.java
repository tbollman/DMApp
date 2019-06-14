import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CharacterSheetSkillInterface extends JFrame {
    UserMan users = new UserMan();
    private JPanel contentPane;

    /*
     * Launch the application
     */
/*    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CharacterSheetSkillInterface frame = new CharacterSheetSkillInterface();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }*/

    /*
     * Create the frame
     */
    public CharacterSheetSkillInterface(UserMan u) {
        users = u;
        setTitle("Character Sheet Skill");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.CENTER);
        panel.setLayout(null);

        JLabel lblNewLabel = new JLabel("Skills");
        lblNewLabel.setBounds(149, 106, 56, 16);
        panel.add(lblNewLabel);

        JButton btnNewButton = new JButton("Go Back");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                CharacterSheetAbilityInterface characterSheetAbilityInterface = new CharacterSheetAbilityInterface(users);
            }
        });
        btnNewButton.setBounds(180, 191, 97, 25);
        panel.add(btnNewButton);
        setVisible(true);
    }
}
