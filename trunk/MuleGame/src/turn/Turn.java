package turn;

import java.awt.Graphics;

import entities.Player;
import game.Screen3;

/**
 * Turn class contains info of the each turn instance
 * @author  Aim4C++
 * @date November 10, 2013
 */
// Javadoc written by Jin
public class Turn {

	/* The 5 below instances are NOT USED
	 * 	Likely to be removed
	 */
//	LandGrant lg;
//	Development dev;
//	Production prod;
//	Auction auc;
//	Summary sum;
	
	private int turnCount;
	private int roundCount;
	
	private Player p1;
	private Player p2;
	private Player[] order;	// Array used to determine turn order.
	private int index;
	
	private int turnTime;
	
	/**
	 * Default Constructor.
	 * 
	 * Receives 2 Player instances from Screen3 class,
	 * then set the player's order of the play in the current turn
	 * 	(will be updated later as the scores are updated later on)
	 * then initialize the turnCount and roundCount (start from 1)
	 * 
	 * 
	 */
	public Turn() 
	{
		this.p1 = Screen3.getPlayers()[0];
		this.p2 = Screen3.getPlayers()[1];
		order = new Player[]{p1, p2};
		
		/* Deprecated */
//		lg = new LandGrant();
		
		turnCount = 1;	// starting at 0 for code to work.
		roundCount = 1;
	}
	
	/**
	 * turnCount++
	 */
	public void incrementTurnCount()
	{
		turnCount++;
		if (turnCount%2 == 1)	///////// Jin: What is this?
		{
			//System.out.println("Round Incremented!"); // DEBUG purposes
			roundCount++;
		}
	}

	/**
	 * Getter for turnCount
	 */	
	public int getTurnCount()
	{
		//System.out.println("Turn: " + turnCount + " Round: " + roundCount); // DEBUG purposes
		return turnCount;
	}
	
	/**
	 * Getter for roundCount
	 */
	public int getRoundCount()
	{
		return roundCount;
	}
	
	/**
	 * Getter for roundCount
	 */
	public Player getPlayerTurn()
	{	
		Player play = order[index];
		return play;
	}
	
	/**
	 * When the turn ends, index increments so that.... (NOT IMPLEMENTED YET)
	 * JIN: I suppose this should be endRound()
	 */
	public void endPlayerTurn()
	{
		index++;
	}
	
	
	/**
	 * Checks if the LandSelection is complete, if so
	 * by checking index==order.length,
	 * then reset the index to 0 for the next turn land selection
	 * @return a boolean signifying is the land selection phase is complete for this turn
	 */
	public boolean isLandSelectComplete()
	{
		if (index == order.length)
		{
			index = 0; // Reset index for player turns now.
			return true;
		}
		else
			return false;
	}
	
	/**
	 * Checks if the current round is complete, if so
	 * by checking index==order.length,
	 * then reset the index to 0 for the next round
	 * 
	 * @see isLandSelectComplete()	// what's the difference? JIN
	 * 
	 * @return a boolean signifying is the current round,
	 *	 including land selection phase, is complete.
	 */
	public boolean isRoundComplete()
	{
		if (index == order.length)
		{
			index = 0;
			calculatePlayerOrder();	// Helper method
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
	/**
	 * Summarize the scores of the player, after each round.
	 * 	(Helper method of isRoundComplete())
	 * 
	 */
	private void calculatePlayerOrder()
	{
		int p1Score = p1.getMoney() + p1.getFood() + p1.getEnergy() + p1.getOre();
		int p2Score = p2.getMoney() + p2.getFood() + p2.getEnergy() + p2.getOre();
		
		System.out.println("p1Score: " + p1Score + ", p2Score: " + p2Score); // DEBUG purposes
		
		if (p1Score >= p2Score)
		{
			order[0] = p1;
			order[1] = p2;
		}
		else if (p1Score < p2Score)
		{
			order[0] = p2;
			order[1] = p1;
		}
	}
	
	
	/**
	 * Getter for the length of time that the player gets
	 * for the current turn. This turn time is re-calculated
	 * every turn, based on the amount of energy that the player holds.
	 * 
	 * @return turnTime
	 * 
	 */
	public int getPlayerTurnTime()
	{		
		Player player = getPlayerTurn();
		turnTime = player.getEnergy() * 3000;	// 4000 miliseconds = 4 seconds
		
		return turnTime;	// returns in miliseconds.
	}
	
	
	/**
	 * Assigns penalty to current turn time, then returns it
	 * 
	 * @return turnTime with penalty
	 * 
	 */
	public int decrementPlayerTurnTime()
	{
		turnTime -= 1000; // By one second (1000 miliseconds)
		return turnTime;
	}
	
	/**
	 * Returns the string that summarize current turn/round status
	 * 
	 * @return current turn/round status
	 * 
	 */
	public String toString()
	{
		return "Turn: " + turnCount + " Round: " + roundCount;
	}
}
