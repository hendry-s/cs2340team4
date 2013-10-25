package turn;

import java.awt.Graphics;

public class Turn {

	LandGrant lg;
	Development dev;
	Production prod;
	Auction auc;
	Summary sum;
	
	private int turnCount;
	private int roundCount;

	
	public Turn() 
	{
		lg = new LandGrant();
		
		turnCount = 1;
		roundCount = 1;
	}
	
	public void nextTurn()
	{
		turnCount++;
		if (turnCount%2 == 1)
			roundCount++;
		
	}
	
	public int getTurnCount()
	{
		//System.out.println("Turn: " + turnCount + " Round: " + roundCount);
		return turnCount;
	}
	
	public int getRoundCount()
	{
		return roundCount;
	}
	
	public String toString()
	{
		return "Turn: " + turnCount + " Round: " + roundCount;
	}
}
