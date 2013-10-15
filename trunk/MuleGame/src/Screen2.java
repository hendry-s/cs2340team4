import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class Screen2 extends JPanel {
	
	private JPanel colorPanel1;
	private JPanel colorPanel2;
	private JButton btnSelectColor1;
	private JButton btnSelectColor2;
	private JButton startGame;

	public Screen2() {
		
		setBounds(0, 0, 767, 521);
		setBackground(Color.WHITE);
		setBorder(new LineBorder(new Color(0, 0, 0), 5));
		setLayout(null);
		setVisible(true);

		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"Human", "Flapper", "Bonzoid", "Ugaite", "Buzzite"}));
		comboBox_3.setBounds(290, 214, 89, 20);
		add(comboBox_3);

		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"Player 1", "Player 2"}));
		comboBox_4.setBounds(290, 77, 89, 20);
		add(comboBox_4);

		JComboBox comboBox_5 = new JComboBox();
		comboBox_5.setModel(new DefaultComboBoxModel(new String[] {"Human", "Flapper", "Bonzoid", "Ugaite", "Buzzite"}));
		comboBox_5.setBounds(290, 283, 89, 20);
		add(comboBox_5);

		JComboBox comboBox_6 = new JComboBox();
		comboBox_6.setModel(new DefaultComboBoxModel(new String[] {"Player 1", "Player 2"}));
		comboBox_6.setBounds(290, 145, 89, 20);
		add(comboBox_6);

		colorPanel1 = new JPanel();
		colorPanel1.setBorder(new LineBorder(new Color(0, 0, 0), 5));
		colorPanel1.setBounds(420, 347, 30, 30);
		colorPanel1.setBackground(Color.WHITE);
		add(colorPanel1);
		colorPanel1.setLayout(null);

		btnSelectColor1 = new JButton("Select Color");
		btnSelectColor1.setBounds(288, 352, 122, 23);
		add(btnSelectColor1);

		btnSelectColor1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				JColorChooser clr = new JColorChooser();
				Color color = clr.showDialog(colorPanel1, "Pick a Color", Color.black);

				if (color != null) {

					colorPanel1.setBackground(color);
				}
			}
		});

		colorPanel2 = new JPanel();
		colorPanel2.setBorder(new LineBorder(new Color(0, 0, 0), 5));
		colorPanel2.setBounds(420, 416, 30, 30);
		colorPanel2.setBackground(Color.WHITE);
		add(colorPanel2);
		colorPanel2.setLayout(null);

		btnSelectColor2 = new JButton("Select Color");
		btnSelectColor2.setBounds(288, 421, 122, 23);
		add(btnSelectColor2);

		btnSelectColor2.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				JColorChooser clr = new JColorChooser();
				Color color = clr.showDialog(colorPanel2, "Pick a Color", Color.black);

				if (color != null) {

					colorPanel2.setBackground(color);
				}
			}
		});

		JLabel lblPlayerRace1 = new JLabel("PLAYER 1 RACE");
		lblPlayerRace1.setForeground(Color.BLUE);
		lblPlayerRace1.setFont(new Font("Showcard Gothic", Font.PLAIN, 30));
		lblPlayerRace1.setBounds(38, 206, 229, 38);
		add(lblPlayerRace1);

		JLabel lblPlayerRace2 = new JLabel("PLAYER 2 RACE");
		lblPlayerRace2.setForeground(Color.BLUE);
		lblPlayerRace2.setFont(new Font("Showcard Gothic", Font.PLAIN, 30));
		lblPlayerRace2.setBounds(38, 275, 229, 38);
		add(lblPlayerRace2);

		JLabel lblPlayer1 = new JLabel("PLAYER 1 NAME");
		lblPlayer1.setForeground(Color.BLUE);
		lblPlayer1.setFont(new Font("Showcard Gothic", Font.PLAIN, 30));
		lblPlayer1.setBounds(38, 68, 229, 38);
		add(lblPlayer1);

		JLabel lblPlayer2 = new JLabel("PLAYER 2 NAME");
		lblPlayer2.setForeground(Color.BLUE);
		lblPlayer2.setFont(new Font("Showcard Gothic", Font.PLAIN, 30));
		lblPlayer2.setBounds(38, 137, 229, 38);
		add(lblPlayer2);

		JLabel lblPlayer1Color = new JLabel("PLAYER 1 COLOR");
		lblPlayer1Color.setForeground(Color.BLUE);
		lblPlayer1Color.setFont(new Font("Showcard Gothic", Font.PLAIN, 30));
		lblPlayer1Color.setBounds(38, 344, 242, 38);
		add(lblPlayer1Color);

		JLabel lblPlayer2Color = new JLabel("PLAYER 2 COLOR");
		lblPlayer2Color.setForeground(Color.BLUE);
		lblPlayer2Color.setFont(new Font("Showcard Gothic", Font.PLAIN, 30));
		lblPlayer2Color.setBounds(38, 413, 242, 38);
		add(lblPlayer2Color);

		startGame = new JButton("Start Game");
		startGame.setBounds(550, 421, 122, 23);
		add(startGame);	    

		startGame.addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent e) {

				
			}
		});
	}
	
	public JButton getButton() {
		
		return startGame;
	}
}