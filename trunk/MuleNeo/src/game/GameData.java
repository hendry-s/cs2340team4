package game;

import java.io.Serializable;

import org.newdawn.slick.Color;

/**
 * GameData class is singleton, holding all the data info
 * 
 * @author Jin Sim
 * @date November 15, 2013
 */
public class GameData implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 299659050051109649L;
	private volatile static GameData dataInstance;
	
	/* IntroStateTwo info */
	int level;			// 0: beginner,		1: intermediate, 2: tournament
	int map;			// 0: (default),	1: random
	int numOfPlayer;	// 2, 3, or 4
	
	/* IntroStateThree info */
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
	
	boolean donePlayer1;
	boolean donePlayer2;
	boolean donePlayer3;
	boolean donePlayer4;
	
	private GameData() {
		
	}
	
	public static GameData getInstance() {
		if (dataInstance == null) {
			synchronized(GameData.class) {
				if (dataInstance == null) {
					dataInstance = new GameData();
				}
			}
		}
		return dataInstance;
	}
	
	public void updateStateTwoInfo(IntroStateTwo isTwo) {
		this.level = isTwo.level;
		this.map = isTwo.map;
		this.numOfPlayer = isTwo.numOfPlayer;
	}
	
	public void updateStateThreeInfo(IntroStateThree isThree) {
		this.playerName1 = isThree.playerName1;
		this.playerName1 = isThree.playerName2;
		this.playerName1 = isThree.playerName3;
		this.playerName1 = isThree.playerName4;
		this.playerRace1 = isThree.playerRace1;
		this.playerRace2 = isThree.playerRace2;
		this.playerRace3 = isThree.playerRace3;
		this.playerRace4 = isThree.playerRace4;
		this.playerColor1 = isThree.playerColor1;
		this.playerColor2 = isThree.playerColor2;
		this.playerColor3 = isThree.playerColor3;
		this.playerColor4 = isThree.playerColor4;
	}

	// other methods here
}

