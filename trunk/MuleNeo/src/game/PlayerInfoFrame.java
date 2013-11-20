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

import model.Player;

import org.newdawn.slick.Color;

import java.util.Vector;

/**
 *  Class that holds the JFrame to display each player and their corresponding
 *  data such as their name, information, race, color, etc
 *  Holds all such information such as race, color, name, etc in the class for
 *  each of the players (2-4 players)
 *  
 *  @author Jin Sim
 *  @date November 15, 2013
 *
 */
public class PlayerInfoFrame {
	JFrame frame;
	PlayerInfoPanel panel1;
	PlayerInfoPanel panel2;
	PlayerInfoPanel panel3;
	PlayerInfoPanel panel4;
	JButton submitButton;
	
	String playerName1 = null;
	String playerName2 = null;
	String playerName3 = null;
	String playerName4 = null;
	
	int numPlayers;
	
	int playerRace1;	// (Bonzoid 0) (Buzzite 1) (Flapper 2) (Human 3) (Ugaite 4) 
	int playerRace2;
	int playerRace3;
	int playerRace4;
	
	int playerColor1;	// RED
	int playerColor2;	// BLUE
	int playerColor3;	// YELLOW
	int playerColor4;	// GREEN
	
	Player player1 = null;
	Player player2 = null;
	Player player3 = null;
	Player player4 = null;
	
	
	
	
	/**
	 *  Constructor that initializes the number of players depending on how many
	 *  players are playing the game
	 *  Sets the settings for the JFrame
	 *  Determines how to display the frame depending on the number of players
	 */
	public PlayerInfoFrame() {
		numPlayers = GameData.getInstance().numOfPlayer;
		
		frame = new JFrame("Player Info");
		frame.setPreferredSize(new Dimension(500,400));
		frame.setBounds(300,300,500,500);
		frame.setLayout(new GridLayout(4,1));
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		
		if (GameData.getInstance().numOfPlayer == 2) {
			TwoPlayerFrame(frame);
		} else if (GameData.getInstance().numOfPlayer == 3) {
			ThreePlayerFrame(frame);
		} else if (GameData.getInstance().numOfPlayer == 4) {
			FourPlayerFrame(frame);
		}
		
	}
	
	/**
	 *  Method that displays the frame for games with two players
	 *  Initializes settings for the panels to be added to the JFrame
	 *  Adds the submit button to the frame
	 *  
	 *  @param frame The frame for the panels and buttons to be added to
	 */
	private void TwoPlayerFrame(JFrame frame) {
		panel1 = new PlayerInfoPanel(1);
		panel1.setPreferredSize(new Dimension(500,100));
		
		panel2 = new PlayerInfoPanel(2);
		panel2.setPreferredSize(new Dimension(500,100));
		
		submitButton = new JButton("Submit");
		submitButton.addActionListener(new SubmitButtonHandler(this));
		
		frame.add(panel1);
		frame.add(panel2);
		frame.add(submitButton);
		
	}

	/**
	 *  Method that displays the frame for games with three players
	 *  Initializes settings for the panels to be added to the JFrame
	 *  Adds the submit button the frame
	 *  
	 *  @param frame The frame for the panels and buttons to be added to
	 */
	private void ThreePlayerFrame(JFrame frame) {
		panel1 = new PlayerInfoPanel(1);
		panel1.setPreferredSize(new Dimension(500,100));
		
		panel2 = new PlayerInfoPanel(2);
		panel2.setPreferredSize(new Dimension(500,100));
		
		panel3 = new PlayerInfoPanel(3);
		panel3.setPreferredSize(new Dimension(500,100));
			
		submitButton = new JButton("Submit");
		submitButton.addActionListener(new SubmitButtonHandler(this));
		
		frame.add(panel1);
		frame.add(panel2);
		frame.add(panel3);
		frame.add(submitButton);
		
	}

	/**
	 *  Method that displays the frame for games with four players
	 *  Initializes settings for the panels to be added to the JFrame
	 *  Adds the submit button the frame
	 *  
	 *  @param frame The frame for the panels and buttons to be added to
	 */
	private void FourPlayerFrame(JFrame frame) {
		panel1 = new PlayerInfoPanel(1);
		panel1.setPreferredSize(new Dimension(500,100));
		
		panel2 = new PlayerInfoPanel(2);
		panel2.setPreferredSize(new Dimension(500,100));
		
		panel3 = new PlayerInfoPanel(3);
		panel3.setPreferredSize(new Dimension(500,100));
		
		panel4 = new PlayerInfoPanel(4);
		panel4.setPreferredSize(new Dimension(500,100));
			
		submitButton = new JButton("Submit");
		submitButton.addActionListener(new SubmitButtonHandler(this));
		
		frame.add(panel1);
		frame.add(panel2);
		frame.add(panel3);
		frame.add(panel4);
		frame.add(submitButton);
	}

	/**
	 *  Method that returns the frame holding the player information
	 *  
	 * @return The frame holding the players' information
	 */
	public JFrame getFrame() {
		return frame;
	}
	
	/**
	 *  Private inner class that is a panel and holds the options for player settings
	 *  the player can choose from such as the race, color, name, etc
	 *  
	 *  @author Jin Sim
	 *
	 */
	private class PlayerInfoPanel extends JPanel {
		int player;
		JLabel nameLabel;
		JTextField nameField;
		
		JComboBox raceBox;
		JComboBox colorBox;
		
		Vector races;
		Vector colors;
		
		/**
		 *  Constructor for the private inner class that takes in a player and
		 *  allows the player to choose from the options to set up their character
		 *  within the game
		 *  
		 *  @param player The player updating their options
		 */
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
			
			colors = new Vector();
			colors.add("Red");
			colors.add("Blue");
			colors.add("Yellow");
			colors.add("Green");
			
			colorBox = new JComboBox(colors);
			colorBox.setMaximumRowCount(4);
			
			this.add(nameLabel);
			this.add(nameField);
			this.add(raceBox);
			this.add(colorBox);
			
		}
	}
	/**
	 *  Private inner action listerner class for the submit button
	 *  Will set player settings to the appropriate settings the player chose
	 *  and adds all the information to the panel to be added to the frame
	 *  
	 *  @author Jin Sim
	 *
	 */
	private class SubmitButtonHandler implements ActionListener {
		PlayerInfoFrame fr;
		
		/**
		 *  Constructor for the action listener class
		 *  @param frame The frame for the panel to be added to
		 */
		public SubmitButtonHandler(PlayerInfoFrame frame) {
			this.fr = frame;
		}
		
		/**
		 *  Method that updates information depending on the inputs given by the user
		 *  once the submit button is pressed
		 *  Creates appropriate player classes and updates the information
		 *  onto the GameData class
		 *  
		 *  @param e The ActionEvent object
		 */
		public void actionPerformed(ActionEvent e) {
			
			// Update Colors
			if (panel1.colorBox.getSelectedItem().toString() == "Red") {
				playerColor1 = 0;
			} else if (panel1.colorBox.getSelectedItem().toString() == "Blue") {
				playerColor1 = 1;
			} else if (panel1.colorBox.getSelectedItem().toString() == "Yellow") {
				playerColor1 = 2;
			} else if (panel1.colorBox.getSelectedItem().toString() == "Green") {
				playerColor1 = 3;
			}
			
			if (panel2.colorBox.getSelectedItem().toString() == "Red") {
				playerColor2 = 0;
			} else if (panel2.colorBox.getSelectedItem().toString() == "Blue") {
				playerColor2 = 1;
			} else if (panel2.colorBox.getSelectedItem().toString() == "Yellow") {
				playerColor2 = 2;
			} else if (panel2.colorBox.getSelectedItem().toString() == "Green") {
				playerColor2 = 3;
			}
			
			if (numPlayers >= 3) {
				if (panel3.colorBox.getSelectedItem().toString() == "Red") {
					playerColor3 = 0;
				} else if (panel3.colorBox.getSelectedItem().toString() == "Blue") {
					playerColor3 = 1;
				} else if (panel3.colorBox.getSelectedItem().toString() == "Yellow") {
					playerColor3 = 2;
				} else if (panel3.colorBox.getSelectedItem().toString() == "Green") {
					playerColor3 = 3;
				}
			}
			if (numPlayers >= 4) {
				if (panel4.colorBox.getSelectedItem().toString() == "Red") {
					playerColor4 = 0;
				} else if (panel4.colorBox.getSelectedItem().toString() == "Blue") {
					playerColor4 = 1;
				} else if (panel4.colorBox.getSelectedItem().toString() == "Yellow") {
					playerColor4 = 2;
				} else if (panel4.colorBox.getSelectedItem().toString() == "Green") {
					playerColor4 = 3;
				}
			}
			
			
			
			// Update Races
			if (panel1.raceBox.getSelectedItem().toString() == "Bonzoid") {
				playerRace1 = 0;
			} else if (panel1.raceBox.getSelectedItem().toString() == "Buzzite") {
				playerRace1 = 1;
			} else if (panel1.raceBox.getSelectedItem().toString() == "Flapper") {
				playerRace1 = 2;
			} else if (panel1.raceBox.getSelectedItem().toString() == "Human") {
				playerRace1 = 3;
			} else if (panel1.raceBox.getSelectedItem().toString() == "Ugaite") {
				playerRace1 = 4;
			}
			
			if (panel2.raceBox.getSelectedItem().toString() == "Bonzoid") {
				playerRace2 = 0;
			} else if (panel2.raceBox.getSelectedItem().toString() == "Buzzite") {
				playerRace2 = 1;
			} else if (panel2.raceBox.getSelectedItem().toString() == "Flapper") {
				playerRace2 = 2;
			} else if (panel2.raceBox.getSelectedItem().toString() == "Human") {
				playerRace2 = 3;
			} else if (panel2.raceBox.getSelectedItem().toString() == "Ugaite") {
				playerRace2 = 4;
			}
			
			if (numPlayers >= 3) {
				if (panel3.raceBox.getSelectedItem().toString() == "Bonzoid") {
					playerRace3 = 0;
				} else if (panel3.raceBox.getSelectedItem().toString() == "Buzzite") {
					playerRace3 = 1;
				} else if (panel3.raceBox.getSelectedItem().toString() == "Flapper") {
					playerRace3 = 2;
				} else if (panel3.raceBox.getSelectedItem().toString() == "Human") {
					playerRace3 = 3;
				} else if (panel3.raceBox.getSelectedItem().toString() == "Ugaite") {
					playerRace3 = 4;
				}
			}
			if (numPlayers >= 4) {
				if (panel4.raceBox.getSelectedItem().toString() == "Bonzoid") {
					playerRace4 = 0;
				} else if (panel4.raceBox.getSelectedItem().toString() == "Buzzite") {
					playerRace4 = 1;
				} else if (panel4.raceBox.getSelectedItem().toString() == "Flapper") {
					playerRace4 = 2;
				} else if (panel4.raceBox.getSelectedItem().toString() == "Human") {
					playerRace4 = 3;
				} else if (panel4.raceBox.getSelectedItem().toString() == "Ugaite") {
					playerRace4 = 4;
				}
			}
			
			// Update Names
			playerName1 = panel1.nameField.getText();
			playerName2 = panel2.nameField.getText();
			if (numPlayers >= 3) {
				playerName3 = panel3.nameField.getText();
			}
			if (numPlayers >= 4) {
				playerName4 = panel4.nameField.getText();
			}
			

			// Create Player Class
			player1 = new Player(playerName1, playerRace1, playerColor1, 0, 0);
			player2 = new Player(playerName2, playerRace2, playerColor2, 0, 0);
			if (GameData.getInstance().numOfPlayer >= 3) {
				player3 = new Player(playerName3, playerRace3, playerColor3, 0, 0);
			} 
			if (GameData.getInstance().numOfPlayer >= 4) {
				player4 = new Player(playerName4, playerRace4, playerColor4, 0, 0);
			}
			
			
			// Update info on GameData.java
			GameData.getInstance().updatePlayerInfo(player1, player2, player3, player4);
			frame.dispose();
		}
	}
}
