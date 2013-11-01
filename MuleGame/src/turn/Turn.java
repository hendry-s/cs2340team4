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
	
	private Player p1;
	private Player p2;
	private Player[] order;	// Array used to determine turn order.
	private int index;
	
	private int turnTime;
	
	public Turn() 
	{
		this.p1 = Screen3.getPlayers()[0];
		this.p2 = Screen3.getPlayers()[1];
		order = new Player[]{p1, p2};
		
		lg = new LandGrant();
		
		turnCount = 1;	// starting at 0 for code to work.
		roundCount = 1;
	}
	
	public void incrementTurnCount()
	{
		turnCount++;
		if (turnCount%2 == 1)
		{
			//System.out.println("Round Incremented!"); // DEBUG purposes
			roundCount++;
		}
	}

	
	public int getTurnCount()
	{
		//System.out.println("Turn: " + turnCount + " Round: " + roundCount); // DEBUG purposes
		return turnCount;
	}
	
	public int getRoundCount()
	{
		return roundCount;
	}
	
	public Player getPlayerTurn()
	{	
		Player play = order[index];
		return play;
	}
	
	public void endPlayerTurn()
	{
		index++;
	}
	
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
	
	public int getPlayerTurnTime()
	{		
		Player player = getPlayerTurn();
		turnTime = player.getEnergy() * 3000;	// 4000 miliseconds = 4 seconds
		
		return turnTime;	// returns in miliseconds.
	}
	
	public int decrementPlayerTurnTime()
	{
		turnTime -= 1000; // By one second (1000 miliseconds)
		return turnTime;
	}
	
	public String toString()
	{
		return "Turn: " + turnCount + " Round: " + roundCount;
	}
}
