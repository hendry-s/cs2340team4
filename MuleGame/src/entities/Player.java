package entities;

import java.awt.Color;
import java.awt.Graphics;

import gfx.Auction;
import gfx.Map;
import gfx.Town;

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
	
	public Player(String name, Color color, String race) {
		
		if (name.equals(""))
			this.name = "No Name";
		else
			this.name = name;
		this.color = color;
		this.race = race;
	}
	
	@Override
	public void render(Graphics g) {
		
		
	}
	
	public void setCoord(int x, int y) {
		
		super.x = x;
		super.y = y;
	}
	
	public void setMap(Map map) {
		
		super.map = map;
	}
	
	public void setTown(Town town) {
		
		super.town = town;
	}
	
	public String getName(){
		return name;
	}
	
	public Color getColor(){
		return color;
	}
	
	public String getRace() {
		
		return race;
	}
	
	public int getMoney()
	{
		return money;
	}
	
	public void purchase(int price)
	{
		money -= price;
	}
}
