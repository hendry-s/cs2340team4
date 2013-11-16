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
	int round;	// upto 12 rounds
	int turn;
	final int MAX_ROUND = 12;
	final int MAX_TURN = numOfPlayer;
	
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
	
	private GameData() {
		round = 1;
		turn = 1;
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

	public void updatePlayerInfo(PlayerInfoFrame frame) {
		this.playerName1 = frame.playerName1;
		this.playerName1 = frame.playerName2;
		this.playerName1 = frame.playerName3;
		this.playerName1 = frame.playerName4;
		this.playerRace1 = frame.playerRace1;
		this.playerRace2 = frame.playerRace2;
		this.playerRace3 = frame.playerRace3;
		this.playerRace4 = frame.playerRace4;
		this.playerColor1 = frame.playerColor1;
		this.playerColor2 = frame.playerColor2;
		this.playerColor3 = frame.playerColor3;
		this.playerColor4 = frame.playerColor4;
		
	}

	// other methods here
}

