package entities;

import java.awt.Color;
import java.awt.Graphics;

import gfx.Auction;
import gfx.Map;
import gfx.Town;

/**
 * The Player class represents a player of the game. 
 * @author  Aim4C++
 * @version Oct 25, 2013
 * 
 */
public class Player extends Character {

	protected String name;
	protected Color color;
	protected String race;
	protected int money;
	protected int energy;
	protected int food;
	protected int ore;
	protected boolean hasMuleInMap;
	protected boolean hasEmptyLand;
	
	/**
	 * Default constructor.
	 * @param name Name of the player
	 * @param color Color of the player
	 * @param race Race of the player
	 **/
	public Player(String name, Color color, String race) {
		
		if (name.equals(""))
			this.name = "No Name";
		else
			this.name = name;
		this.color = color;
		this.race = race;
	}
	
	
	/**
	 * Render method (overriding of its parent, Character class)
	 * @param g Graphics object
	 * 
	 * NOTE: Unimplemented yet
	 **/
	@Override
	public void render(Graphics g) {
		
		
	}
	
	/**
	 * Setter for x and y coordinates
	 * @param x X-coordinate
	 * @param y Y-coordinate
	 * 
	 **/
	public void setCoord(int x, int y) {
		
		super.x = x;
		super.y = y;
	}
	
	/**
	 * Setter map object that the player is placed in currently
	 * @param map Map object
	 **/
	public void setMap(Map map) {
		
		super.map = map;
	}

	/**
	 * Setter town object that the player is placed in currently
	 * @param town Town object
	 **/
	public void setTown(Town town) {
		
		super.town = town;
	}
	
	/**
	 * Getter for player's name
	 * @return name of the player
	 **/
	public String getName(){
		return name;
	}
	
	/**
	 * Getter for player's color
	 * @return color of the player
	 **/
	public Color getColor(){
		return color;
	}
	
	/**
	 * Getter for player's race
	 * @return race of the player
	 **/
	public String getRace() {
		
		return race;
	}
	
	/**
	 * Getter for player's current money
	 * @return the amount of money that the player has
	 **/
	public int getMoney()
	{
		return money;
	}
	
	public int getEnergy()
	{
		return energy;
	}
	
	public int getFood()
	{
		return food;
	}
	
	public int getOre()
	{
		return ore;
	}
	
	/**
	 * Make a purchase out of the player's asset
	 * @param price Price of an item purchased
	 **/
	public void purchase(int price, String product)
	{
		money -= price;
		
		switch (product)
		{
			case "Food":
				food++;
				break;
			case "Energy":
				energy++;
				break;
			case "Ore":
				ore++;
				break;
			case "Mule":
				System.out.println("Mule quantity not implemented yet");
				break;
		}
	}
	
	/**
	 * Add money won from gambling to player's money.
	 * @param moneyWon Money won from gambling.
	 */
	
	public void gambleMoneyWon(int moneyWon)
	{
		money += moneyWon;
	}
}
