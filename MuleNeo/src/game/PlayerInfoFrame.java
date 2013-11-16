package game;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import org.newdawn.slick.Color;

import java.util.Vector;

public class PlayerInfoFrame {
	JFrame frame;
	PlayerInfoPanel p1;
	PlayerInfoPanel p2;
	PlayerInfoPanel p3;
	PlayerInfoPanel p4;
	JButton submitButton;
	
	
	
	String playerName1 = null;
	String playerName2 = null;
	String playerName3 = null;
	String playerName4 = null;
	
	int playerRace1;	// (Bonzoid 0) (Buzzite 1) (Flapper 2) (Human 3) (Ugaite 4) 
	int playerRace2;
	int playerRace3;
	int playerRace4;
	
	Color playerColor1;	// RED
	Color playerColor2;	// BLUE
	Color playerColor3;	// YELLOW
	Color playerColor4;	// GREEN
	
	
	
	
	
	
	public PlayerInfoFrame() {
		frame = new JFrame("Player Info");
		frame.setPreferredSize(new Dimension(500,400));
		frame.setBounds(300,300,500,500);
		frame.setLayout(new GridLayout(4,1));
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		
		submitButton = new JButton("Submit");
		submitButton.addActionListener(new SubmitButtonHandler(this));
		
		if (GameData.getInstance().numOfPlayer == 2) {
			TwoPlayerFrame(frame);
		} else if (GameData.getInstance().numOfPlayer == 3) {
			ThreePlayerFrame(frame);
		} else if (GameData.getInstance().numOfPlayer == 4) {
			FourPlayerFrame(frame);
		}
	}

	private void TwoPlayerFrame(JFrame frame) {
		p1 = new PlayerInfoPanel(1);
		p1.setPreferredSize(new Dimension(500,100));
		
		p2 = new PlayerInfoPanel(2);
		p2.setPreferredSize(new Dimension(500,100));
		
		frame.add(p1);
		frame.add(p2);
		frame.add(submitButton);
		
	}

	private void ThreePlayerFrame(JFrame frame) {
		p1 = new PlayerInfoPanel(1);
		p1.setPreferredSize(new Dimension(500,100));
		
		p2 = new PlayerInfoPanel(2);
		p2.setPreferredSize(new Dimension(500,100));
		
		p3 = new PlayerInfoPanel(3);
		p3.setPreferredSize(new Dimension(500,100));
			
		frame.add(p1);
		frame.add(p2);
		frame.add(p3);
		frame.add(submitButton);
		
	}
	private void FourPlayerFrame(JFrame frame) {
		p1 = new PlayerInfoPanel(1);
		p1.setPreferredSize(new Dimension(500,100));
		
		p2 = new PlayerInfoPanel(2);
		p2.setPreferredSize(new Dimension(500,100));
		
		p3 = new PlayerInfoPanel(3);
		p3.setPreferredSize(new Dimension(500,100));
		
		p4 = new PlayerInfoPanel(4);
		p4.setPreferredSize(new Dimension(500,100));
			
		frame.add(p1);
		frame.add(p2);
		frame.add(p3);
		frame.add(p4);
		frame.add(submitButton);
	}

	public JFrame getFrame() {
		return frame;
	}
	
	private class PlayerInfoPanel extends JPanel {
		int player;
		JLabel nameLabel;
		JTextField nameField;
		
		JComboBox raceBox;
		JComboBox colorBox;
		
		Vector races;
		Vector colors;
		
		public PlayerInfoPanel(int player) {
			this.player = player;
			nameLabel = new JLabel("Player " + player + " (Name, Race, Color)   ", SwingConstants.RIGHT);
			nameField = new JTextField(10);
			
			races = new Vector();
			races.add("Bonzoid");
			races.add("Buzzite");
			races.add("Flapper");
			races.add("Human");
			races.add("Ugaite");

			raceBox = new JComboBox(races);
			raceBox.setMaximumRowCount(5);
			raceBox.addItemListener(new RaceHandler(player));
			
			colors = new Vector();
			colors.add("Red");
			colors.add("Blue");
			colors.add("Yellow");
			colors.add("Green");
			
			colorBox = new JComboBox(colors);
			colorBox.setMaximumRowCount(4);
			colorBox.addItemListener(new ColorHandler(player));
			
			this.add(nameLabel);
			this.add(nameField);
			this.add(raceBox);
			this.add(colorBox);
			
		}
	}
	
	
	private class NameHandler implements ActionListener {
		int player;
		JTextField nameField;

		public NameHandler(int player, JTextField nameField) {
			this.player = player;
			this.nameField = nameField;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if (player == 1) { playerName1 = nameField.getText();}
			else if (player == 2) { playerName2 = nameField.getText();}
			else if (player == 3) { playerName3 = nameField.getText();}
			else if (player == 4) { playerName4 = nameField.getText();}
		}
		
		
	}
	
	private class RaceHandler implements ItemListener {
		int player;
		
		//(Bonzoid 0) (Buzzite 1) (Flapper 2) (Human 3) (Ugaite 4) 
		
		
		public RaceHandler(int player) {
			this.player = player;
		}

		public void itemStateChanged(ItemEvent e) {
			if (e.getStateChange() == ItemEvent.SELECTED) {
				if(player == 1)	{
					if (((String)e.getItem()).equals("Bonzoid"))	{ playerRace1 = 0; }
					else if (((String)e.getItem()).equals("Buzzite"))	{ playerRace1 = 1; }
					else if (((String)e.getItem()).equals("Flapper"))	{ playerRace1 = 2; }
					else if (((String)e.getItem()).equals("Human"))	{ playerRace1 = 3; }
					else if (((String)e.getItem()).equals("Ugaite"))	{ playerRace1 = 4; }
				}
				else if(player == 2)	{
					if (((String)e.getItem()).equals("Bonzoid"))	{ playerRace2 = 0; }
					else if (((String)e.getItem()).equals("Buzzite"))	{ playerRace2 = 1; }
					else if (((String)e.getItem()).equals("Flapper"))	{ playerRace2 = 2; }
					else if (((String)e.getItem()).equals("Human"))	{ playerRace2 = 3; }
					else if (((String)e.getItem()).equals("Ugaite"))	{ playerRace2 = 4; }
				}
				else if(player == 3)	{
					if (((String)e.getItem()).equals("Bonzoid"))	{ playerRace3 = 0; }
					else if (((String)e.getItem()).equals("Buzzite"))	{ playerRace3 = 1; }
					else if (((String)e.getItem()).equals("Flapper"))	{ playerRace3 = 2; }
					else if (((String)e.getItem()).equals("Human"))	{ playerRace3 = 3; }
					else if (((String)e.getItem()).equals("Ugaite"))	{ playerRace3 = 4; }
				}
				else if(player == 4)	{
					if (((String)e.getItem()).equals("Bonzoid"))	{ playerRace4 = 0; }
					else if (((String)e.getItem()).equals("Buzzite"))	{ playerRace4 = 1; }
					else if (((String)e.getItem()).equals("Flapper"))	{ playerRace4 = 2; }
					else if (((String)e.getItem()).equals("Human"))	{ playerRace4 = 3; }
					else if (((String)e.getItem()).equals("Ugaite"))	{ playerRace4 = 4; }
				}
			}
		}
	}
	
	private class ColorHandler implements ItemListener {
		int player;
		
		public ColorHandler(int player) {
			this.player = player;
		}

		public void itemStateChanged(ItemEvent e) {
			if (e.getStateChange() == ItemEvent.SELECTED) {
				if(player == 1)	{
					if (((String)e.getItem()).equals("Red"))	{ playerColor1 = Color.red; }
					else if (((String)e.getItem()).equals("Blue"))	{ playerColor1 = Color.blue; }
					else if (((String)e.getItem()).equals("Yellow"))	{ playerColor1 = Color.yellow; }
					else if (((String)e.getItem()).equals("Green"))	{ playerColor1 = Color.green; }
				}
				else if(player == 2)	{
					if (((String)e.getItem()).equals("Red"))	{ playerColor2 = Color.red; }
					else if (((String)e.getItem()).equals("Blue"))	{ playerColor2 = Color.blue; }
					else if (((String)e.getItem()).equals("Yellow"))	{ playerColor2 = Color.yellow; }
					else if (((String)e.getItem()).equals("Green"))	{ playerColor2 = Color.green; }
				}
				else if(player == 3)	{
					if (((String)e.getItem()).equals("Red"))	{ playerColor3 = Color.red; }
					else if (((String)e.getItem()).equals("Blue"))	{ playerColor3 = Color.blue; }
					else if (((String)e.getItem()).equals("Yellow"))	{ playerColor3 = Color.yellow; }
					else if (((String)e.getItem()).equals("Green"))	{ playerColor3 = Color.green; }
				}
				else if(player == 4)	{
					if (((String)e.getItem()).equals("Red"))	{ playerColor4 = Color.red; }
					else if (((String)e.getItem()).equals("Blue"))	{ playerColor4 = Color.blue; }
					else if (((String)e.getItem()).equals("Yellow"))	{ playerColor4 = Color.yellow; }
					else if (((String)e.getItem()).equals("Green"))	{ playerColor4 = Color.green; }
				}
			}
		}
	}
	

	private class SubmitButtonHandler implements ActionListener {
		PlayerInfoFrame fr;
		
		public SubmitButtonHandler(PlayerInfoFrame frame) {
			this.fr = frame;
		}

		public void actionPerformed(ActionEvent e) {
			GameData.getInstance().updatePlayerInfo(fr);
			frame.dispose();
		}
	}
}
