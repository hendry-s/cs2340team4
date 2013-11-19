package game;

import gfx.Map;
import gfx.MapMuleMount;
import gfx.MapPossession;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

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
	boolean unluckyUpdated;
	boolean productionUpdated;
	boolean productionUpdatedToPlayer;
	
	Map mapLayout;
	MapPossession possessionLayout;
	MapMuleMount muleMountLayout;
	
	int[][] mapPossession;
	int[][] mapMuleMount;
	int[][] mapProduction = {
			{0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0},
			{0,0,0,0,-1,0,0,0,0},
			{0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0}
	};
	
	int timeAtCurrentTurn;
	
	int unluckyOne;
	String unluckyOneName;
	int unluckyEvent;
	String unluckyEventName;
	
	transient Random rand;
	
	
	private GameData() {
		setRound(1);
		turn = 1;
		
		possessionLayout = new MapPossession();
		muleMountLayout = new MapMuleMount();
		
		mapPossession = possessionLayout.getMapPossession();
		mapMuleMount = muleMountLayout.getMapMuleMount();
		
		int[][] mapProduction = {
				{0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0},
				{0,0,0,0,-1,0,0,0,0},
				{0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0}
		};
		
		rand = new Random();
	}
	
	private String getRandomEvent() {
		unluckyEvent = rand.nextInt(7);
		
		if (unluckyEvent == 0)
			return "A PACKAGE FROM THE GT ALUMNI, +3 FOOD AND +2 ENERGY.";
		else if (unluckyEvent == 1)
			return "YOUR ROOMMATE REPAID YOUR HOSPITALITY,  +2 ORE.";
		else if (unluckyEvent == 2)
			return "THE MUSEUM BOUGHT YOUR ANTIQUE PERSONAL COMPUTER, +$300.";
		else if (unluckyEvent == 3)
			return "YOU FOUND A DEAD MOOSE RAT AND SOLD THE HIDE, +$100.";
		else if (unluckyEvent == 4)
			return "FLYING CAT-BUGS ATE THE ROOF OFF YOUR HOUSE, -$100.";
		else if (unluckyEvent == 5)
			return "MISCHIEVOUS UGA STUDENTS BROKE IN AND STOLE HALF YOUR FOOD.";
		else
			return "YOUR SPACE GYPSY INLAWS MADE A MESS OF THE TOWN. -$300.";		
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
	
	public void updateUnluckyOne() {
		unluckyOne = rand.nextInt(numOfPlayer) + 1;
		if (unluckyOne == 1)
			unluckyOneName = player1.getName();
		else if (unluckyOne == 2)
			unluckyOneName = player2.getName();
		else if (unluckyOne == 3)
			unluckyOneName = player3.getName();
		else
			unluckyOneName = player4.getName();
		
		unluckyEventName = getRandomEvent();
	}

	public void updateTurnTime() {
		if (turn == 1) {
			if (round <= 4) {
				if (player1.getFood() >= 3) {
					timeAtCurrentTurn = 50;
				} else if (player1.getFood() <= 0 && player1.getFood() >= 3) {
					timeAtCurrentTurn = 30;
				} else {
					timeAtCurrentTurn = 5;
				}
			} else if (round <= 8) {
				if (player1.getFood() >= 4) {
					timeAtCurrentTurn = 50;
				} else if (player1.getFood() <= 0 && player1.getFood() >= 3) {
					timeAtCurrentTurn = 30;
				} else {
					timeAtCurrentTurn = 5;
				}
			} else {
				if (player1.getFood() >= 5) {
					timeAtCurrentTurn = 50;
				} else if (player1.getFood() <= 0 && player1.getFood() >= 3) {
					timeAtCurrentTurn = 30;
				} else {
					timeAtCurrentTurn = 5;
				}
			}
		} else if (turn == 2) {
			if (round <= 4) {
				if (player2.getFood() >= 3) {
					timeAtCurrentTurn = 50;
				} else if (player2.getFood() <= 0 && player2.getFood() >= 3) {
					timeAtCurrentTurn = 30;
				} else {
					timeAtCurrentTurn = 5;
				}
			} else if (round <= 8) {
				if (player2.getFood() >= 4) {
					timeAtCurrentTurn = 50;
				} else if (player2.getFood() <= 0 && player2.getFood() >= 3) {
					timeAtCurrentTurn = 30;
				} else {
					timeAtCurrentTurn = 5;
				}
			} else {
				if (player2.getFood() >= 5) {
					timeAtCurrentTurn = 50;
				} else if (player2.getFood() <= 0 && player2.getFood() >= 3) {
					timeAtCurrentTurn = 30;
				} else {
					timeAtCurrentTurn = 5;
				}
			}
		} else if (turn == 3) {
			if (round <= 4) {
				if (player3.getFood() >= 3) {
					timeAtCurrentTurn = 50;
				} else if (player3.getFood() <= 0 && player3.getFood() >= 3) {
					timeAtCurrentTurn = 30;
				} else {
					timeAtCurrentTurn = 5;
				}
			} else if (round <= 8) {
				if (player3.getFood() >= 4) {
					timeAtCurrentTurn = 50;
				} else if (player3.getFood() <= 0 && player3.getFood() >= 3) {
					timeAtCurrentTurn = 30;
				} else {
					timeAtCurrentTurn = 5;
				}
			} else {
				if (player3.getFood() >= 5) {
					timeAtCurrentTurn = 50;
				} else if (player3.getFood() <= 0 && player3.getFood() >= 3) {
					timeAtCurrentTurn = 30;
				} else {
					timeAtCurrentTurn = 5;
				}
			}
		} else {
			if (round <= 4) {
				if (player4.getFood() >= 3) {
					timeAtCurrentTurn = 50;
				} else if (player4.getFood() <= 0 && player4.getFood() >= 3) {
					timeAtCurrentTurn = 30;
				} else {
					timeAtCurrentTurn = 5;
				}
			} else if (round <= 8) {
				if (player4.getFood() >= 4) {
					timeAtCurrentTurn = 50;
				} else if (player4.getFood() <= 0 && player4.getFood() >= 3) {
					timeAtCurrentTurn = 30;
				} else {
					timeAtCurrentTurn = 5;
				}
			} else {
				if (player4.getFood() >= 5) {
					timeAtCurrentTurn = 50;
				} else if (player4.getFood() <= 0 && player4.getFood() >= 3) {
					timeAtCurrentTurn = 30;
				} else {
					timeAtCurrentTurn = 5;
				}
			}
		}		
	}
	
	public int incrementRound() {
		return setRound(getRound() + 1);
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

	public int getRound() {
		return round;
	}

	public int setRound(int round) {
		this.round = round;
		return round;
	}
	
	
	
	
	// other methods here
}

