package game;

import gfx.Map;
import gfx.MapMuleMount;
import gfx.MapPossession;

import java.io.Serializable;
import java.util.ArrayList;

import model.Player;
import model.Store;

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
	public int level;			// 0: beginner,		1: intermediate, 2: tournament
	int map;			// 0: (default),	1: random
	int numOfPlayer;	// 2, 3, or 4
	
	
	/* Turn-related info */
	int round;	// upto 12 rounds
	int turn;
	final int MAX_ROUND = 12;
	final int MAX_TURN = numOfPlayer;
	
	Player player1 = null;
	Player player2 = null;
	Player player3 = null;
	Player player4 = null;
	
	static Store store = new Store();
	
	boolean justFromMuleMountState;
	boolean justFromTownState;
	boolean roundInitiated;
	boolean turnJustStarted; // as we enter TownState after LandGrant

	boolean landSelectionDone;
	
	Map mapLayout;
	MapPossession possessionLayout;
	MapMuleMount muleMountLayout;
	
	int[][] mapPossession;
	int[][] mapMuleMount;
	
	int timeAtCurrentTurn;
	
	
	
	private GameData() {
		round = 1;
		turn = 1;
		
		mapLayout = new Map(0);
		possessionLayout = new MapPossession();
		muleMountLayout = new MapMuleMount();
		
		mapPossession = possessionLayout.getMapPossession();
		mapMuleMount = muleMountLayout.getMapMuleMount();
		
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
		this.setLevel(isTwo.level);
		this.numOfPlayer = isTwo.numOfPlayer;
		if (isTwo.map == 0) {
			mapLayout = new Map(0);
		} else {
			mapLayout = new Map(1);
		}
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

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}
	
	
	
	
	// other methods here
}

