import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.Color;
import javax.swing.JComboBox;

public class CharacterSheetSkillInterface extends JFrame {
	
	public UserMan users = new UserMan();
	
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
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        JPanel panel = new JPanel();
        panel.setBackground(Color.BLACK);
        contentPane.add(panel, BorderLayout.CENTER);
        panel.setLayout(null);

        JLabel lblNewLabel = new JLabel("Skills");
        lblNewLabel.setForeground(Color.RED);
        lblNewLabel.setFont(new Font("Algerian", Font.PLAIN, 18));
        lblNewLabel.setBounds(185, 11, 58, 16);
        panel.add(lblNewLabel);

        JButton abilitiesButton = new JButton("Abilities");
        abilitiesButton.setFont(new Font("Algerian", Font.PLAIN, 16));
        abilitiesButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                CharacterSheetAbilityInterface characterSheetAbilityInterface = new CharacterSheetAbilityInterface(users);
            }
        });
        abilitiesButton.setBounds(299, 215, 115, 25);
        panel.add(abilitiesButton);
        
        JTextArea skillsTextArea = new JTextArea();
        skillsTextArea.setFont(new Font("Monospaced", Font.PLAIN, 16));
        skillsTextArea.setBounds(10, 29, 404, 175);
        panel.add(skillsTextArea);
        
        JButton mainMenuButton = new JButton("Main Menu");
        mainMenuButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
        		MainMenuInterface mainMenuInterface = new MainMenuInterface(users);
        	}
        });
        mainMenuButton.setFont(new Font("Algerian", Font.PLAIN, 16));
        mainMenuButton.setBounds(10, 217, 140, 25);
        panel.add(mainMenuButton);
        
        JComboBox characterComboBox = new JComboBox();
        characterComboBox.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		int index = characterComboBox.getSelectedIndex();
        	}
        });
        characterComboBox.setFont(new Font("Arial", Font.PLAIN, 14));
        characterComboBox.setBounds(162, 217, 125, 20);
        panel.add(characterComboBox);
        if(characterComboBox.getItemCount() == 0) {
	        for(int i = 0; i < users.owned_characters.size(); i++) {
	        	characterComboBox.addItem(new String(users.owned_characters.get(i).getCharacterName()));
	        }
        }
        System.out.println(users.owned_characters.size());
        characterComboBox.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		int index = characterComboBox.getSelectedIndex();
        		if(index != -1) {
                	for(int i = 0; i < 24; i++) {
                		skillsTextArea.append(users.owned_characters.get(index).getSkillName(i) + ": " + users.owned_characters.get(index).getSkillModifier(i) + "\n");
                	}
        		}
        	}
        });
        JScrollPane sp = new JScrollPane(skillsTextArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		sp.setBounds(10, 29, 404, 175);
		panel.add(sp);
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