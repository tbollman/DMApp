import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import java.awt.Color;

public class CharacterSheetAbilityInterface extends JFrame {

	private JPanel contentPane;
	private JButton btnNewButton;

	/*
	 * Launch the application
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CharacterSheetAbilityInterface frame = new CharacterSheetAbilityInterface();
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
	public CharacterSheetAbilityInterface() {
		setTitle("Character Sheet Ability");
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
		initiativeLabel.setBounds(298, 15, 101, 16);
		panel.add(initiativeLabel);
		
		JLabel ACLabel = new JLabel("AC");
		ACLabel.setForeground(Color.RED);
		ACLabel.setFont(new Font("Algerian", Font.BOLD, 18));
		ACLabel.setBounds(501, 15, 31, 16);
		panel.add(ACLabel);
		
		btnNewButton = new JButton("Skills");
		btnNewButton.setFont(new Font("Algerian", Font.PLAIN, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				CharacterSheetSkillInterface characterSheetSkillInterface = new CharacterSheetSkillInterface();
			}
		});
		btnNewButton.setBounds(817, 463, 97, 25);
		panel.add(btnNewButton);
		
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
		nameLabel.setBounds(12, 435, 53, 16);
		panel.add(nameLabel);
		
		JLabel classLabel = new JLabel("Class");
		classLabel.setForeground(Color.RED);
		classLabel.setFont(new Font("Algerian", Font.BOLD, 18));
		classLabel.setBounds(298, 435, 59, 16);
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
		initiativeTextArea.setBounds(411, 13, 78, 22);
		panel.add(initiativeTextArea);
		
		JTextArea speedTextArea = new JTextArea();
		speedTextArea.setEditable(false);
		speedTextArea.setFont(new Font("Algerian", Font.PLAIN, 16));
		speedTextArea.setBounds(82, 88, 78, 22);
		panel.add(speedTextArea);
		
		JTextArea strengthTextArea = new JTextArea();
		strengthTextArea.setEditable(false);
		strengthTextArea.setFont(new Font("Algerian", Font.PLAIN, 16));
		strengthTextArea.setBounds(118, 168, 78, 22);
		panel.add(strengthTextArea);
		
		JTextArea dexterityTextArea = new JTextArea();
		dexterityTextArea.setEditable(false);
		dexterityTextArea.setFont(new Font("Algerian", Font.PLAIN, 16));
		dexterityTextArea.setBounds(128, 254, 78, 22);
		panel.add(dexterityTextArea);
		
		JTextArea constitutionTextArea = new JTextArea();
		constitutionTextArea.setEditable(false);
		constitutionTextArea.setFont(new Font("Algerian", Font.PLAIN, 16));
		constitutionTextArea.setBounds(153, 341, 78, 22);
		panel.add(constitutionTextArea);
		
		JTextArea nameTextArea = new JTextArea();
		nameTextArea.setEditable(false);
		nameTextArea.setFont(new Font("Algerian", Font.PLAIN, 16));
		nameTextArea.setBounds(82, 433, 78, 22);
		panel.add(nameTextArea);
		
		JTextArea proficiencyTextArea = new JTextArea();
		proficiencyTextArea.setEditable(false);
		proficiencyTextArea.setFont(new Font("Algerian", Font.PLAIN, 16));
		proficiencyTextArea.setBounds(430, 88, 78, 22);
		panel.add(proficiencyTextArea);
		
		JTextArea intellectTextArea = new JTextArea();
		intellectTextArea.setEditable(false);
		intellectTextArea.setFont(new Font("Algerian", Font.PLAIN, 16));
		intellectTextArea.setBounds(411, 168, 78, 22);
		panel.add(intellectTextArea);
		
		JTextArea wisdomTextArea = new JTextArea();
		wisdomTextArea.setEditable(false);
		wisdomTextArea.setFont(new Font("Algerian", Font.PLAIN, 16));
		wisdomTextArea.setBounds(381, 254, 78, 22);
		panel.add(wisdomTextArea);
		
		JTextArea charismaTextArea = new JTextArea();
		charismaTextArea.setEditable(false);
		charismaTextArea.setFont(new Font("Algerian", Font.PLAIN, 16));
		charismaTextArea.setBounds(407, 341, 78, 22);
		panel.add(charismaTextArea);
		
		JTextArea classTextArea = new JTextArea();
		classTextArea.setEditable(false);
		classTextArea.setFont(new Font("Algerian", Font.PLAIN, 16));
		classTextArea.setBounds(369, 433, 78, 22);
		panel.add(classTextArea);
		
		JTextArea ACTextArea = new JTextArea();
		ACTextArea.setEditable(false);
		ACTextArea.setFont(new Font("Algerian", Font.PLAIN, 16));
		ACTextArea.setBounds(544, 13, 78, 22);
		panel.add(ACTextArea);
		setVisible(true);
	}
}
