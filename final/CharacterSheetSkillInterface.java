import java.awt.BorderLayout;
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

/**
 * The CharacterSheetSkillInterface creates the graphical user interface that users can use to view the skills of their characters.
 * 
 * @author Noah Shaw
 * @see JFrame
 */
public class CharacterSheetSkillInterface extends JFrame {
	
    /**
    * An instance of UserMan that manages the user(s).
    */
    private UserMan users;
    /**
     * A container that contains all JavaSwing components.
     */
    private JPanel contentPane;

    /**
     * Initializes the frame and adds every component to the frame. A constructor for CharacterSheetSkillInterface.
     * 
     * @param	u	the active instance of UserMan that manages the current user(s)
     * @see		UserMan
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

        // Go to the abilities screen.
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
        
        // Go to the main menu.
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
        
        JComboBox<String> characterComboBox = new JComboBox<String>();
        characterComboBox.setFont(new Font("Arial", Font.PLAIN, 14));
        characterComboBox.setBounds(162, 217, 125, 20);
        panel.add(characterComboBox);
        // Add each of the user's owned characters to the combo box.
        if (characterComboBox.getItemCount() == 0)
	        for (int i = 0; i < users.ownedCharacters.size(); i++)
	        	characterComboBox.addItem(new String(users.ownedCharacters.get(i).getCharacterName()));
        // For the selected character, display all of their skills.
        characterComboBox.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		int index = characterComboBox.getSelectedIndex();
        		if (index != -1)
                	for (int i = 0; i < 24; i++)
                		skillsTextArea.append(users.ownedCharacters.get(index).getSkillName(i) + ": " + users.ownedCharacters.get(index).getSkill(i) + "\n");
        	}
        });
        
        JScrollPane sp = new JScrollPane(skillsTextArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	sp.setBounds(10, 29, 404, 175);
	panel.add(sp);
		
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
