import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class CharacterSheetSkillInterface extends JFrame {

	private JPanel contentPane;
	private JButton btnNewButton;
	
	/*
	 * Launch the application
	 */
	public static void main(String[] args) {
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
	}

	/*
	 * Create the frame
	 */
	public CharacterSheetSkillInterface() {
		setTitle("Character Sheet Skill");
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

		JLabel lblNewLabel = new JLabel("Skills");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Algerian", Font.BOLD, 18));
		lblNewLabel.setBounds(12, 15, 80, 16);
		panel.add(lblNewLabel);

		JLabel strSaveLabel = new JLabel("STR Save");
		strSaveLabel.setForeground(Color.RED);
		strSaveLabel.setFont(new Font("Algerian", Font.BOLD, 18));
		strSaveLabel.setBounds(12, 90, 59, 16);
		panel.add(strSaveLabel);

		JLabel dexSaveLabel = new JLabel("DEX Save");
		dexSaveLabel.setForeground(Color.RED);
		dexSaveLabel.setFont(new Font("Algerian", Font.BOLD, 18));
		dexSaveLabel.setBounds(12, 170, 94, 16);
		panel.add(dexSaveLabel);
		
		JButton btnNewButton = new JButton("Go Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				CharacterSheetAbilityInterface characterSheetAbilityInterface = new CharacterSheetAbilityInterface();
			}
		});
		btnNewButton.setBounds(817, 463, 97, 25);
		panel.add(btnNewButton);
		setVisible(true);

		BufferedImage image = null;
		try {
			image = ImageIO.read(new File("./src/bard.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		JLabel imageLabel = new JLabel(new ImageIcon("./src/bard.png"));
		imageLabel.setBounds(544, 49, 370, 401);
		panel.add(imageLabel);

	}
}
