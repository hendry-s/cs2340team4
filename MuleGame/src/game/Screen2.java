package game;
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
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import entities.Bonzoid;
import entities.Buzzite;
import entities.Flapper;
import entities.Human;
import entities.Player;
import entities.Ugaite;

public class Screen2 extends JPanel {
	
	private JPanel colorPanel1;
	private JPanel colorPanel2;
	private JButton btnSelectColor1;
	private JButton btnSelectColor2;
	private JButton startGame;
	private Player p1;
	private Player p2;
	private JTextField field1;
	private JTextField field2;
	private Color color1;
	private Color color2;
	private JComboBox comboBox_1;
	private JComboBox comboBox_2;

	public Screen2() {
		
		setBounds(0, 0, 767, 521);
		setBackground(Color.WHITE);
		setBorder(new LineBorder(new Color(0, 0, 0), 5));
		setLayout(null);
		setVisible(true);

		comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Human", "Flapper", "Bonzoid", "Ugaite", "Buzzite"}));
		comboBox_1.setBounds(290, 214, 89, 20);
		add(comboBox_1);

		field1 = new JTextField(20);
		field1.setBounds(290, 77, 89, 20);
		add(field1);

		comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"Human", "Flapper", "Bonzoid", "Ugaite", "Buzzite"}));
		comboBox_2.setBounds(290, 283, 89, 20);
		add(comboBox_2);

		field2 = new JTextField(20);
		field2.setBounds(290, 145, 89, 20);
		add(field2);

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
				color1 = clr.showDialog(colorPanel1, "Pick a Color", Color.black);

				if (color1 != null) {

					colorPanel1.setBackground(color1);
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
				color2 = clr.showDialog(colorPanel2, "Pick a Color", Color.black);

				if (color2 != null) {

					colorPanel2.setBackground(color2);
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

				if(comboBox_1.getSelectedItem().toString() == "Human") {
					
					p1 = new Human(field1.getText(), color1, comboBox_1.getSelectedItem().toString());
				}
				
				else if(comboBox_1.getSelectedItem().toString() == "Flapper") {
					
					p1 = new Flapper(field1.getText(), color1, comboBox_1.getSelectedItem().toString());
				}
				
				else if(comboBox_1.getSelectedItem().toString() == "Ugaite") {
					
					p1 = new Ugaite(field1.getText(), color1, comboBox_1.getSelectedItem().toString());
				}
				
				else if(comboBox_1.getSelectedItem().toString() == "Buzzite") {
					
					p1 = new Buzzite(field1.getText(), color1, comboBox_1.getSelectedItem().toString());
				}
				
				else if(comboBox_1.getSelectedItem().toString() == "Bonzoid") {
					
					p1 = new Bonzoid(field1.getText(), color1, comboBox_1.getSelectedItem().toString());
				}
				
				if(comboBox_2.getSelectedItem().toString() == "Human") {
					
					p2 = new Human(field2.getText(), color2, comboBox_2.getSelectedItem().toString());
				}
				
				else if(comboBox_2.getSelectedItem().toString() == "Flapper") {
					
					p2 = new Flapper(field2.getText(), color2, comboBox_2.getSelectedItem().toString());
				}
				
				else if(comboBox_2.getSelectedItem().toString() == "Ugaite") {
					
					p2 = new Ugaite(field2.getText(), color2, comboBox_2.getSelectedItem().toString());
				}
				
				else if(comboBox_2.getSelectedItem().toString() == "Buzzite") {
					
					p2 = new Buzzite(field2.getText(), color2, comboBox_2.getSelectedItem().toString());
				}
				
				else if(comboBox_2.getSelectedItem().toString() == "Bonzoid") {
					
					p2 = new Bonzoid(field2.getText(), color2, comboBox_2.getSelectedItem().toString());
				}
				
				//System.out.print("Name: " + p1.getName() + " Color: " + p1.getColor() + " Race: " + p1.getRace());
				//System.out.print(p2.getName() + p2.getColor() + p2.getRace());
				
				MuleGame.screen3();
			}
			
		});
	}
	
	public Player getPlayer1()
	{
		return p1;
	}
	
	public Player getPlayer2()
	{
		return p2;
	}

	public JButton getButton() {
		
		return startGame;
	}
}