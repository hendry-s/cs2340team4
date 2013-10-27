package turn;

import java.awt.Graphics;

import entities.Player;
import game.Screen3;

public class Turn {

	LandGrant lg;
	Development dev;
	Production prod;
	Auction auc;
	Summary sum;
	
	private int turnCount;
	private int roundCount;
	private int landGrantTurn;	// Determines which player is selecting Land. 0 = p1, 1 = p2, 2 = land grant over
	
	private Player p1;
	private Player p2;
	private Player[] order;	// Array used to determine turn order.
	private int index;
	
	public Turn() 
	{
		this.p1 = Screen3.getPlayers()[0];
		this.p2 = Screen3.getPlayers()[1];
		order = new Player[]{p1, p2};
		
		lg = new LandGrant();
		
		turnCount = 0;	// starting at 0 for code to work.
		roundCount = 0;
	}
	
	public void incrementTurnCount()
	{
		turnCount++;
		if (turnCount%2 == 1)
		{
			System.out.println("Round Incremented!"); // DEBUG purposes
			roundCount++;
		}
	}

	
	public int getTurnCount()
	{
		System.out.println("Turn: " + turnCount + " Round: " + roundCount);
		return turnCount;
	}
	
	public int getRoundCount()
	{
		return roundCount;
	}
	
	public int getLandGrantTurn()
	{
		return landGrantTurn;
	}
	
	public void updateLandGrantTurn()
	{
		if (landGrantTurn != 2)
			landGrantTurn++;
		else
			landGrantTurn = 0;
	}
	
	public String toString()
	{
		return "Turn: " + turnCount + " Round: " + roundCount;
	}
}
