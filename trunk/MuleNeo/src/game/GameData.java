package game;

import java.io.Serializable;

import model.Player;

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
	
	Player player1 = null;
	Player player2 = null;
	Player player3 = null;
	Player player4 = null;

/*
	String playerName1 = null;
	String playerName2 = null;
	String playerName3 = null;
	String playerName4 = null;
	
	int playerRace1;	// (Bonzoid 0) (Buzzite 1) (Flapper 2) (Human 3) (Ugaite 4) 
	int playerRace2;
	int playerRace3;
	int playerRace4;
	
	int playerColor1;	// RED
	int playerColor2;	// BLUE
	int playerColor3;	// YELLOW
	int playerColor4;	// GREEN
*/
	
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

	public void updatePlayerInfo(Player player1, Player player2, 
			Player player3, Player player4) {
		this.player1 = player1;
		this.player2 = player2;
		this.player3 = player3;
		this.player4 = player4;
	}

	public int incrementRound() {
		return ++round;
	}
	
	public int incrementTurn() {
		return ++turn;
	}
	
	// other methods here
}

