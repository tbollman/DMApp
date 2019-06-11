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

public class CharacterSheetAbilityInterface extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
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
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Strength");
		lblNewLabel.setBounds(12, 75, 56, 16);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(80, 72, 116, 22);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Dexterity");
		lblNewLabel_1.setBounds(12, 123, 56, 16);
		panel.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(80, 120, 116, 22);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Constitution");
		lblNewLabel_2.setBounds(12, 169, 56, 16);
		panel.add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(80, 166, 116, 22);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Intelligence");
		lblNewLabel_3.setBounds(12, 217, 56, 16);
		panel.add(lblNewLabel_3);
		
		textField_3 = new JTextField();
		textField_3.setBounds(80, 214, 116, 22);
		panel.add(textField_3);
		textField_3.setColumns(10);

		btnNewButton = new JButton("Skills");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				CharacterSheetSkillInterface characterSheetSkillInterface = new CharacterSheetSkillInterface();
			}
		});
		btnNewButton.setBounds(244, 392, 97, 25);
		panel.add(btnNewButton);
		setVisible(true);
	}

}
