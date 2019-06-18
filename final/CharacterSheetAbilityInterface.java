import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
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
 * The CharacterSheetAbilityInterface creates the graphical user interface that users can use to view the abilities of their characters.
 * 
 * @author Noah Shaw
 * @see JFrame
 */
public class CharacterSheetAbilityInterface extends JFrame {
    /**
    * An instance of UserMan that manages the user(s).
    */
    private UserMan users;
    /**
     * A container that contains all JavaSwing components.
     */
    private JPanel contentPane;

    /**
     * Initializes the frame and adds every component to the frame. A constructor for CharacterSheetAbilityInterface.
     * 
     * @param	u	the active instance of UserMan that manages the current user(s)
     * @see		UserMan
     */
    public CharacterSheetAbilityInterface(UserMan u) {
    	users = u;
        setTitle("Character Sheet Ability");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 954, 558);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        JPanel panel = new JPanel();
        panel.setBackground(Color.BLACK);
        panel.setForeground(Color.WHITE);
        contentPane.add(panel, BorderLayout.CENTER);
        panel.setLayout(null);

        JLabel HPLabel = new JLabel("HP");
        HPLabel.setForeground(Color.RED);
        HPLabel.setFont(new Font("Algerian", Font.BOLD, 18));
        HPLabel.setBounds(172, 15, 24, 16);
        panel.add(HPLabel);

        JLabel levelLabel = new JLabel("Level");
        levelLabel.setForeground(Color.RED);
        levelLabel.setFont(new Font("Algerian", Font.BOLD, 18));
        levelLabel.setBounds(12, 15, 58, 16);
        panel.add(levelLabel);

        JLabel initiativeLabel = new JLabel("Initiative");
        initiativeLabel.setForeground(Color.RED);
        initiativeLabel.setFont(new Font("Algerian", Font.BOLD, 18));
        initiativeLabel.setBounds(12, 415, 101, 16);
        panel.add(initiativeLabel);

        JLabel ACLabel = new JLabel("AC");
        ACLabel.setForeground(Color.RED);
        ACLabel.setFont(new Font("Algerian", Font.BOLD, 18));
        ACLabel.setBounds(298, 415, 31, 16);
        panel.add(ACLabel);

        // Go to the skills screen.
        JButton skillsButton = new JButton("Skills");
        skillsButton.setFont(new Font("Algerian", Font.PLAIN, 18));
        skillsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                CharacterSheetSkillInterface characterSheetSkillInterface = new CharacterSheetSkillInterface(users);
            }
        });
        skillsButton.setBounds(817, 463, 97, 25);
        panel.add(skillsButton);

        JLabel speedLabel = new JLabel("Speed");
        speedLabel.setForeground(Color.RED);
        speedLabel.setFont(new Font("Algerian", Font.BOLD, 18));
        speedLabel.setBounds(12, 90, 59, 16);
        panel.add(speedLabel);

        JLabel strengthLabel = new JLabel("Strength");
        strengthLabel.setForeground(Color.RED);
        strengthLabel.setFont(new Font("Algerian", Font.BOLD, 18));
        strengthLabel.setBounds(12, 170, 94, 16);
        panel.add(strengthLabel);

        JLabel dexterityLabel = new JLabel("Dexterity");
        dexterityLabel.setForeground(Color.RED);
        dexterityLabel.setFont(new Font("Algerian", Font.BOLD, 18));
        dexterityLabel.setBounds(12, 256, 104, 16);
        panel.add(dexterityLabel);

        JLabel constiutionLabel = new JLabel("Constitution");
        constiutionLabel.setForeground(Color.RED);
        constiutionLabel.setFont(new Font("Algerian", Font.BOLD, 18));
        constiutionLabel.setBounds(12, 343, 129, 16);
        panel.add(constiutionLabel);

        JLabel proficiencyLabel = new JLabel("Proficiency");
        proficiencyLabel.setForeground(Color.RED);
        proficiencyLabel.setFont(new Font("Algerian", Font.BOLD, 18));
        proficiencyLabel.setBounds(298, 90, 120, 16);
        panel.add(proficiencyLabel);

        JLabel intellectLabel = new JLabel("Intellect");
        intellectLabel.setForeground(Color.RED);
        intellectLabel.setFont(new Font("Algerian", Font.BOLD, 18));
        intellectLabel.setBounds(298, 170, 101, 16);
        panel.add(intellectLabel);

        JLabel wisdomLabel = new JLabel("Wisdom");
        wisdomLabel.setForeground(Color.RED);
        wisdomLabel.setFont(new Font("Algerian", Font.BOLD, 18));
        wisdomLabel.setBounds(298, 256, 71, 16);
        panel.add(wisdomLabel);

        JLabel charismaLabel = new JLabel("Charisma");
        charismaLabel.setForeground(Color.RED);
        charismaLabel.setFont(new Font("Algerian", Font.BOLD, 18));
        charismaLabel.setBounds(298, 343, 97, 16);
        panel.add(charismaLabel);

        JLabel nameLabel = new JLabel("Name");
        nameLabel.setForeground(Color.RED);
        nameLabel.setFont(new Font("Algerian", Font.BOLD, 18));
        nameLabel.setBounds(298, 15, 53, 16);
        panel.add(nameLabel);

        JLabel classLabel = new JLabel("Class");
        classLabel.setForeground(Color.RED);
        classLabel.setFont(new Font("Algerian", Font.BOLD, 18));
        classLabel.setBounds(609, 15, 59, 16);
        panel.add(classLabel);

        JTextArea levelTextArea = new JTextArea();
        levelTextArea.setEditable(false);
        levelTextArea.setFont(new Font("Algerian", Font.PLAIN, 16));
        levelTextArea.setBounds(82, 13, 78, 22);
        panel.add(levelTextArea);
        
        JTextArea HPTextArea = new JTextArea();
        HPTextArea.setFont(new Font("Algerian", Font.PLAIN, 16));
        HPTextArea.setEditable(false);
        HPTextArea.setBounds(208, 13, 78, 22);
        panel.add(HPTextArea);

        JTextArea initiativeTextArea = new JTextArea();
        initiativeTextArea.setEditable(false);
        initiativeTextArea.setFont(new Font("Algerian", Font.PLAIN, 16));
        initiativeTextArea.setBounds(153, 411, 78, 22);
        panel.add(initiativeTextArea);

        JTextArea speedTextArea = new JTextArea();
        speedTextArea.setEditable(false);
        speedTextArea.setFont(new Font("Algerian", Font.PLAIN, 16));
        speedTextArea.setBounds(153, 86, 78, 22);
        panel.add(speedTextArea);

        JTextArea strengthTextArea = new JTextArea();
        strengthTextArea.setEditable(false);
        strengthTextArea.setFont(new Font("Algerian", Font.PLAIN, 16));
        strengthTextArea.setBounds(153, 166, 78, 22);
        panel.add(strengthTextArea);

        JTextArea dexterityTextArea = new JTextArea();
        dexterityTextArea.setEditable(false);
        dexterityTextArea.setFont(new Font("Algerian", Font.PLAIN, 16));
        dexterityTextArea.setBounds(153, 252, 78, 22);
        panel.add(dexterityTextArea);

        JTextArea constitutionTextArea = new JTextArea();
        constitutionTextArea.setEditable(false);
        constitutionTextArea.setFont(new Font("Algerian", Font.PLAIN, 16));
        constitutionTextArea.setBounds(153, 341, 78, 22);
        panel.add(constitutionTextArea);

        JTextArea nameTextArea = new JTextArea();
        nameTextArea.setLineWrap(true);
        nameTextArea.setEditable(false);
        nameTextArea.setFont(new Font("Algerian", Font.PLAIN, 16));
        nameTextArea.setBounds(371, 11, 228, 20);
        panel.add(nameTextArea);

        JTextArea proficiencyTextArea = new JTextArea();
        proficiencyTextArea.setEditable(false);
        proficiencyTextArea.setFont(new Font("Algerian", Font.PLAIN, 16));
        proficiencyTextArea.setBounds(430, 88, 78, 22);
        panel.add(proficiencyTextArea);

        JTextArea intellectTextArea = new JTextArea();
        intellectTextArea.setEditable(false);
        intellectTextArea.setFont(new Font("Algerian", Font.PLAIN, 16));
        intellectTextArea.setBounds(430, 166, 78, 22);
        panel.add(intellectTextArea);

        JTextArea wisdomTextArea = new JTextArea();
        wisdomTextArea.setEditable(false);
        wisdomTextArea.setFont(new Font("Algerian", Font.PLAIN, 16));
        wisdomTextArea.setBounds(430, 252, 78, 22);
        panel.add(wisdomTextArea);

        JTextArea charismaTextArea = new JTextArea();
        charismaTextArea.setEditable(false);
        charismaTextArea.setFont(new Font("Algerian", Font.PLAIN, 16));
        charismaTextArea.setBounds(430, 339, 78, 22);
        panel.add(charismaTextArea);

        JTextArea classTextArea = new JTextArea();
        classTextArea.setLineWrap(true);
        classTextArea.setEditable(false);
        classTextArea.setFont(new Font("Algerian", Font.PLAIN, 16));
        classTextArea.setBounds(678, 11, 120, 20);
        panel.add(classTextArea);

        JTextArea ACTextArea = new JTextArea();
        ACTextArea.setEditable(false);
        ACTextArea.setFont(new Font("Algerian", Font.PLAIN, 16));
        ACTextArea.setBounds(430, 411, 78, 22);
        panel.add(ACTextArea);
        
        JComboBox<String> characterComboBox = new JComboBox<String>();
        characterComboBox.setFont(new Font("Arial", Font.PLAIN, 14));
        characterComboBox.setBounds(808, 11, 120, 20);
        panel.add(characterComboBox);
        // Add each of the user's owned characters to the combo box.
        if (characterComboBox.getItemCount() == 0)
	        for (int i = 0; i < users.ownedCharacters.size(); i++)
	        	characterComboBox.addItem(new String(users.ownedCharacters.get(i).getCharacterName()));
        // For the selected character, display all of their abilities.
        characterComboBox.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		int index = characterComboBox.getSelectedIndex();
        		if (index != -1) {
                	levelTextArea.setText(String.valueOf(users.ownedCharacters.get(index).getLevel()));
                	HPTextArea.setText(String.valueOf(users.ownedCharacters.get(index).getHitPoints()));
                	initiativeTextArea.setText(String.valueOf(users.ownedCharacters.get(index).getInitiative()));
                	speedTextArea.setText(String.valueOf(users.ownedCharacters.get(index).getSpeed()));
                	strengthTextArea.setText(String.valueOf(users.ownedCharacters.get(index).getStrengthScore()));
                	dexterityTextArea.setText(String.valueOf(users.ownedCharacters.get(index).getDexScore()));
                	constitutionTextArea.setText(String.valueOf(users.ownedCharacters.get(index).getConScore()));
                	nameTextArea.setText(users.ownedCharacters.get(index).getCharacterName());
                	proficiencyTextArea.setText(String.valueOf(users.ownedCharacters.get(index).getProficiencyBonus()));
                	intellectTextArea.setText(String.valueOf(users.ownedCharacters.get(index).getIntScore()));
                	wisdomTextArea.setText(String.valueOf(users.ownedCharacters.get(index).getWisScore()));
                	charismaTextArea.setText(String.valueOf(users.ownedCharacters.get(index).getChaScore()));
                	classTextArea.setText(users.ownedCharacters.get(index).getCharacterClass());
                	ACTextArea.setText(String.valueOf(users.ownedCharacters.get(index).getArmorClass()));
        		}
        	}
        });

        // Paint the character placeholder.
        JLabel imageLabel = new JLabel(new ImageIcon("./src/dhampir.png"));
        imageLabel.setBounds(518, 49, 396, 401);
        panel.add(imageLabel);
        
        // Go to the main menu.
        JButton mainMenuButton = new JButton("Main Menu");
        mainMenuButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
        		MainMenuInterface mainMenuInterface = new MainMenuInterface(users);
        	}
        });
        mainMenuButton.setFont(new Font("Algerian", Font.PLAIN, 16));
        mainMenuButton.setBounds(660, 463, 140, 25);
        panel.add(mainMenuButton);
        
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
