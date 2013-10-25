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
	boolean roundNew = false;

	
	public Turn() 
	{
		lg = new LandGrant();
		
		turnCount = 0;	// starting at 0 for code to work.
		roundCount = 0;
	}
	
	public void nextTurn()
	{
		turnCount++;
		if (turnCount%2 == 1)
		{
			System.out.println("nope!");
			roundCount++;
		}
			
		
	}
	
	public boolean getRoundNew()
	{
		return roundNew;
	}
	
	public void setRoundNew(boolean c)
	{
		roundNew = c;
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
	
	public String toString()
	{
		return "Turn: " + turnCount + " Round: " + roundCount;
	}
}
