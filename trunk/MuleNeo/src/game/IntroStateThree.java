package game;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.UnicodeFont;
import org.newdawn.slick.gui.TextField;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class IntroStateThree extends BasicGameState {

	Input input;
	int posX;
	int posY;
	
	String playerName1 = null;
	String playerName2 = null;
	String playerName3 = null;
	String playerName4 = null;
	
	JFrame frame;
	JTextField field;
	JTextArea area;
	
	int playerRace1;	// (Bonzoid 0) (Buzzite 1) (Flapper 2) (Human 3) (Ugaite 4) 
	int playerRace2;
	int playerRace3;
	int playerRace4;
	
	Color playerColor1;	// RED
	Color playerColor2;	// BLUE
	Color playerColor3;	// YELLOW
	Color playerColor4;	// GREEN
	
	boolean donePlayerName1;
	boolean donePlayerName2;
	boolean donePlayerName3;
	boolean donePlayerName4;
	
	boolean donePlayer1;
	boolean donePlayer2;
	boolean donePlayer3;
	boolean donePlayer4;
	
	@Override
	public void init(GameContainer container, StateBasedGame sbg)
			throws SlickException {
		// TODO Auto-generated method stub
		
		if (GameData.getInstance().numOfPlayer >= 2) {
			playerName1 = "One";
			playerName2 = "Two";
		} if (GameData.getInstance().numOfPlayer >= 3) {
			playerName3 = "Three";
		} if (GameData.getInstance().numOfPlayer == 4) {
			playerName4 = "Four";
		}
		
		donePlayer1 = false;
		donePlayer2 = false;
		donePlayer3 = false;
		donePlayer4 = false;
		
		donePlayerName1 = false;
		donePlayerName2 = false;
		donePlayerName3 = false;
		donePlayerName4 = false;
		
		playerRace1 = 0;
		playerRace2 = 0;
		playerRace3 = 0;
		playerRace4 = 0;
		
		playerColor1 = Color.red;
		playerColor2 = Color.blue;
		playerColor3 = Color.yellow;
		playerColor4 = Color.green;
		
		input = container.getInput();
		
		frame = new JFrame("Enter the Player Name");
		
	}
	

	@Override
	public void update(GameContainer container, StateBasedGame sbg, int delta)
			throws SlickException {
		
		if (container.getInput().isMouseButtonDown(0)) {
			GameData.getInstance().updateStateThreeInfo(this);
			sbg.enterState(3);
		}
		
		
		
	}
	
	@Override
	public void render(GameContainer container, StateBasedGame sbg, Graphics g)
			throws SlickException {
		posX = input.getMouseX();
		posY = input.getMouseY();
		
		g.drawString("(x,y) " + posX + "  " + posY, 100, 300); // debug
		
//		g.drawString("Player 1 Name: ", 100, 100);
		g.drawString("Click to Proceed", 500, 500);
		
	}

	

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 2;
	}

}
